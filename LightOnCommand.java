/**
 * @version Feb 7, 2020
 * @author Justin Baraniuk 3101350
 * 
 * LightOn Command to turn on a Light object.
 */ 

public class LightOnCommand implements Command {
    Light light;
    int level;
    
    public LightOnCommand(Light light) {
        this.light = light;
    }

    /** 
     * Copy Constructor
     * @param original  The original LightOnCommand object to be copied
     */
    public LightOnCommand(LightOnCommand original) {
        this.light = original.light;
        this.level = original.level;
    }

     /**
     * The copy method calls the copy constructor and returns a copy of
     * the LightOnCommand object.
     * @return copy  the copy of the original LightOnCommand object
     */
    public LightOnCommand copy() {
        LightOnCommand copy = new LightOnCommand(this);
        return copy;
    }

    public void execute() {
        level = light.getLevel();
        light.on();
    }

    public void undo() {
        light.dim(level);
    }
}
