package devices.tuya;

import model.SmartLight;

public class TuyaLight implements SmartLight{
    @Override
    public void turnOn(){
        System.out.println("[Tuya Light] Power ON via Zigbee Mesh Frame");
    }

    @Override
    public void setBrightness(int level){
        System.out.println("[Tuya Light] Brightness set to " + level + "%");
    }

    @Override
    public void turnOff(){
        System.out.println("[Tuya Light] Power OFF via Zigbee Mesh Frame");
    }
}
