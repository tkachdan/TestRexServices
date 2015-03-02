package Services.Impl;


import Services.DeviceManager;
import persistence.DAO.Impl.DeviceDAOImpl;
import persistence.model.Device;

/**
 * Created by dan on 2.3.15.
 */
public class DeviceManagerImpl implements DeviceManager {
    DeviceDAOImpl deviceDAO = new DeviceDAOImpl();
    @Override
    public Device getDevice(String id) {
        return deviceDAO.getObjectById(id);
    }

    @Override
    public boolean isDeviceExists(String deviceId) {
        return deviceDAO.isObjectInDatabase(deviceId);
    }
}
