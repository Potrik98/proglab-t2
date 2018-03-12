package proglab.t2.zumocontrol;

public class Main {
    public static void main(String[] args) {
        ArduinoController controller = new ArduinoController();
        while (true) {
            controller.sendMessage("hei på deg");
        }
    }
}
