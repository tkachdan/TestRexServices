package Impl;
import Services.DeviceManager;
import Services.PacketReceiver;
import Services.PositionManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dan on 2.3.15.
 */
public class PacketReceiverImpl implements PacketReceiver {
    String deviceId = "";
    String type = "";
    boolean idRead = false;
    boolean isTypeRead = false;
    double lat, lon, spd;
    Date date;
    private Date time;
    int alt;

    int zone;
    int io;

    @Override
    public void setDeviceManager(DeviceManager mngr) {

    }

    @Override
    public void setPositionManager(PositionManager mngr) {

    }

    @Override
    public void receivePacket(String packet) {
        //POS {lon};{lat};{date};{time};{spd};{alt}
        //A57848;POS;14.609;49.896;140725;121518;22;505!

        //GF  {zone};{io};{date};{time}
        //A512;GF;6;1;140725;130000!


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
                System.out.println("Bad packet");
                return;
            } else {
                deviceId = strList.get(0);
                type = strList.get(1);
                if (type.equals("POS")) {
                    if (parsePos(strList)) return;
                } else if (type.equals("GF")) {
                    if (parseGf(strList)) return;
                } else {
                    System.out.println("Bad type");
                    return;
                }

            }

        }
        if(type.equals("POS")) {
            System.out.println("\ndeviceId:" + deviceId);
            System.out.println("type:" + type);
            System.out.println("lon:" + lon);
            System.out.println("lat:" + lat);
            System.out.println("date:" + date.getTime());
            System.out.println("time:" + time.getTime());
            System.out.println("spd:" + spd);
            System.out.println("alt:" + alt);
        }
        if(type.equals("GF")){
            System.out.println("\ndeviceId:" + deviceId);
            System.out.println("type:" + type);
            System.out.println("zone" + zone);
            System.out.println("io" + io);
            System.out.println("date:" + date.getTime());
            System.out.println("time:" + time.getTime());

        }

    }

    private boolean parseGf(List<String> strList) {
        try {
            io = Integer.parseInt(strList.get(2));
            zone = Integer.parseInt(strList.get(3));
            date = new Date(Long.parseLong(strList.get(4)));
            time = new Date(Long.parseLong(strList.get(5)));
        }catch (NumberFormatException e){

            System.out.println("Bad packet");
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

            System.out.println("Bad packet");
            return true;
        }
        return false;
    }

}
