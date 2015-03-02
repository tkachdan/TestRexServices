package Services;


import persistence.model.Device;

/**
 * Created by dan on 2.3.15.
 */
public interface DeviceManager {
    /**
     * Vrací informace o zařízení, případně null, pokud zařízení se
     * zadaným identifikátorem v systému není
     */
    public Device getDevice(String id);
}
