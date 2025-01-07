package programTaskOnePackage;
/* programTaskOne
    0.1
    Jason M
    Mr Di Tomasso

    The purpose of this code is to calculate the ones, tens, and hundreds in a number
     as well as the area and circumference of a circle with the radius that is entered by the user
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.io.*;

public class programTaskOne {

    public static double hundreds, tens, ones, sum, completeNum;
    public static double radiusEntered, area, circumference;
    public static double PI = 3.14159;


    private static void calcGuiApp() {


        JFrame baseCalculationFrame = new JFrame("this is the frame");
        baseCalculationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainCalculationPanel = new JPanel();
    }


    public static void main(String[] args) {

        String numDigit = JOptionPane.showInputDialog("Welcome to our program! Please enter a number (less than or equal to three digits) into the text box!");
        completeNum = Integer.parseInt(numDigit);

        hundreds = completeNum/100;
        tens = completeNum/10;
        ones = completeNum;
        sum = ones+tens+hundreds;

        //create a message dialog box so the calculations can be displayed to the user
        JOptionPane.showMessageDialog(null, "Value of ones = " + ones + "\nValue of tens = " + tens + "\nValue of hundreds = " + hundreds + "\n The sum of the digits is " + sum);
        DecimalFormat twoDigit = new DecimalFormat("#,##0.00"); // this isn't reallynecessary for this assignment, but I wanted to show how you to format numbersComputer Engineering

        // create my second input dialog box so the user can enter the radius
        String numPiAndCircumfrance = JOptionPane.showInputDialog("Now, enter the radius of your circle");
        radiusEntered = Integer.parseInt(numPiAndCircumfrance);

        area = PI*radiusEntered;
        circumference = 2*PI*radiusEntered;

        JOptionPane.showMessageDialog(null, "area = " + area + "\ncircumferance = " + circumference );




    }
}

