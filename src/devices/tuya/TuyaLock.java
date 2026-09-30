package devices.tuya;

import model.SecurityLock;

public class TuyaLock implements SecurityLock{
    @Override
    public void lock(){
        System.out.println("[Tuya Lock] Locked via Zigbee local hub command");
    }

    @Override
    public void unlock(){
        System.out.println("[Tuya Lock] Unlocked via Zigbee local hub command");
    }
}
