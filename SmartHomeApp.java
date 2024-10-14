// Light class
class Light {
    public void turnOn() {
        System.out.println("Lights turned on.");
    }

    public void turnOff() {
        System.out.println("Lights turned off.");
    }
}

// Thermostat class
class Thermostat {
    public void setTemperature(int temp) {
        System.out.println("Thermostat set to " + temp + " degrees.");
    }
}

class SecuritySystem {
    public void arm() {
        System.out.println("Security system armed.");
    }

    public void disarm() {
        System.out.println("Security system disarmed.");
    }
}

// SmartHomeFacade class
class SmartHomeFacade {
    private Light light;
    private Thermostat thermostat;
    private SecuritySystem securitySystem;

    public SmartHomeFacade() {
        light = new Light();
        thermostat = new Thermostat();
        securitySystem = new SecuritySystem();
    }

    public void leaveHome() {
        securitySystem.arm();
        thermostat.setTemperature(18);
        light.turnOff();
        System.out.println("Leaving home...");
    }

    public void arriveHome() {
        securitySystem.disarm();
        thermostat.setTemperature(22);
        light.turnOn();
        System.out.println("Arriving home...");
    }

    public void nightMode() {
        light.turnOff();
        thermostat.setTemperature(20);
        System.out.println("Night mode activated.");
    }

    public void movieMode() {
        light.turnOff();
        thermostat.setTemperature(21);
        System.out.println("Movie mode activated.");
    }
}

class SmartHomeApp {
    public static void main(String[] args) {
        SmartHomeFacade smartHome = new SmartHomeFacade();
        smartHome.arriveHome();
        smartHome.movieMode();
        smartHome.nightMode();
    }
}
