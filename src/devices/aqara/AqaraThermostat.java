package devices.aqara;

import model.Thermostat;

public class AqaraThermostat implements Thermostat {
    @Override
    public void setTemperature(double temp){
        System.out.println("[Aqara Thermostat] Climate set to " + temp + "°C");
    }
}
