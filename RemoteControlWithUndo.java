/**
 * @version Feb 7, 2020
 * @author Justin Baraniuk 3101350
 * 
 * This class represents a remote control with undo (and redo) functions.
 */ 
import java.util.Stack;

public class RemoteControlWithUndo {
    private Command[] onCommands;
    private Command[] offCommands;
    private Command undoCommand; //for undo display in toString()
    private Command redoCommand; //for redo display in toString()
    private Command noCommand;
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    public RemoteControlWithUndo() {
        onCommands = new Command[7];
        offCommands = new Command[7];
        undoStack = new Stack();
        redoStack = new Stack();

        noCommand = new NoCommand();
        
        // set all remote control buttons with noCommand
        for(int i=0;i<7;i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        
        // set undo and redo display variables with noCommand
        undoCommand = noCommand;
        redoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        
        // execute onButton Command
        onCommands[slot].execute();
        
        // create a copy of the command object
        Command c = onCommands[slot].copy();
        
        // push command object copy onto undo stack
        undoStack.push(c);
        
        // set undoCommand identifier to current command
        undoCommand = undoStack.peek();
    }

    public void offButtonWasPushed(int slot) {
        
        // execute offButton command
        offCommands[slot].execute();
        
        // create a copy of the command object
        Command c = offCommands[slot].copy();
        
        // push command object copy onto undo stack
        undoStack.push(c);
        
        // set undo identifier to current command
        undoCommand = undoStack.peek();
    }

    public void undoButtonWasPushed() {
        
        // Check if there's anything to undo
        if (undoStack.empty() == false) {
            Command c = undoStack.pop();
            c.undo();
            redoStack.push(c);
        }

        // Check if undo stack is now empty
        if (undoStack.empty()) 
            undoCommand = noCommand; 

        // update redo display variable
        redoCommand = redoStack.peek();
    }

    public void redoButtonWasPushed() {
        
        // Check if there's anything to redo
        if (redoStack.empty() == false) {
            Command c = redoStack.pop();
            c.execute();
            undoStack.push(c);  
        }

        // Check if redo stack is empty
        if (redoStack.empty())
            redoCommand = noCommand;
        else 
            redoCommand = redoStack.peek();

        // update undo display variable
        undoCommand = undoStack.peek();
    }

    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                + "    " + offCommands[i].getClass().getName() + "\n");
        }
        stringBuff.append("[undo] " + undoCommand.getClass().getName() + "\n");
        stringBuff.append("[redo] " + redoCommand.getClass().getName() + "\n");
        return stringBuff.toString();
    }
}
