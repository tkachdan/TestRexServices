package Services;

/**
 * Created by dan on 2.3.15.
 */
public interface PacketReceiver {

    public void setDeviceManager(DeviceManager mngr);

    public void setPositionManager(PositionManager mngr);

    public void receivePacket(String packet);
}