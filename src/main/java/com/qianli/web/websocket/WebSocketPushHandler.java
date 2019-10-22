package com.qianli.web.websocket;

import com.qianli.pojo.Message;
import com.qianli.pojo.QueryVo;
import com.qianli.pojo.Users;
import com.qianli.service.FlagService;
import com.qianli.service.MessageService;
import com.qianli.service.UserService;
import com.qianli.utils.GsonUtils;
import com.voiweb.utils.commons.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * 消息处理类
 *
 * @param <WebSocketSession>
 * @author ts
 */

public class WebSocketPushHandler<WebSowcketSession> implements WebSocketHandler {


    @Autowired
    private FlagService flagService;
    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    // private static List<Users> users = userService.findAll();
    private static final ArrayList<WebSocketSession> users = new ArrayList<>();

    /**
     * webscoket建立好链接之后的处理函数--连接建立后的准备工作
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        try {
            System.out.print("连接成功");
            users.add(session);
            //  System.out.println("当前用户数量: " + users.size());
            Users user = (Users) session.getAttributes().get("user");
            int userId = user.getUid();
            System.out.println("用户名 " + user.getUsername());
            System.out.println("用户ID " + userId);
            //将当前的连接的用户会话放入MAP,key是用户编号


            int number = flagService.findcount(userId);
            String num = String.valueOf(number);

            TextMessage message = new TextMessage(num);

            sendMessage(session, message);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void sendMessage(WebSocketSession session, TextMessage message) {
        try {
            if (session.isOpen()) {
                session.sendMessage(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        try {


            //如果消息没有任何内容，则直接返回
            if (message.getPayloadLength() == 0)
                return;
            //反序列化服务端收到的json消息
            Message msg = GsonUtils.fromJson(message.getPayload().toString(), Message.class);


            msg.setCreate_time(DateConverter.today("yyyy-MM-dd HH:mm:ss"));
            System.out.println(msg.toString());
            messageService.save(msg);
            //	System.out.println("消息（可存数据库作为历史记录）:"+message.getPayload().toString());
            //判断是群发还是单发
            if (msg.getTouser() == null || msg.getTouser().equals("-1")) {
                //群发
                sendMessagesToUsers(session, new TextMessage(GsonUtils.toJson(msg)));
            } else {
                //单发
                sendMessageToUser(session, msg.getMid(), msg.getTouser(), new TextMessage(GsonUtils.toJson(msg)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //后台错误信息处理方法
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    //用户退出后的处理，不如退出之后，要将用户信息从websocket的session中remove掉，这样用户就处于离线状态了，也不会占用系统资源
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        if (session.isOpen()) {
            session.close();
            users.remove(session);
        }

    }

    /**
     * 是否支持处理拆分消息，返回true返回拆分消息
     */
    //是否支持部分消息：如果设置为true，那么一个大的或未知尺寸的消息将会被分割，并会收到多次消息（会通过多次调用方法handleMessage(WebSocketSession, WebSocketMessage). ）
    //如果分为多条消息，那么可以通过一个api：org.springframework.web.socket.WebSocketMessage.isLast() 是否是某条消息的最后一部分。
    //默认一般为false，消息不分割
    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 给所有的用户发送消息
     */
    public void sendMessagesToUsers(WebSocketSession session, TextMessage message) {

        try {

            if (session.isOpen()) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 发送消息给指定的用户
     *
     * @param id
     */
    public void sendMessageToUser(WebSocketSession session, int mid, String userId, TextMessage message) {


        try {
            //isOpen()在线就发送
            if (session.isOpen()) {
                Message msg = GsonUtils.fromJson(message.getPayload().toString(), Message.class);
                //session.sendMessage(message);
                Users user = userService.getUserByUid(Integer.parseInt(userId));
                List<Users> uList = new ArrayList<>();
                uList.add(user);
                QueryVo vo = new QueryVo();
                vo.setUserlist(uList);
                vo.setMid(mid);
                messageService.relase(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}