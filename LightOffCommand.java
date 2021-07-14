/**
 * @version Feb 7, 2020
 * @author Justin Baraniuk 3101350
 * 
 * LightOff Command to turn off a Light object.
 */ 

public class LightOffCommand implements Command {
    Light light;
    int level;
    
    public LightOffCommand(Light light) {
        this.light = light;
    }

    /** 
     * Copy Constructor
     * @param original  The original LightOffCommand object to be copied
     */
    public LightOffCommand(LightOffCommand original) {
        this.light = original.light;
        this.level = original.level;
    }

    /**
     * The copy method calls the copy constructor and returns a copy of
     * the LightOffCommand object.
     * @return copy  the copy of the original LightOffCommand object
     */
    public LightOffCommand copy() {
        LightOffCommand copy = new LightOffCommand(this);
        return copy;
    }

    public void execute() {
        level = light.getLevel();
        light.off();
    }

    public void undo() {
        light.dim(level);
    }
}
