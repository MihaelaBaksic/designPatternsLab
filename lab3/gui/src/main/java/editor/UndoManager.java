package editor;

import editor.actions.undoables.EditAction;

import java.util.Stack;

public class UndoManager {

    Stack<EditAction> undoStack;
    Stack<EditAction> redoStack;

    private static UndoManager instance;

    public static UndoManager getInstance(){
        if(instance==null){
            instance = new UndoManager();
        }
        return instance;
    }

    private UndoManager(){
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public void undo(){
        if(!undoStack.empty()){
            EditAction action = undoStack.pop();
            redoStack.push(action);
            action.executeUndo();
        }
    }

    public void redo(){
        if(!redoStackEmpty()){
            EditAction action = redoStack.pop();
            undoStack.push(action);
            action.executeDo();
        }
    }


    public void push(EditAction c){
        redoStack.clear();
        undoStack.push(c);
    }

    public boolean undoStackEmpty(){
        return undoStack.empty();
    }

    public boolean redoStackEmpty(){
        return redoStack.empty();
    }

}
