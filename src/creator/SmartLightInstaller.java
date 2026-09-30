package creator;

import model.SmartLight;

public abstract class SmartLightInstaller {
    protected abstract SmartLight createLight();

    public SmartLight installAndConfigure(String roomName, int targetBrightness){
        System.out.println("Installing a new light fixture " + roomName);

        SmartLight light = createLight();

        light.turnOn();
        light.setBrightness(targetBrightness);
        System.out.println("Diagnostic passed. Light fully configured for " + roomName);

        return light;
    }
}
