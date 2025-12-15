package commandPattern;

public class Main {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();

        Light livingRoomLight = new Light();
        Fan ceilingFan = new Fan();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command fanStart = new FanStartCommand(ceilingFan);

        // Turn on light
        System.out.println("→ Pressing Light ON");
        remote.setCommand(lightOn);
        remote.pressButton();

        // Start fan
        System.out.println("→ Pressing Fan START");
        remote.setCommand(fanStart);
        remote.pressButton();

        // Undo last command (Fan Stop)
        System.out.println("→ Pressing UNDO");
        remote.pressUndo();

        // Undo previous command (Light Off)
        System.out.println("→ Pressing UNDO");
        remote.pressUndo();
    }
}
