package org.smartboot.socket.protocol.p2p.client;

import org.smartboot.socket.protocol.p2p.message.BaseMessage;
import org.smartboot.socket.service.process.MessageProcessor;
import org.smartboot.socket.transport.AioQuickClient;
import org.smartboot.socket.transport.AioSession;

import java.nio.channels.AsynchronousChannelGroup;
import java.util.concurrent.ThreadFactory;

public class P2PMaxConnectClient {
    public static void main(String[] args) throws Exception {
        AsynchronousChannelGroup asynchronousChannelGroup = AsynchronousChannelGroup.withFixedThreadPool(Runtime.getRuntime().availableProcessors(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        });
        int num = 0;
        try {
            while (true) {
                final AioQuickClient<BaseMessage> client = new AioQuickClient<BaseMessage>(asynchronousChannelGroup)
                        .setProcessor(new MessageProcessor<BaseMessage>() {
                            @Override
                            public void process(AioSession<BaseMessage> session, BaseMessage msg) throws Exception {

                            }

                            @Override
                            public void initSession(AioSession<BaseMessage> session) {

                            }
                        })
                        .connect("127.0.0.1", 8888);
                client.start();
                num++;
                Thread.sleep(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("已连接客户端：" + num);
        }
        asynchronousChannelGroup.shutdown();
    }
}
