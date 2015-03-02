package persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by dan on 2.3.15.
 */
@Entity
public class Position {
    @Id
    private int id;
    @Column(name = "lon")
    private double lon;
    @Column(name = "lon")
    private double lat;
    @Column(name = "time")
    private java.util.Date time;
    @Column(name = "speed")
    private int speed;
    @Column(name = "alt")
    private int alt;

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public java.util.Date getTime() {
        return time;
    }

    public void setTime(java.util.Date time) {
        this.time = time;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAlt() {
        return alt;
    }

    public void setAlt(int alt) {
        this.alt = alt;
    }
}