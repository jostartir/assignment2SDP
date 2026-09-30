package creator;

import model.SmartLight;
import devices.tuya.TuyaLight;

public class TuyaLightInstaller extends SmartLightInstaller{

    @Override
    public SmartLight createLight(){
        return new TuyaLight();
    }
}
