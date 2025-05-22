import studentorganizer.OrganizerForm;

import javax.swing.*;
import java.awt.*;

public class Main { // my main
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Planner");
        frame.setContentPane(new OrganizerForm().mainPanel);

        frame.setPreferredSize(new Dimension(350, 450));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


