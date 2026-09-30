
import manager.SmartHomeManager;


public class Main {
    public static void main(String[] args) {
        SmartHomeManager manager = new SmartHomeManager();

        manager.setUpEnvironment("HomeKit");
        manager.runNightRoutine();
    }
}
