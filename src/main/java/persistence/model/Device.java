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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
