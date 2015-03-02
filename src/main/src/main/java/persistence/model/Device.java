package persistence.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by dan on 2.3.15.
 */

@Entity
public class Device {

    @Id
    private String id;

    public Device(String id) {
        this.id = id;
    }



    public Device() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id='" + id + '\'' +
                '}';
    }
}
