
## satellites-websocket

### 使用方法

**Step1: 引入依赖**
```xml
<dependency>
    <groupId>tech.qijin.satellites</groupId>
    <artifactId>satellites-websocket</artifactId>
    <version>${satellites.version}</version>
</dependency>
```

**Step2: 实现SPI**

SPI接口为: `tech.qijin.satellites.websocket.spi.WebSocketProvider`

默认值:

`port`: 3309

`uri`: /connect

**Step3: 自定义配置**

如果要自定义websocket port和websocket连接uri，请创建websocket-env.properties，并在其中填写自己的配置

注：env表示环境，支持`dev`、`test`、`prod`

注：uri用于websocket连接。只有匹配的uri才能进行websocket连接，其他uri会被拒绝。


### TODO

* WebSocket handshake可能需要RPC调用，比较耗时，会阻塞netty worker线程
* 业务处理暂时也没使用多线程与worker线程隔离，后续需要优化

