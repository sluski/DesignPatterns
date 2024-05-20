package net.slupski.patterns;


public class Command extends Pattern {

    @Override
    void example() {
         var bathroomLight = new Light();
        var livingRoomLight = new Light();
        
        ICommand command1 = new SwitchLightCommand(bathroomLight);
        ICommand command2 = new SwitchLightCommand(livingRoomLight);
        
        System.out.println("Switching bathroom light");
        command1.execute();
        System.out.println("Switching livingroom light");
        command2.execute();
    }
 
    
    interface ICommand {
        void execute();
    }
    
    class Light {
        boolean lightOn;
        
        void switchLight() {
            lightOn = !lightOn;
        }
    }
    
    class SwitchLightCommand implements ICommand {
        final Light light;

        public SwitchLightCommand(Light light) {
            this.light = light;
        }
        
        @Override
        public void execute() {
            light.switchLight();
        }        
    }
    
    
}
