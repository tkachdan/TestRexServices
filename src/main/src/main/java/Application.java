import Services.DeviceManager;
import Services.Impl.DeviceManagerImpl;
import Services.Impl.PacketReceiverImpl;
import Services.PacketReceiver;
import persistence.DAO.Impl.DeviceDAOImpl;
import persistence.model.Device;

/**
 * Created by dan on 2.3.15.
 */
public class Application {
    public static void main(String[] args) {
        DeviceManager deviceManager = new DeviceManagerImpl();
        DeviceDAOImpl deviceDaoImpl = new DeviceDAOImpl();
        Device device = new Device("firstId");
        Device device1 = new Device("secondId");

        deviceDaoImpl.createObject(device);
        deviceDaoImpl.createObject(device1);

        PacketReceiver positionManager = new PacketReceiverImpl();
        positionManager.receivePacket("AfirstId;GF;6;1;140725;130000!");
    }

}
