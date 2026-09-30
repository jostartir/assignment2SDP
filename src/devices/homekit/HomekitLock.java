package devices.homekit;

import model.SecurityLock;

public class HomekitLock implements SecurityLock{
    @Override
    public void lock(){
        System.out.println("[HomeKit Lock] Locked with HomeKit Secure Enclave key");
    }

    @Override
    public void unlock(){
        System.out.println("[HomeKit Lock] Unlocked via HomeKit biometric session");
    }
}
