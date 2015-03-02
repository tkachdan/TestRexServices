package Services.Impl;

import Services.DeviceManager;
import Services.PacketReceiver;
import Services.PositionManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dan on 2.3.15.
 */
public class PacketReceiverImpl implements PacketReceiver {
    private String deviceId = "", type = "";
    private double lat, lon, spd;
    private Date date, time;
    private int alt, zone, io;

    private DeviceManager deviceManager = new DeviceManagerImpl();
    private PositionManager positionManager = new PositionManagerImpl();

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
            positionManager.error("Bad packet", "packet doesn't start with A or doesn't end with '!'");
            return;
        } else {
            if (parsePacket(packet)) return;

        }
        if (type.equals("POS")) {
            printPosPacket();
        }
        if (type.equals("GF")) {
            printGfPacket();

        }
    }

    private boolean parsePacket(String packet) {
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
            return true;
        } else {
            deviceId = strList.get(0);
            if (!deviceManager.isDeviceExists(deviceId)) {
                positionManager.error("Unknown device", deviceId);
                return false;
            }
            type = strList.get(1);
            if (isTypeCorrect(strList)) return true;
        }
        return false;
    }

    private void printGfPacket() {
        System.out.println("\ndeviceId:" + deviceId);
        System.out.println("type:" + type);
        System.out.println("zone" + zone);
        System.out.println("io" + io);
        System.out.println("date:" + new SimpleDateFormat("yy-MM-dd").format(date));
        System.out.println("time:" + new SimpleDateFormat("HH-mm-ss").format(time));
    }

    private void printPosPacket() {
        System.out.println("\ndeviceId:" + deviceId);
        System.out.println("type:" + type);
        System.out.println("lon:" + lon);
        System.out.println("lat:" + lat);
        System.out.println("date:" + new SimpleDateFormat("yy-MM-dd").format(date));
        System.out.println("time:" + new SimpleDateFormat("HH-mm-ss").format(time));
        System.out.println("spd:" + spd);
        System.out.println("alt:" + alt);
    }

    private boolean isTypeCorrect(List<String> strList) {
        switch (type) {
            case "POS":
                if (parsePos(strList)) return true;
                break;
            case "GF":
                if (parseGf(strList)) return true;
                break;
            default:
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

            positionManager.error("Bad data", io + " " + zone + " " + date + " " + time + " ");
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
