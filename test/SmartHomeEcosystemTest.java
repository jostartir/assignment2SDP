import creator.HomekitLightInstaller;
import creator.SmartLightInstaller;
import devices.aqara.*;
import devices.homekit.*;
import devices.tuya.*;
import devices.xiaomi.*;
import factory.*;
import manager.SmartHomeManager;
import model.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartHomeEcosystemTest {

    private SmartHomeManager manager;

    @BeforeEach
    void setUp() {
        manager = new SmartHomeManager();
    }

    @Test
    @DisplayName("1. HomeKit Factory creates valid concrete HomeKit products")
    void testHomekitFactoryCreatesCorrectProducts() {
        SmartHomeFactory factory = new HomekitFactory();
        assertTrue(factory.createLight() instanceof HomekitLight);
        assertTrue(factory.createThermostat() instanceof HomekitThermostat);
        assertTrue(factory.createLock() instanceof HomekitLock);
    }

    @Test
    @DisplayName("2. Tuya Factory creates valid concrete Tuya products")
    void testTuyaFactoryCreatesCorrectProducts() {
        SmartHomeFactory factory = new TuyaFactory();
        assertTrue(factory.createLight() instanceof TuyaLight);
        assertTrue(factory.createThermostat() instanceof TuyaThermostat);
        assertTrue(factory.createLock() instanceof TuyaLock);
    }

    @Test
    @DisplayName("3. Xiaomi Factory creates valid concrete Xiaomi products")
    void testXiaomiFactoryCreatesCorrectProducts() {
        SmartHomeFactory factory = new XiaomiFactory();
        assertTrue(factory.createLight() instanceof XiaomiLight);
        assertTrue(factory.createThermostat() instanceof XiaomiThermostat);
        assertTrue(factory.createLock() instanceof XiaomiLock);
    }

    @Test
    @DisplayName("4. Aqara Factory creates valid concrete Aqara products")
    void testAqaraFactoryCreatesCorrectProducts() {
        SmartHomeFactory factory = new AqaraFactory();
        assertTrue(factory.createLight() instanceof AqaraLight);
        assertTrue(factory.createThermostat() instanceof AqaraThermostat);
        assertTrue(factory.createLock() instanceof AqaraLock);
    }

    @Test
    @DisplayName("5. HomeKit product family maintains strict compatibility")
    void testHomeKitProductFamilyConsistency() {
        SmartHomeFactory factory = new HomekitFactory();
        SmartLight light = factory.createLight();
        Thermostat thermostat = factory.createThermostat();
        SecurityLock lock = factory.createLock();

        assertEquals(HomekitLight.class, light.getClass());
        assertEquals(HomekitThermostat.class, thermostat.getClass());
        assertEquals(HomekitLock.class, lock.getClass());
    }

    @Test
    @DisplayName("6. Tuya product family maintains strict compatibility")
    void testTuyaProductFamilyConsistency() {
        SmartHomeFactory factory = new TuyaFactory();
        SmartLight light = factory.createLight();
        Thermostat thermostat = factory.createThermostat();
        SecurityLock lock = factory.createLock();

        assertEquals(TuyaLight.class, light.getClass());
        assertEquals(TuyaThermostat.class, thermostat.getClass());
        assertEquals(TuyaLock.class, lock.getClass());
    }

    @Test
    @DisplayName("7. Aqara product family maintains strict compatibility")
    void testAqaraProductFamilyConsistency() {
        SmartHomeFactory factory = new AqaraFactory();
        SmartLight light = factory.createLight();
        Thermostat thermostat = factory.createThermostat();
        SecurityLock lock = factory.createLock();

        assertEquals(AqaraLight.class, light.getClass());
        assertEquals(AqaraThermostat.class, thermostat.getClass());
        assertEquals(AqaraLock.class, lock.getClass());
    }

    @Test
    @DisplayName("8. FactorySelector dynamically creates TuyaFactory at runtime")
    void testRuntimeFactorySelectionValidInput() {
        SmartHomeFactory factory = FactorySelector.getFactoryByName("tuya");
        assertNotNull(factory);
        assertTrue(factory instanceof TuyaFactory);
    }

    @Test
    @DisplayName("9. FactorySelector dynamically creates AqaraFactory at runtime")
    void testRuntimeFactorySelectionAqara() {
        SmartHomeFactory factory = FactorySelector.getFactoryByName("aqara");
        assertNotNull(factory);
        assertTrue(factory instanceof AqaraFactory);
    }

    @Test
    @DisplayName("10. Business Behavior: Night Routine executes without errors")
    void testNightRoutineBusinessBehavior() {
        manager.setupEcosystem(new HomekitFactory());
        assertDoesNotThrow(() -> manager.executeNightRoutine());
    }

    @Test
    @DisplayName("11. Business Behavior: Emergency Evacuation executes without errors")
    void testEmergencyEvacuationBusinessBehavior() {
        manager.setupEcosystem(new XiaomiFactory());
        assertDoesNotThrow(() -> manager.triggerEmergencyEvacuation());
    }

    @Test
    @DisplayName("12. Business Behavior: Away Eco Mode executes without errors")
    void testAwayEcoModeBusinessBehavior() {
        manager.setupEcosystem(new AqaraFactory());
        assertDoesNotThrow(() -> manager.activateAwayEcoMode());
    }

    @Test
    @DisplayName("13. Negative Scenario: Unknown platform selection throws IllegalArgumentException")
    void testUnknownPlatformSelectionThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            FactorySelector.getFactoryByName("unknown_brand_xyz");
        });
    }

    @Test
    @DisplayName("14. Negative Scenario: Passing null factory to manager throws IllegalArgumentException")
    void testNullFactorySetupThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            manager.setupEcosystem(null);
        });
    }

    @Test
    @DisplayName("15. Proof of Abstraction: SmartHomeManager works polymorphically with any SmartHomeFactory")
    void testClientWorksPolymorphicallyThroughAbstractions() {
        SmartHomeFactory[] factories = new SmartHomeFactory[]{
                new HomekitFactory(),
                new TuyaFactory(),
                new XiaomiFactory(),
                new AqaraFactory()
        };

        for (SmartHomeFactory factory : factories) {
            assertDoesNotThrow(() -> {
                manager.setupEcosystem(factory);
                manager.executeNightRoutine();
                manager.triggerEmergencyEvacuation();
                manager.activateAwayEcoMode();
            });
        }
    }

    @Test
    @DisplayName("16. Factory Method: Installer template method executes onboarding logic")
    void testFactoryMethodInstallerOnboarding() {
        SmartLightInstaller installer = new HomekitLightInstaller();
        SmartLight light = installer.installAndConfigure("Living Room", 75);

        assertNotNull(light);
        assertTrue(light instanceof HomekitLight);
    }
}