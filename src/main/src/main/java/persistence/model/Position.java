package persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by dan on 2.3.15.
 */
@Entity
public class Position {
    @Id
    private int id;
    @Column(name = "lon")
    private double lon;
    @Column(name = "lat")
    private double lat;
    @Column(name = "time")
    private java.util.Date time;
    @Column(name = "speed")
    private int speed;
    @Column(name = "alt")
    private int alt;

    public Position() {
    }

    public Position(int id, double lon, double lat, Date time, int speed, int alt) {
        this.id = id;
        this.lon = lon;
        this.lat = lat;
        this.time = time;
        this.speed = speed;
        this.alt = alt;
    }

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

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", lon=" + lon +
                ", lat=" + lat +
                ", time=" + time +
                ", speed=" + speed +
                ", alt=" + alt +
                '}';
    }
}