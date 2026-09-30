package devices.xiaomi;

import model.Thermostat;

public class XiaomiThermostat implements Thermostat{
    @Override
    public void setTemperature(double temp){
        System.out.println("[Xiaomi Thermostat] Temp set to " + temp + "°C via Mi Home Protocol");
    }
}
