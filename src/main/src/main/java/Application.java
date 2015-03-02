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
    //POS {lon};{lat};{date};{time};{spd};{alt}
    //A57848;POS;14.609;49.896;140725;121518;22;505!
    //GF  {zone};{io};{date};{time}
    //A512;GF;6;1;140725;130000!
    public static void main(String[] args) {
        DeviceManager deviceManager = new DeviceManagerImpl();
        DeviceDAOImpl deviceDaoImpl = new DeviceDAOImpl();
        Device device = new Device("firstId");
        Device device1 = new Device("secondId");

        deviceDaoImpl.createObject(device);
        deviceDaoImpl.createObject(device1);

        System.out.println(deviceManager.getDevice("secondId"));

        PacketReceiver positionManager = new PacketReceiverImpl();
        positionManager.receivePacket("A512;GF;6;1;140725;130000!");
    }

}
