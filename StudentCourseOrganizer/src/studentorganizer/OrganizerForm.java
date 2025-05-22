package studentorganizer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// class for each aspect of my second screen
public class OrganizerForm {
    public JPanel mainPanel;
    public JButton addCourseButton;
    public JList courseList;
    public JLabel plannerTitle;
    public JLabel courseInfoLabel;

    private ArrayList<Course> courses = new ArrayList<>(); // to store courses added

    public OrganizerForm() {// constructor for this class

        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(mainPanel, "Enter course name:");
                if (name != null && !name.trim().isEmpty()) {
                    Course newCourse = new Course(name.trim());
                    courses.add(newCourse);
                    updateCourseList();
                }
            }
        });

        courseList.addListSelectionListener(e -> { //listener
            if (!e.getValueIsAdjusting()) {
                String selectedName = (String) courseList.getSelectedValue();
                if (selectedName != null) {
                    Course selectedCourse = findCourseByName(selectedName);
                    if (selectedCourse != null) {

                        courseInfoLabel.setText("<html>Selected Course: " + selectedCourse.getName() + "<br>" +
                                "Assignments: " + countTasks(selectedCourse, Homework.class) + "<br>" +
                                "Important Dates: " + countTasks(selectedCourse, ImportantDate.class) + "</html>");

                        JFrame courseFrame = new JFrame("Course: " + selectedCourse.getName());
                        courseFrame.setContentPane(new CourseDetailsForm(selectedCourse).mainPanel);
                        courseFrame.setSize(350, 450);   // size for this screen
                        courseFrame.setLocationRelativeTo(null);
                        courseFrame.setVisible(true);
                    }
                }
            }
        });
    }

    // method to update cousrse list
    private void updateCourseList() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Course c : courses) {
            model.addElement(c.getName());
        }
        courseList.setModel(model);
    }

    private Course findCourseByName(String name) {
        for (Course c : courses) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    private int countTasks(Course course, Class<?> type) {
        int count = 0;
        for (Task t : course.getTasks()) {
            if (type.isInstance(t)) {
                count++;
            }
        }
        return count;
    }
}
