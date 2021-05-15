package editor;

import editor.components.TextEditor;
import editor.components.Toolbar;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    public Main() {
        super();

        this.setTitle("TextEditor");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        var menu = new Menu();

        this.getContentPane().add(new Toolbar(), BorderLayout.NORTH);
        TextEditor textEditor = new TextEditor();
        this.getContentPane().add(textEditor, BorderLayout.CENTER);
        this.setJMenuBar(textEditor.getMenuBar());


        this.setSize(600, 600);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new Main();
        });
    }
}
