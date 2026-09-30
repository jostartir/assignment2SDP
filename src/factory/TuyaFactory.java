package factory;

import devices.homekit.HomekitLight;
import devices.homekit.HomekitLock;
import devices.homekit.HomekitThermostat;
import model.*;
import devices.tuya.*;

public class TuyaFactory implements SmartHomeFactory{
    @Override
    public SmartLight createLight(){
        return new TuyaLight();
    }
    @Override
    public Thermostat createThermostat(){
        return new TuyaThermostat();
    }
    @Override
    public SecurityLock createLock(){
        return new TuyaLock();
    }
}
