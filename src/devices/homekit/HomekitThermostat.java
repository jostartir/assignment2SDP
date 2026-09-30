package devices.homekit;

import model.Thermostat;

public class HomekitThermostat implements Thermostat {
    @Override
    public void setTemperature(double temp){
        System.out.println("[HomeKit Thermostat] Target temp set to " + temp + "°C via HomeHub");
    }
}
