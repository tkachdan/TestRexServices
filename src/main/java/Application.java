import Impl.PacketReceiverImpl;
import Services.PacketReceiver;

/**
 * Created by dan on 2.3.15.
 */
public class Application {
    public static void main(String[] args) {


    PacketReceiver positionManager = new PacketReceiverImpl();
        positionManager.receivePacket("A512;GF;6;1;140725;130000!");
    }

}
