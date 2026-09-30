package factory;

import model.*;


public interface SmartHomeFactory {
    SmartLight createLight();
    Thermostat createThermostat();
    SecurityLock createLock();
}
