package studentorganizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CourseDetailsForm { // this class will be for each aspect of my second screen

    public JPanel mainPanel;
    public JLabel courseTitleLabel;
    public JButton addAssignmentButton;
    public JButton addDateButton;
    public JList<ChecklistItem> assignmentsList;
    public JList<ChecklistItem> datesList;
    public JLabel courseAssignments;
    public JLabel importantCourseDates;

    private Course course;
    private DefaultListModel<ChecklistItem> assignmentModel;
    private DefaultListModel<ChecklistItem> dateModel;

    // heres my constructor
    public CourseDetailsForm(Course course) {
        this.course = course;
        courseTitleLabel.setText(course.getName());

        assignmentModel = new DefaultListModel<>();
        assignmentsList.setModel(assignmentModel);
        assignmentsList.setCellRenderer(new CheckboxRenderer());
        assignmentsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = assignmentsList.locationToIndex(e.getPoint());
                if (index != -1) {
                    ChecklistItem item = assignmentModel.getElementAt(index);
                    item.setSelected(!item.isSelected());
                    assignmentsList.repaint();
                }
            }
        });

        dateModel = new DefaultListModel<>();
        datesList.setModel(dateModel);
        datesList.setCellRenderer(new CheckboxRenderer());
        datesList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = datesList.locationToIndex(e.getPoint());
                if (index != -1) {
                    ChecklistItem item = dateModel.getElementAt(index);
                    item.setSelected(!item.isSelected());
                    datesList.repaint();
                }
            }
        });

        for (Task t : course.getTasks()) {
            if (t instanceof Homework) {
                assignmentModel.addElement(new ChecklistItem(t.getTitle()));
            } else if (t instanceof ImportantDate) {
                dateModel.addElement(new ChecklistItem(t.getTitle()));
            }
        }
        // functionality for my buttons
        addAssignmentButton.addActionListener(e -> {
            String title = JOptionPane.showInputDialog(mainPanel, "Enter assignment or project:");
            if (title != null && !title.isBlank()) {
                Homework hw = new Homework(title);
                course.addTask(hw);
                assignmentModel.addElement(new ChecklistItem(hw.getTitle())); // Show in UI
            }
        });
        addDateButton.addActionListener(e -> {
            String dateTitle = JOptionPane.showInputDialog(mainPanel, "Enter important date or event:");
            if (dateTitle != null && !dateTitle.isBlank()) {
                ImportantDate date = new ImportantDate(dateTitle);
                course.addTask(date);
                dateModel.addElement(new ChecklistItem(date.getTitle()));
            }
        });
        SwingUtilities.invokeLater(() -> { // to remove tasks when the checkbox is marked
            Window window = SwingUtilities.getWindowAncestor(mainPanel);
            if (window instanceof JFrame) {
                ((JFrame) window).addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        removeCompletedTasks();
                    }
                });
            }
        });
    }
    private void removeCompletedTasks() {// method for removiung classes
        // the loop for assignments to be removed after selected
        for (int i = assignmentModel.size() - 1; i >= 0; i--) {
            ChecklistItem item = assignmentModel.getElementAt(i);
            if (item.isSelected()) {
                assignmentModel.remove(i);
                course.removeTaskByTitle(item.getText());
            }
        }
        for (int i = dateModel.size() - 1; i >= 0; i--) {
            ChecklistItem item = dateModel.getElementAt(i);
            if (item.isSelected()) {
                dateModel.remove(i);
                course.removeTaskByTitle(item.getText());
            }
        }
    }
}
