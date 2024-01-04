package Week3postlab;

//Command interface
interface Command {
 void execute();
}
//Concrete command for turning on the light
class LightOnCommand implements Command {
 private Light light;
 public LightOnCommand(Light light) {
     this.light = light;
 }
 @Override
 public void execute() {
     light.turnOn();
 }
}
//Concrete command for turning off the light
class LightOffCommand implements Command {
 private Light light;

 public LightOffCommand(Light light) {
     this.light = light;
 }
 @Override
 public void execute() {
     light.turnOff();
 }
}
//Receiver (Light)
class Light {
 public void turnOn() {
     System.out.println("Light is on");
 }
 public void turnOff() {
     System.out.println("Light is off");
 }
}
//Concrete command for turning on the stereo
class StereoOnCommand implements Command {
 private Stereo stereo;
 public StereoOnCommand(Stereo stereo) {
     this.stereo = stereo;
 }
 @Override
 public void execute() {
     stereo.turnOn();
     stereo.setCD();
     stereo.setVolume(11);
 }
}
//Concrete command for turning off the stereo
class StereoOffCommand implements Command {
 private Stereo stereo;

 public StereoOffCommand(Stereo stereo) {
     this.stereo = stereo;
 }
 @Override
 public void execute() {
     stereo.turnOff();
 }
}
//Receiver (Stereo)
class Stereo {
 public void turnOn() {
     System.out.println("Stereo is on");
 }
 public void turnOff() {
     System.out.println("Stereo is off");
 }
 public void setCD() {
     System.out.println("Stereo is set for CD input");
 }
 public void setVolume(int volume) {
     System.out.println("Stereo volume set to " + volume);
 }
}
//Invoker (Remote Control)
class RemoteControl {
 private Command command;

 public void setCommand(Command command) {
     this.command = command;
 }

 public void pressButton() {
     command.execute();
 }
}
 class AutomaintainSystem {
 public static void main(String[] args) {
     // Create devices
     Light livingRoomLight = new Light();
     Stereo livingRoomStereo = new Stereo();
     // Create commands
     Command lightOn = new LightOnCommand(livingRoomLight);
     Command lightOff = new LightOffCommand(livingRoomLight);
     Command stereoOn = new StereoOnCommand(livingRoomStereo);
     Command stereoOff = new StereoOffCommand(livingRoomStereo);
     // Create remote control
     RemoteControl remote = new RemoteControl();
     // Set and press light commands
     remote.setCommand(lightOn);
     remote.pressButton();
     remote.setCommand(lightOff);
     remote.pressButton();
     // Set and press stereo commands
     remote.setCommand(stereoOn);
     remote.pressButton();
     remote.setCommand(stereoOff);
     remote.pressButton();
 }
}
