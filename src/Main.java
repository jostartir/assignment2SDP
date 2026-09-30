
import manager.SmartHomeManager;




import creator.*;
import model.SmartLight;



public class Main {
    public static void main(String[] args) {
        SmartLightInstaller homeKitInstaller = new HomekitLightInstaller();
        SmartLight livingroom = homeKitInstaller.installAndConfigure("Living room",50);

        SmartLightInstaller tuyaInstaller = new TuyaLightInstaller();
        SmartLight bedroom = tuyaInstaller.installAndConfigure("Bedroom", 90);
    }
}

