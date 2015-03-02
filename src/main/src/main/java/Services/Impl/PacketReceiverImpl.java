package Services.Impl;

import Services.DeviceManager;
import Services.PacketReceiver;
import Services.PositionManager;
import persistence.model.Device;
import persistence.model.Position;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dan on 2.3.15.
 */
public class PacketReceiverImpl implements PacketReceiver {
    private String deviceId = "", type = "";
    private boolean idRead = false, isTypeRead = false;
    private double lat, lon, spd;
    private Date date, time;
    private int alt, zone, io;

    private DeviceManager deviceManager;
    private PositionManager positionManager;

    @Override
    public void setDeviceManager(DeviceManager mngr) {
        this.deviceManager = mngr;
    }

    @Override
    public void setPositionManager(PositionManager mngr) {
        this.positionManager = mngr;
    }

    @Override
    public void receivePacket(String packet) {

        if (!packet.startsWith("A") || !packet.endsWith("!")) {
            System.out.println("Bad packet");
            return;
        } else {
            List<String> strList = new ArrayList<>();
            char[] charArray = packet.toCharArray();
            String tmp = "";
            for (int i = 1; i < charArray.length; i++) {
                if (charArray[i] == ';' || (i == charArray.length - 1 && (charArray[i] == '!'))) {
                    strList.add(tmp);
                    tmp = "";
                } else {
                    tmp += charArray[i];
                }
            }
            if (strList.size() != 8 && strList.size() != 6) {
                positionManager.error("Bad packet", "Wrong format of the packet");
                System.out.println("Bad packet");
                return;
            } else {
                deviceId = strList.get(0);
                if (!deviceManager.isDeviceExists(deviceId)) return;
                type = strList.get(1);
                if (isTypeCorrect(strList)) return;
            }

        }
        if (type.equals("POS")) {
            Position position = new Position();
            System.out.println("\ndeviceId:" + deviceId);
            System.out.println("type:" + type);
            System.out.println("lon:" + lon);
            System.out.println("lat:" + lat);
            System.out.println("date:" + date.getTime());
            System.out.println("time:" + time.getTime());
            System.out.println("spd:" + spd);
            System.out.println("alt:" + alt);
        }
        if (type.equals("GF")) {
            System.out.println("\ndeviceId:" + deviceId);
            System.out.println("type:" + type);
            System.out.println("zone" + zone);
            System.out.println("io" + io);
            System.out.println("date:" + date.getTime());
            System.out.println("time:" + time.getTime());

        }
    }

    private boolean isTypeCorrect(List<String> strList) {
        if (type.equals("POS")) {
            if (parsePos(strList)) return true;
        } else if (type.equals("GF")) {
            if (parseGf(strList)) return true;
        } else {
            positionManager.error("Bad type", type);
            return true;
        }
        return false;
    }

    private boolean parseGf(List<String> strList) {
        try {
            io = Integer.parseInt(strList.get(2));
            zone = Integer.parseInt(strList.get(3));
            date = new Date(Long.parseLong(strList.get(4)));
            time = new Date(Long.parseLong(strList.get(5)));
        } catch (NumberFormatException e) {

            positionManager.error("Bad data",io+" " + zone + " " + date +" " + time+" ");
            return true;
        }
        return false;
    }

    private boolean parsePos(List<String> strList) {
        try {
            lon = Double.parseDouble(strList.get(2));
            lat = Double.parseDouble(strList.get(3));
            date = new Date(Long.parseLong(strList.get(4)));
            time = new Date(Long.parseLong(strList.get(5)));
            spd = Double.parseDouble(strList.get(6));
            alt = Integer.parseInt(strList.get(7));
        } catch (NumberFormatException e) {

            positionManager.error("Bad data", lon + " " + lat + " " + date + " " + time + " " +
                    spd + " " + alt);
            return true;
        }
        return false;
    }

}
