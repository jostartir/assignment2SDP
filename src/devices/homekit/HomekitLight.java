package devices.homekit;

import model.SmartLight;

public class HomekitLight implements SmartLight{
    @Override
    public void turnOn(){
        System.out.println("[HomeKit Light] Power ON via Apple HAP Encrypted Protocol");
    }

    @Override
    public void setBrightness(int level){
        System.out.println("[HomeKit Light] Brightness set to " + level + "%");
    }

    @Override
    public void turnOff(){
        System.out.println("[HomeKit Light] Power OFF via Apple HAP Encrypted Protocol");
    }
}
