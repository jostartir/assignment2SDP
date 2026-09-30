package creator;

import model.SmartLight;
import devices.homekit.HomekitLight;

public class HomekitLightInstaller extends SmartLightInstaller{
    @Override
    public SmartLight createLight(){
        return new HomekitLight();
    }

}
