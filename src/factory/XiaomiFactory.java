package factory;

import devices.homekit.HomekitLight;
import devices.homekit.HomekitLock;
import devices.homekit.HomekitThermostat;
import model.*;
import devices.xiaomi.*;

public class XiaomiFactory implements SmartHomeFactory{
    @Override
    public SmartLight createLight(){
        return new XiaomiLight();
    }
    @Override
    public Thermostat createThermostat(){
        return new XiaomiThermostat();
    }
    @Override
    public SecurityLock createLock(){
        return new XiaomiLock();
    }
}
