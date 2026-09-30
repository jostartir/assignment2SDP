
import factory.HomekitFactory;
import factory.SmartHomeFactory;
import factory.TuyaFactory;
import manager.SmartHomeManager;




import creator.*;
import model.SecurityLock;
import model.SmartLight;
import model.Thermostat;


public class Main {
    public static void main(String[] args) {
        SmartHomeManager manager = new SmartHomeManager();

        SmartHomeFactory homeKitFactory = new HomekitFactory();
        manager.setupEcosystem(homeKitFactory);
        manager.runNightRoutine();

        System.out.println(" :DDD ");

        SmartHomeFactory tuyaFactory = new TuyaFactory();
        manager.setupEcosystem(tuyaFactory);
        manager.runNightRoutine();


    }
}

