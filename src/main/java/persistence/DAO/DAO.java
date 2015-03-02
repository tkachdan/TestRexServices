package persistence.DAO;

/**
 * Created by dan on 26.2.15.
 */


import java.util.List;

public interface DAO<T> {
    public boolean createObject(T t);

    public T readObjectById(int id, Class<T> tClass);

    public boolean updateObject(T t);

    public boolean deleteObject(int id, Class<T> tClass);

    public List<T> getAllObjects(Class<T> tClass);
}
