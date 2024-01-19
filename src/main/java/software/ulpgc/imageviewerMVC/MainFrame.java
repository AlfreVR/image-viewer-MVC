package software.ulpgc.imageviewerMVC;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private ImageDisplay imageDisplay;
    private final Map<String, Command> commands;



    public MainFrame() {
        this.commands = new HashMap<>();
        setTitle("Image Viewer");
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        add(createImageDisplay());
        add(createToolbar(), BorderLayout.SOUTH);
    }

    private Component createToolbar() {
        JPanel panel = new JPanel();
        panel.add(createButton("<"));
        panel.add(createButton(">"));
        return panel;
    }

    private Component createButton(String label) {
        JButton button = new JButton(label);
        button.addActionListener(e -> commands.get(label).execute());
        if(button.getText().equals("<")) button.setText("←");
        if(button.getText().equals(">")) button.setText("→");
        return button;
    }

    private Component createImageDisplay() {
        SwingImageDisplay display = new SwingImageDisplay();
        this.imageDisplay = display;
        return display;
    }


    public void add(String name, Command command) {
        commands.put(name, command);
    }

    public ImageDisplay imageDisplay() {
        return imageDisplay;
    }
}
