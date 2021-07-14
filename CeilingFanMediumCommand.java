/**
 * @version Feb 7, 2020
 * @author Justin Baraniuk 3101350
 * 
 * CeilingFanMediumCommand to change a CeilingFan object to medium speed.
 */ 

public class CeilingFanMediumCommand implements Command {
    CeilingFan ceilingFan;
    int prevSpeed;

    public CeilingFanMediumCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    /** 
     * Copy Constructor
     * @param original  The original CeilingFanMediumCommand object to be copied
     */
    public CeilingFanMediumCommand(CeilingFanMediumCommand original) {
        this.ceilingFan = original.ceilingFan;
        this.prevSpeed = original.prevSpeed;
    }
    
    /**
     * The copy method calls the copy constructor and returns a copy of
     * the CeilingFanMediumCommand object.
     * @return copy  the copy of the original CeilingFanMediumCommand object
     */
    public CeilingFanMediumCommand copy() {
        CeilingFanMediumCommand copy = new CeilingFanMediumCommand(this);
        return copy;
    }

    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.medium();
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
