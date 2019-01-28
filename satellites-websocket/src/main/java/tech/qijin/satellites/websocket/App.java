package tech.qijin.satellites.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import tech.qijin.satellites.websocket.server.WebSocketServerInitializer;
import tech.qijin.util4j.utils.LogFormat;

/**
 * @author michealyang
 * @date 2019/1/25
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Slf4j
public class App {
    public static void main(String[] args) {
        log.info("app main");
        ChannelFuture serverChannelFuture;
        EventLoopGroup bossGroup;
        EventLoopGroup workerGroup;
        bossGroup = new NioEventLoopGroup(1);
        workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024) //配置TCP参数，握手字符串长度设置
                    .option(ChannelOption.TCP_NODELAY, true) //TCP_NODELAY算法，尽可能发送大块数据，减少充斥的小块数据
                    .childOption(ChannelOption.SO_KEEPALIVE, true)//开启心跳包活机制，就是客户端、服务端建立连接处于ESTABLISHED状态，超过2小时没有交流，机制会被启动
                    .childOption(ChannelOption.RCVBUF_ALLOCATOR, new FixedRecvByteBufAllocator(592048))//配置固定长度接收缓存区分配器
                    .childHandler(new WebSocketServerInitializer());

            serverChannelFuture = b.bind(3302).sync();
            log.info(LogFormat.builder().message("WebSocket started").build());
            serverChannelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            log.error(LogFormat.builder().message("WebSocket interrupted").build(), e);
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
