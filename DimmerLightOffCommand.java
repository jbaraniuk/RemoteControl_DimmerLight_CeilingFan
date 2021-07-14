/**
 * @version Feb 7, 2020
 * @author Justin Baraniuk 3101350
 * 
 * DimmerLightOffCommand to change a Light object to off.
 */ 

public class DimmerLightOffCommand implements Command {
    Light light;
    int prevLevel;

    public DimmerLightOffCommand(Light light) {
        this.light = light;
        prevLevel = 100;
    }

    /** 
     * Copy Constructor
     * @param original  The original DimmerLightOffCommand object to be copied
     */
    public DimmerLightOffCommand(DimmerLightOffCommand original) {
        this.light = original.light;
        this.prevLevel = original.prevLevel;
    }

    /**
     * The copy method calls the copy constructor and returns a copy of
     * the DimmerLightOffCommand object.
     * @return copy  the copy of the original DimmerLightOffCommand object
     */
    public DimmerLightOffCommand copy() {
        DimmerLightOffCommand copy = new DimmerLightOffCommand(this);
        return copy;
    }

    public void execute() {
        prevLevel = light.getLevel();
        light.off();
    }

    public void undo() {
        light.dim(prevLevel);
    }
}
