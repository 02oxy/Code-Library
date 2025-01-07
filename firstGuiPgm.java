/*
Firstgui
Version 2024.2.4
Jason Mbanga
Mr. Di Tomasso
Build a simple Gui
 */


package firstGuiPackage;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class firstGuiPgm {
    /**
     * Declare objects
     */
    static JLabel btnTxt;
    static JTextField editableTxt, uneditTxt;
    static JButton btnPlain;
    static JButton btnFancy;

    //method to create GUI
    private static void guiApp() {

        //Create and set up the window.
        JFrame frame = new JFrame("Simple GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create and set up components
        JPanel panel = new JPanel();

        btnTxt = new JLabel("Selection Text");
        btnPlain = new JButton("Send text!");
        btnPlain.setActionCommand("Plain");

        Icon fancyImg = new ImageIcon ("C:\\\\Users\\\\mbangaj100\\\\IdeaProjects\\\\firstGui\\\\images\\\\happy.jpg");
        Image newfancyImg = ((ImageIcon) fancyImg).getImage().getScaledInstance(40,40, java.awt.Image.SCALE_SMOOTH);
        fancyImg= new ImageIcon(newfancyImg);
        //Icon fancyImg= new ImageIcon( "C:\\Users\\mbangaj100\\IdeaProjects\\firstGui\\images\\happy.jpg" );
        btnFancy = new JButton(fancyImg);
        //btnFancy = new JButton("Diff text!");
        btnFancy.setActionCommand("Fancy");



        //create a new ButtonHandler instance
        ButtonHandler onClick = new ButtonHandler();
        btnFancy.addActionListener(onClick);
        btnPlain.addActionListener(onClick);


        editableTxt = new JTextField( "Programmers rock!", 20);
        uneditTxt = new JTextField( "Uneditable text field", 15 );
        uneditTxt.setEditable( false );

        panel.add(btnPlain);
        panel.add(btnFancy);
        panel.add(btnTxt);
        panel.add(editableTxt);
        panel.add(uneditTxt);

        frame.add(panel);
        frame.setSize(250,100);
        frame.setVisible(true);
    }

    //create custom event handler
    private static class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e){
            //which button?
            String command = e.getActionCommand();
            //give message
            if(command.equals("Plain")){
                btnTxt.setText("You picked the plain button");
            } else {
                btnTxt.setText("You picked the Fancy Button!");
            }
        }
    }

    //main method to run the GUI
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                guiApp();
            }
        });
    }
}
