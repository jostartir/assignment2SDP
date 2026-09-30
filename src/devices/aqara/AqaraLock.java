package devices.aqara;

import model.SecurityLock;

public class AqaraLock implements SecurityLock {
    @Override
    public void lock(){
        System.out.println("[Aqara Lock] Deadbolt locked.");
    }

    @Override
    public void unlock(){
        System.out.println("[Aqara Lock] Unlocked via fingerprint scan.");
    }
}
