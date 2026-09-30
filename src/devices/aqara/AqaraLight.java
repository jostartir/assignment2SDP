package devices.aqara;

import model.SmartLight;

public class AqaraLight implements SmartLight {
    @Override
    public void turnOn(){
        System.out.println("[Aqara Light] Turned ON via Zigbee protocol.");
    }

    @Override
    public void setBrightness(int level){
        System.out.println("[Aqara Light] Brightness set to " + level + "%");
    }

    @Override
    public void turnOff(){
        System.out.println("[Aqara Light] Turned OFF");
    }
}
