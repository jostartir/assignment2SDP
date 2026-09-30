package creator;

import model.SmartLight;
import devices.xiaomi.XiaomiLight;

public class XiaomiLightInstaller extends SmartLightInstaller{

    @Override
    public SmartLight createLight(){
        return new XiaomiLight();
    }

}
