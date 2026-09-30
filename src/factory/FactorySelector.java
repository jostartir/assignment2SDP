package factory;

import devices.tuya.TuyaLight;

import java.util.Scanner;

public class FactorySelector {
    public static SmartHomeFactory selectFromUserChoice(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select smarthome platform ");
        System.out.println("1 - HomeKit");
        System.out.println("2 - Tuya");
        System.out.println("3 - Xiaomi");

        String input = scanner.nextLine().trim();

        return switch (input.toLowerCase()){
            case "1", "homekit" -> new HomekitFactory();
            case "2","tuya" -> new TuyaFactory();
            case "3","xiaomi" -> new XiaomiFactory();
            default -> {
                System.out.println("Unknown platform. Defaulting to HomeKit.");
                yield new HomekitFactory();
            }

        };
    }

}
