package software.ulpgc.imageviewerMVC;

import javax.swing.*;

import java.io.File;

public class Main {
    public static final String root = "path";
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Image image = new FileImageLoader(new File(root)).load();
        frame.imageDisplay().show(image);
        frame.add("<", new PreviousImageCommand(frame.imageDisplay()));
        frame.add(">", new NextImageCommand(frame.imageDisplay()));
        frame.setVisible(true);
    }}
