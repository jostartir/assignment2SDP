package manager;

import factory.SmartHomeFactory;
import model.*;

public class SmartHomeManager {
    private SmartLight light;
    private SecurityLock lock;
    private Thermostat thermostat;

    public void setupEcosystem(SmartHomeFactory factory){
        this.light = factory.createLight();
        this.lock = factory.createLock();
        this.thermostat = factory.createThermostat();

        System.out.println("Successfully set up the ecosystem using " + factory.getClass().getSimpleName());

    }

    public void runNightRoutine(){
        System.out.println("Executing night routine");

        if (light != null){
            light.turnOn();
            light.setBrightness(10);
        }
        if (thermostat != null){
            thermostat.setTemperature(18.5);
        }
        if (lock != null){
            lock.lock();
        }
    }
}
