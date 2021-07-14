/**
 * @version Feb 7, 2020
 * @author Justin Baraniuk 3101350
 * 
 * DimmerLightOnCommand to change a Light object to on.
 */ 

public class DimmerLightOnCommand implements Command {
    Light light;
    int prevLevel;

    public DimmerLightOnCommand(Light light) {
        this.light = light;
    }

     /** 
     * Copy Constructor
     * @param original  The original DimmerLightOnCommand object to be copied
     */
    public DimmerLightOnCommand(DimmerLightOnCommand original) {
        this.light = original.light;
        this.prevLevel = original.prevLevel;
    }

    /**
     * The copy method calls the copy constructor and returns a copy of
     * the DimmerLightOnCommand object.
     * @return copy  the copy of the original DimmerLightOnCommand object
     */
    public DimmerLightOnCommand copy() {
        DimmerLightOnCommand copy = new DimmerLightOnCommand(this);
        return copy;
    }

    public void execute() {
        prevLevel = light.getLevel();
        light.dim(75);
    }

    public void undo() {
        light.dim(prevLevel);
    }
}
