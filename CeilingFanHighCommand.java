/**
 * @version Feb 7, 2020
 * @author Justin Baraniuk 
 * 
 * CeilingFanHighCommand to change a CeilingFan object speed to high.
 */ 

public class CeilingFanHighCommand implements Command {
    CeilingFan ceilingFan;
    int prevSpeed;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    /** 
     * Copy Constructor
     * @param original  The original CeilingFanHighCommand object to be copied
     */
    public CeilingFanHighCommand(CeilingFanHighCommand original) {
        this.ceilingFan = original.ceilingFan;
        this.prevSpeed = original.prevSpeed;
    }
    
    /**
     * The copy method calls the copy constructor and returns a copy of
     * the CeilingFanHighCommand object.
     * @return copy  the copy of the original CeilingFanHighCommand object
     */
    public CeilingFanHighCommand copy() {
        CeilingFanHighCommand copy = new CeilingFanHighCommand(this);
        return copy;
    }

    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
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
