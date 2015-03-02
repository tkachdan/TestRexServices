package Services.Impl;


import Services.PositionManager;

import persistence.model.Device;
import persistence.model.Position;

/**
 * Created by dan on 2.3.15.
 */
public class PositionManagerImpl implements PositionManager {

    @Override
    public void newPosition(Device dev, Position pos) {
        System.out.println(dev + ": "+ pos);
    }

    @Override
    public void enterArea(Device dev, int area) {
        System.out.println("Enter area" + dev+ " " + area);
    }

    @Override
    public void leaveArea(Device dev, int area) {
        System.out.println("Leaved area" + dev+ " " + area);
    }

    @Override
    public void error(String message, String reason) {
        System.err.println(message + ": "+ reason);
    }
}
