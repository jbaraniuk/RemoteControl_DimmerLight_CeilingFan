 /**
 * @version Feb 7, 2020
 * @author Justin Baraniuk 3101350
 * 
 * Dummy command object, or no command.
 */ 

public class NoCommand implements Command {
    public void execute() { }
    public void undo() { }
    public NoCommand copy() { return this; }
}
