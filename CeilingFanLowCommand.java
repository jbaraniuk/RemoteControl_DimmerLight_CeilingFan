/**
 * @version Feb 7, 2020
 * @author Justin Baraniuk 3101350
 * 
 * CeilingFanLowCommand to change a CeilingFan object speed to low.
 */ 

public class CeilingFanLowCommand implements Command {
    CeilingFan ceilingFan;
    int prevSpeed;

    public CeilingFanLowCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

     /** 
     * Copy Constructor
     * @param original  The original CeilingFanLowCommand object to be copied
     */
    public CeilingFanLowCommand(CeilingFanLowCommand original) {
        this.ceilingFan = original.ceilingFan;
        this.prevSpeed = original.prevSpeed;
    }
    
    /**
     * The copy method calls the copy constructor and returns a copy of
     * the CeilingFanLowCommand object.
     * @return copy  the copy of the original CeilingFanLowCommand object
     */
    public CeilingFanLowCommand copy() {
        CeilingFanLowCommand copy = new CeilingFanLowCommand(this);
        return copy;
    }

    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.low();
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
