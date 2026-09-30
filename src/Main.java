
import factory.HomekitFactory;
import factory.SmartHomeFactory;
import manager.SmartHomeManager;




import creator.*;
import model.SecurityLock;
import model.SmartLight;
import model.Thermostat;


public class Main {
    public static void main(String[] args) {
        SmartHomeFactory factory = new HomekitFactory();

        SmartLight light = factory.createLight();
        Thermostat thermostat = factory.createThermostat();
        SecurityLock lock = factory.createLock();

        light.turnOn();
        thermostat.setTemperature(28.5);
        lock.lock();
    }
}

