package devices.xiaomi;

import model.SmartLight;

public class XiaomiLight implements SmartLight{
    @Override
    public void turnOn(){
        System.out.println("[Xiaomi Light] Power ON via Mi Home Gateway");
    }

    @Override
    public void setBrightness(int level){
        System.out.println("[Xiaomi Light] Brightness set to " + level + "%");
    }

    @Override
    public void turnOff(){
        System.out.println("[Xiaomi Light] Power OFF via Mi Home Gateway");
    }

}
