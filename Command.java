/**
 * @version Feb 7, 2020
 * @author Justin Baraniuk 3101350
 * 
 * Interface for command objects.
 */ 

public interface Command {
    public void execute();
    public void undo();
    public Command copy();
}
