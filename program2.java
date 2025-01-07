package program2pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class program2 {

    static JButton btn911;
    static JButton btnpana;
    static JButton btnmacan;
    static JLabel shownImgCar;
    static JPanel optionsPanel1;
    static JPanel optionsPanel2;
    static JPanel optionsPanel3;
    static JPanel colorPanel;
    static JPanel mainPanel;
    static JButton nextButton;
    static int price = 0;
    static JLabel priceCalc;


    // Tracks the current step
    static int step = 1;

    // The app
    private static void App() {

        // This is the entire window
        JFrame frame = new JFrame("Porsche Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon logo = new ImageIcon("C:\\Users\\Jason\\IdeaProjects\\jawn\\images\\PorscheLogo.png");
        frame.setIconImage(logo.getImage());
        frame.setSize(1100, 600);
        frame.setLayout(new BorderLayout());

        // Main content panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.BLUE);

        // Buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(3, 1));
        buttonsPanel.setBackground(Color.BLUE);

        btn911 = new JButton("Porsche 911");
        btn911.setActionCommand("911press");
        btnpana = new JButton("Porsche Panamera");
        btnpana.setActionCommand("panapress");
        btnmacan = new JButton("Porsche Macan");
        btnmacan.setActionCommand("macanpress");

        buttonsPanel.add(btn911);
        buttonsPanel.add(btnpana);
        buttonsPanel.add(btnmacan);

        // Car image
        shownImgCar = new JLabel("Car image will appear here");
        shownImgCar.setHorizontalAlignment(SwingConstants.CENTER);
        shownImgCar.setPreferredSize(new Dimension(480, 270));

        // "Next" button
        nextButton = new JButton("Next");
        nextButton.setVisible(false); // Initially hidden
        nextButton.addActionListener(e -> showNextStep());

        // Options panels
        optionsPanel1 = createOptionsPanel("Opt1");
        optionsPanel2 = createOptionsPanel("Opt2");
        optionsPanel3 = createOptionsPanel("Opt3");

        //Price panel
        priceCalc = new JLabel("price will appear here");
        priceCalc.setHorizontalAlignment(SwingConstants.BOTTOM);

        // Color selection panel
        colorPanel = createColorPanel();

        // Add components to main panel
        mainPanel.add(buttonsPanel, BorderLayout.WEST);
        mainPanel.add(shownImgCar, BorderLayout.CENTER);
        mainPanel.add(nextButton, BorderLayout.SOUTH);
        mainPanel.add(priceCalc, BorderLayout.NORTH);

        // Add the main panel to the frame
        frame.add(mainPanel, BorderLayout.CENTER);

        // Default visibility
        optionsPanel1.setVisible(false);
        optionsPanel2.setVisible(false);
        optionsPanel3.setVisible(false);

        // Event handling
        ButtonHandler onClick = new ButtonHandler();
        btn911.addActionListener(onClick);
        btnpana.addActionListener(onClick);
        btnmacan.addActionListener(onClick);

        frame.setVisible(true);
    }

    // Creates an options panel
    private static JPanel createOptionsPanel(String label) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 1));
        panel.setPreferredSize(new Dimension(150, 270));
        panel.setBackground(Color.LIGHT_GRAY);

        for (int i = 0; i < 8; i++) {
            JRadioButton option = new JRadioButton(label + " Option " + (i + 1));
            panel.add(option);
        }

        return panel;
    }

    // Creates the color selection panel
    private static JPanel createColorPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.setPreferredSize(new Dimension(150, 270));
        panel.setBackground(Color.LIGHT_GRAY);

        String[] colors = {"Red", "Blue", "Black", "White"};
        for (String color : colors) {
            JButton colorButton = new JButton(color);
            colorButton.addActionListener(e -> {
                shownImgCar.setText("Selected Color: " + color);
            });
            panel.add(colorButton);
        }

        return panel;
    }

    // Handles button actions
    private static class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            String imagePath = "";

            // Remove any existing options panel
            mainPanel.remove(optionsPanel1);
            mainPanel.remove(optionsPanel2);
            mainPanel.remove(optionsPanel3);

            // Determine the image path and show the relevant options panel
            if (command.equals("911press")) {
                imagePath = "C:\\Users\\mbangaj100\\IdeaProjects\\Program2\\Images\\911Plain.png";
                shownImgCar.setText("Porsche 911 Selected");
                mainPanel.add(optionsPanel1, BorderLayout.EAST);
            } else if (command.equals("panapress")) {
                imagePath = "C:\\Users\\mbangaj100\\IdeaProjects\\Program2\\Images\\panameraPlain.png";
                shownImgCar.setText("Porsche Panamera Selected");
                mainPanel.add(optionsPanel2, BorderLayout.EAST);
            } else if (command.equals("macanpress")) {
                imagePath = "C:\\Users\\mbangaj100\\IdeaProjects\\Program2\\Images\\iris.png";
                shownImgCar.setText("Porsche Macan Selected");
                mainPanel.add(optionsPanel3, BorderLayout.EAST);
            }

            if (!imagePath.isEmpty()) {
                // Resize the image to 480x270
                ImageIcon icon = new ImageIcon(imagePath);
                Image scaledImage = icon.getImage().getScaledInstance(480, 270, Image.SCALE_SMOOTH);
                icon = new ImageIcon(scaledImage);

                // Set the resized image in the JLabel
                shownImgCar.setIcon(icon);
                nextButton.setVisible(true); // Enable the "Next" button
            } else {
                shownImgCar.setText("Image not found!");
                shownImgCar.setIcon(null); // Clear any previous image
            }

            // Refresh the layout to show changes
            mainPanel.revalidate();
            mainPanel.repaint();
        }
    }

    // Transitions to the next step (color selection)
    private static void showNextStep() {
        if (step == 1) {

            mainPanel.add(colorPanel, BorderLayout.EAST);

            shownImgCar.setText("Select a Color");
            nextButton.setVisible(false); // Hide "Next" button for now
            step++; // Advance step
        }
        if (step == 2) {
            mainPanel.remove(colorPanel);

        }
        // Refresh the layout
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    // Runs the app
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(program2::App);
    }
}