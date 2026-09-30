package devices.tuya;

import model.Thermostat;

public class TuyaThermostat implements Thermostat{
    @Override
    public void setTemperature(double temp){
        System.out.println("[Tuya Thermostat] Temp set to" + temp + "°C via Tuya Gateway");
    }
}
