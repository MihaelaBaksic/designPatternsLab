package editor.actions.deletion;

import editor.UndoManager;
import editor.actions.undoables.UndoableAction;
import editor.models.TextEditorModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteBeforeAction extends AbstractAction {

    private TextEditorModel model;
    private UndoManager manager;

    public DeleteBeforeAction(String name, TextEditorModel model, UndoManager manager){
        super(name);
        this.model = model;
        this.manager = manager;

        this.putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke((char) KeyEvent.VK_BACK_SPACE));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UndoableAction a = new UndoableAction(model);

        a.setCursorPrior(model.getCursor());
        a.setTextPrior(model.getLines());

        model.deleteBefore();
        model.removeSelection();

        a.setCursorPosterior(model.getCursor());
        a.setTextPosterior(model.getLines());

        manager.push(a);
    }
}
