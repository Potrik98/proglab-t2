package proglab.t2.zumocontrol;

public class ArduinoController {
    private PLabSerial serialConnection;

    public ArduinoController() {
        serialConnection = new PLabSerial();
        serialConnection.openPort("PLabGruppe2");
        serialConnection.addCallback(this::messageCallback);
    }

    private void messageCallback(String message, int value) {
        System.out.println("[" + value + "]:" + message);
    }

    public void sendMessage(String message) {
        serialConnection.sendMessage(message);
    }

    public String getStatus() {
        return serialConnection.getStatus();
    }
}
