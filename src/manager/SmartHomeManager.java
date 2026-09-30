package manager;

import factory.SmartHomeFactory;
import model.*;

public class SmartHomeManager {
    private SmartLight light;
    private SecurityLock lock;
    private Thermostat thermostat;

    public void setupEcosystem(SmartHomeFactory factory){
        if (factory == null) {
            throw new IllegalArgumentException("Factory cannot be null");
        }
        this.light = factory.createLight();
        this.lock = factory.createLock();
        this.thermostat = factory.createThermostat();

        System.out.println("Successfully set up the ecosystem using " + factory.getClass().getSimpleName());

    }

    public void executeNightRoutine(){

        lock.lock();

        light.turnOn();
        light.setBrightness(10);

        thermostat.setTemperature(19.0);

        System.out.println("Night routine completed successfully");
    }

    public void triggerEmergencyEvacuation(){
        lock.unlock();

        light.turnOn();
        light.setBrightness(100);

        thermostat.setTemperature(15.0);

        System.out.println("Emergency paths illuminated and doors unlocked!");
    }

    public void activateAwayEcoMode(){
        lock.lock();

        light.turnOff();

        thermostat.setTemperature(16.0);

        System.out.println("Away Mode Active: Home secured and power saved");
    }
}
