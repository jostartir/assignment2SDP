package manager;

import devices.homekit.*;
import devices.tuya.*;
import devices.xiaomi.*;

import model.*;

public class SmartHomeManager {
    private SmartLight light;
    private SecurityLock lock;
    private Thermostat thermostat;

    public void setUpEnvironment(String platform){
        if (platform.equalsIgnoreCase("Homekit")){
            this.light = new HomekitLight();
            this.lock = new HomekitLock();
            this.thermostat = new HomekitThermostat();
        }else if (platform.equalsIgnoreCase("Tuya")){
            this.light = new TuyaLight();
            this.lock = new TuyaLock();
            this.thermostat = new TuyaThermostat();
        }else if (platform.equalsIgnoreCase("Xiaomi")){
            this.light = new XiaomiLight();
            this.lock = new XiaomiLock();
            this.thermostat = new XiaomiThermostat();
        }else{
            throw new IllegalArgumentException("Unsupported platform:" + platform);
        }
    }

    public SmartLight createExtraLight(String platform){
        if (platform.equalsIgnoreCase("Homekit")){
            return new HomekitLight();
        }
        if (platform.equalsIgnoreCase("Tuya")){
            return new TuyaLight();
        }
        if (platform.equalsIgnoreCase("Xiaomi")){
            return new XiaomiLight();
        }
        throw new IllegalArgumentException("Unknown platform: " + platform);
    }

    public void unsafeCustomSetup(SmartLight l,SecurityLock s,Thermostat t){
        this.light = l;
        this.lock = s;
        this.thermostat = t;
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
