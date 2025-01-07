/*
MenuProgram
v0.1
Jason Mbanga
Mr Di Tomasso
The purpose of this program is to create a Jmenu, which can either close the app, or open a new window
 */


package menuProgramPkg;

import javax.swing.*;
import java.awt.*;

public class MenuProgram {

    static JPanel mainPanel;

    private static void MenuApp() {
        // Main content panel
        JFrame frame = new JFrame("MenuProgram");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());
        ImageIcon logo = new ImageIcon("Images/Gear-icon.png"); // Use a relative path
        frame.setIconImage(logo.getImage());

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.BLUE);
        frame.add(mainPanel, BorderLayout.CENTER);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create Menu1 and its item to close the app
        JMenu menu1 = new JMenu("close");
        menu1.setMnemonic('1');
        JMenuItem closeItem = new JMenuItem("Close App");
        closeItem.addActionListener(e -> System.exit(0)); // Close the app
        menu1.add(closeItem);

        // Create Menu2 and its item to open a new JFrame
        JMenu menu2 = new JMenu("Full Programs");
        menu2.setMnemonic('2');
        JMenuItem openFrameItem = new JMenuItem("FirstGui source code");
        openFrameItem.addActionListener(e -> openCodeFrame1()); // Open a new JFrame
        menu2.add(openFrameItem);

        // Create Menu3 and its item
        JMenu menu3 = new JMenu("Code Snippets");
        menu3.setMnemonic('3');
        JMenuItem item3 = new JMenuItem("Item3");
        menu3.add(item3);

        // Add menus to the menu bar
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);

        // Set the menu bar on the frame
        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }

    // Method to open a new JFrame
    private static void openCodeFrame1() {
        JFrame newFrame = new JFrame("ex");
        newFrame.setSize(400, 300);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setLayout(new BorderLayout());
        JLabel label = new JLabel("", SwingConstants.CENTER);
        newFrame.add(label, BorderLayout.CENTER);

        newFrame.setVisible(true);
    }

    private static void openNewFrame2() {
        JFrame newFrame = new JFrame("New Window");
        newFrame.setSize(400, 300);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setLayout(new BorderLayout());

        JLabel label = new JLabel("This is a new window!", SwingConstants.CENTER);
        newFrame.add(label, BorderLayout.CENTER);

        newFrame.setVisible(true);
    }







    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(MenuProgram::MenuApp);
    }
}



