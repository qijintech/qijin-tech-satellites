package tech.qijin.satellites.websocket.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.Future;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.qijin.satellites.websocket.config.WebSocketProperties;
import tech.qijin.util4j.utils.LogFormat;

import javax.annotation.PostConstruct;

/**
 * @author michealyang
 * @date 2019/1/24
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Component
@Slf4j
public class WebsocketServer implements Runnable {
    private ChannelFuture serverChannelFuture;
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;

    private WebSocketProperties webSocketProperties;
    private WebSocketServerInitializer webSocketServerInitializer;

    public WebsocketServer(WebSocketProperties webSocketProperties,
                           WebSocketServerInitializer webSocketServerInitializer) {
        this.webSocketProperties = webSocketProperties;
        this.webSocketServerInitializer = webSocketServerInitializer;
    }

    @Override
    public void run() {
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
                    .childHandler(webSocketServerInitializer);

            serverChannelFuture = b.bind(webSocketProperties.getPort()).sync();
            log.info(LogFormat.builder().message("WebSocket started")
                    .put("port", webSocketProperties.getPort()).build());
            serverChannelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            log.error(LogFormat.builder().message("WebSocket interrupted").build(), e);
        } finally {
            close();
        }
    }

    /**
     * 描述：关闭Netty Websocket服务器，主要是释放连接
     * 连接包括：服务器连接serverChannel，
     * 客户端TCP处理连接bossGroup，
     * 客户端I/O操作连接workerGroup
     * <p>
     * 若只使用
     * bossGroupFuture = bossGroup.shutdownGracefully();
     * workerGroupFuture = workerGroup.shutdownGracefully();
     * 会造成内存泄漏。
     */
    public void close() {
        serverChannelFuture.channel().close();
        Future<?> bossGroupFuture = bossGroup.shutdownGracefully();
        Future<?> workerGroupFuture = workerGroup.shutdownGracefully();

        try {
            bossGroupFuture.await();
            workerGroupFuture.await();
        } catch (InterruptedException ignore) {
            ignore.printStackTrace();
        }
    }
}
