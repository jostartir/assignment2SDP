package devices.xiaomi;

import model.SecurityLock;

public class XiaomiLock implements SecurityLock{
    @Override
    public void lock(){
        System.out.println("[Xiaomi Lock] Locked via Mi Home Bluetooth Mesh");
    }

    @Override
    public void unlock(){
        System.out.println("[Xiaomi Lock] Locked via Mi Home Bluetooth Mesh");
    }
}
