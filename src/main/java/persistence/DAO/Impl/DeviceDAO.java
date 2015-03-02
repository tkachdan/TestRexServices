package persistence.DAO.Impl;

import persistence.model.Device;

import java.util.List;

/**
 * Created by dan on 2.3.15.
 */
public class DeviceDAO extends DAOImpl<Device> {
    @Override
    public boolean createObject(Device device) {
        return super.createObject(device);
    }

    @Override
    public Device readObjectById(int id, Class<Device> deviceClass) {
        return super.readObjectById(id, deviceClass);
    }

    @Override
    public boolean updateObject(Device device) {
        return super.updateObject(device);
    }

    @Override
    public boolean deleteObject(int id, Class<Device> deviceClass) {
        return super.deleteObject(id, deviceClass);
    }

    @Override
    public boolean isObjectInDatabase(int id, Class<Device> deviceClass) {
        return super.isObjectInDatabase(id, deviceClass);
    }

    @Override
    public List<Device> getAllObjects(Class<Device> deviceClass) {
        return super.getAllObjects(deviceClass);
    }
}
