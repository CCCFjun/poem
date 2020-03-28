package com.mwt.oes.controller;

import com.mwt.oes.websocket.WebSocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@CrossOrigin
@RestController
@RequestMapping("/api/websocket")
public class WebSocketController {

    @RequestMapping(value = "/pushMsgToHtml",method = RequestMethod.GET)
    @ResponseBody
    public String pushMsgToHtml() throws IOException{
        CopyOnWriteArraySet<WebSocketServer> webSocketSet = WebSocketServer.webSocketSet;
        for(WebSocketServer webSocketServer : webSocketSet){
            webSocketServer.sendMessage("你好客户端.....我是服务端");
        }

        return "200";
    }

}
