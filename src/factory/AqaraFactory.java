package factory;

import model.*;
import devices.aqara.*;

public class AqaraFactory implements SmartHomeFactory{

    @Override
    public SmartLight createLight(){
        return new AqaraLight();
    }
    @Override
    public Thermostat createThermostat(){
        return new AqaraThermostat();
    }
    @Override
    public SecurityLock createLock(){
        return new AqaraLock();
    }
}