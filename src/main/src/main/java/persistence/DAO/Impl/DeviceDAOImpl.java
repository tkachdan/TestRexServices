package persistence.DAO.Impl;

import org.hibernate.Session;
import persistence.model.Device;
import util.HibernateService;

import java.util.List;

/**
 * Created by dan on 2.3.15.
 */
public class DeviceDAOImpl extends DAOImpl<Device> {
    @Override
    public boolean createObject(Device device) {
        return super.createObject(device);
    }

    public Device getObjectById(String id) {
        Session session = HibernateService.getSession();
        session.beginTransaction();
        Device device = (Device) session
                .createQuery("from Device"  + " where id = :itemId")
                .setString("itemId", id).uniqueResult();

        session.getTransaction().commit();
        session.close();
        return device;
    }

    @Override
    public boolean updateObject(Device device) {
        return super.updateObject(device);
    }

    @Override
    public boolean deleteObject(int id, Class<Device> deviceClass) {
        return super.deleteObject(id, deviceClass);
    }

    public boolean isObjectInDatabase(String id) {
        return this.getObjectById(id) != null;
    }

    @Override
    public List<Device> getAllObjects(Class<Device> deviceClass) {
        return super.getAllObjects(deviceClass);
    }
}
