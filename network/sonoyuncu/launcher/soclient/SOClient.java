
package network.sonoyuncu.launcher.soclient;

import io.netty.channel.Channel;
import io.netty.util.concurrent.GenericFutureListener;
import org.apache.logging.log4j.LogManager;
import xyz.laria.PacketReceive;
import xyz.laria.PacketSent;
import xyz.laria.utils.PayloadUtils;

public abstract class SOClient {
    private static SOClient W;

    public SOClient() {
        if (W != null) {
            throw new RuntimeException("Laria Client ile Laria Launcher bağlantısı zaten kurulmuş.");
        }
        W = this;
        LogManager.getRootLogger().info("Laria Launcher ve Laria Client bağlantısı kuruldu.");
    }

    public static SOClient getInstance() {
        return W;
    }

    public String lookForNewSessionID(String string) {
        return "";
    }

    public void network_onServerConnect(String string, int n, Channel channel) throws Exception {
    }

    public static boolean isInitialized() {
        return W != null;
    }

    public abstract byte[] pluginMessage_serverSide_getMessage(Object var1);

    public abstract String pluginMessage_serverSide_getChannelTag(Object var1);

    public abstract Object pluginMessage_clientSide_createPacket(String var1, byte[] var2);

    public abstract int network_getServerboundPacketID(Object var1);

    public abstract int network_getClientboundPacketID(Object var1);

    public abstract void network_sendPacket(Object var1, Channel var2, GenericFutureListener ... var3);

    public void network_snoopNetwork(Channel channel) {
        if (channel.pipeline().get("solauncher_receive") == null && channel.pipeline().get("packet_handler") != null) {
            channel.pipeline().addBefore("packet_handler", "solauncher_receive", new PacketReceive(this));
            channel.pipeline().addLast("solauncher_send", new PacketSent());
        }
    }

    public String network_createPayload() {
        return PayloadUtils.getPayload();
    }
}
 