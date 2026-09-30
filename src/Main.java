
import factory.FactorySelector;
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
        SmartHomeFactory factory = FactorySelector.selectFromUserChoice();

        SmartHomeManager manager = new SmartHomeManager();
        manager.setupEcosystem(factory);
        manager.executeNightRoutine();
        manager.activateAwayEcoMode();
        manager.triggerEmergencyEvacuation();


    }
}

