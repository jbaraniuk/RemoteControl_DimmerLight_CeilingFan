/**
 * @version Feb 7, 2020
 * @author Justin Baraniuk 3101350
 * 
 * CeilingFanOffCommand to change a CeilingFan object speed to off.
 */ 

public class CeilingFanOffCommand implements Command {
    CeilingFan ceilingFan;
    int prevSpeed;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    /** 
     * Copy Constructor
     * @param original  The original CeilingFanOffCommand object to be copied
     */
    public CeilingFanOffCommand(CeilingFanOffCommand original) {
        this.ceilingFan = original.ceilingFan;
        this.prevSpeed = original.prevSpeed;
    }

     /**
     * The copy method calls the copy constructor and returns a copy of
     * the CeilingFanOffCommand object.
     * @return copy  the copy of the original CeilingFanOffCommand object
     */
    public CeilingFanOffCommand copy() {
        CeilingFanOffCommand copy = new CeilingFanOffCommand(this);
        return copy;
    }

    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.off();
    }

    public void undo() {
        if (prevSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
        } else if (prevSpeed == CeilingFan.MEDIUM) {
            ceilingFan.medium();
        } else if (prevSpeed == CeilingFan.LOW) {
            ceilingFan.low();
        } else if (prevSpeed == CeilingFan.OFF) {
            ceilingFan.off();
        }
    }
}
