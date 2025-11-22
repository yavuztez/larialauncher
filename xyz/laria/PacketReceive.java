package xyz.laria;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import network.sonoyuncu.launcher.soclient.SOClient;
import org.apache.logging.log4j.LogManager;

public class PacketReceive extends SimpleChannelInboundHandler {
    private SimpleChannelInboundHandler packetHandler;
    private Channel channel;
    final SOClient soClient;

    public PacketReceive(SOClient soClient) {
        this.soClient = soClient;
    }

    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        this.channel = null;
        LogManager.getRootLogger().info("[MinecraftNetworkModule] 1.8.9-Optifine-Ultra_ için paket dinleme bağlantı koptuğundan devredışı.");
    }

    public void active(ChannelHandlerContext channelHandlerContext) {
        this.channel = channelHandlerContext.channel();
        LogManager.getRootLogger().info("[MinecraftNetworkModule] 1.8.9-Optifine-Ultra_ için paket dinleme aktif edildi.");
    }

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        this.active(ctx);
    }

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object packet) throws Exception {
        if (this.channel == null) {
            this.active(channelHandlerContext);
        }

        if (this.packetHandler == null) {
            this.packetHandler = (SimpleChannelInboundHandler)channelHandlerContext.pipeline().get("packet_handler");
        }

        this.packetHandler.channelRead(channelHandlerContext, packet);
    }
}
