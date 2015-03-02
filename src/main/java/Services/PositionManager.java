package Services;


import persistence.model.Device;
import persistence.model.Position;

/**
 * Created by dan on 2.3.15.
 */
public interface PositionManager {

    public void newPosition(Device dev, Position pos);
    public void enterArea(Device dev, int area);
    public void leaveArea(Device dev, int area);
    public void error(String message, String reason);

}
