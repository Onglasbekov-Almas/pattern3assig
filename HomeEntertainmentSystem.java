// Device interface
interface Device {
    void powerOn();
    void powerOff();
    void setChannel(int channel);
    void setVolume(int volume);
}

class TVDevice implements Device {
    @Override
    public void powerOn() {
        System.out.println("TV is now ON.");
    }

    @Override
    public void powerOff() {
        System.out.println("TV is now OFF.");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("TV channel set to " + channel);
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("TV volume set to " + volume);
    }
}

// DVDDevice class
class DVDDevice implements Device {
    @Override
    public void powerOn() {
        System.out.println("DVD Player is now ON.");
    }

    @Override
    public void powerOff() {
        System.out.println("DVD Player is now OFF.");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("DVD Player doesn't support channels.");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("DVD Player volume set to " + volume);
    }
}

abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void powerButton();

    public abstract void setChannel(int channel);

    public abstract void setVolume(int volume);
}

// BasicRemote class
class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    public void powerButton() {
        device.powerOn();
    }

    @Override
    public void setChannel(int channel) {
        device.setChannel(channel);
    }

    @Override
    public void setVolume(int volume) {
        device.setVolume(volume);
    }
}

// HomeEntertainmentSystem class
class HomeEntertainmentSystem {
    public static void main(String[] args) {
        Device tv = new TVDevice();
        RemoteControl tvRemote = new BasicRemote(tv);
        tvRemote.powerButton();
        tvRemote.setChannel(5);
        tvRemote.setVolume(10);

        Device dvd = new DVDDevice();
        RemoteControl dvdRemote = new BasicRemote(dvd);
        dvdRemote.powerButton();
        dvdRemote.setVolume(15);
    }
}
