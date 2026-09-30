package factory;

import model.*;
import devices.homekit.*;

public class HomekitFactory implements SmartHomeFactory{

    @Override
    public SmartLight createLight(){
        return new HomekitLight();
    }
    @Override
    public Thermostat createThermostat(){
        return new HomekitThermostat();
    }
    @Override
    public SecurityLock createLock(){
        return new HomekitLock();
    }
}
