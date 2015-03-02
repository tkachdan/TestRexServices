package persistence.DAO.Impl;

import persistence.model.Position;

import java.util.List;

/**
 * Created by dan on 2.3.15.
 */
public class PositionDAOImpl extends DAOImpl<Position> {
    @Override
    public boolean createObject(Position position) {
        return super.createObject(position);
    }

    @Override
    public Position getObjectById(int id, Class<Position> positionClass) {
        return super.getObjectById(id, positionClass);
    }

    @Override
    public boolean updateObject(Position position) {
        return super.updateObject(position);
    }

    @Override
    public boolean deleteObject(int id, Class<Position> positionClass) {
        return super.deleteObject(id, positionClass);
    }

    @Override
    public boolean isObjectInDatabase(int id, Class<Position> positionClass) {
        return super.isObjectInDatabase(id, positionClass);
    }

    @Override
    public List<Position> getAllObjects(Class<Position> positionClass) {
        return super.getAllObjects(positionClass);
    }
}
