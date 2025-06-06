# 📚 Student Course Organizer

This is my final project for my OOP25 class. It is a student organizer app so each student can add their classes and manage the different aspects of them.
## 🎯 Features

- Add multiple college courses to organize your semester.
- For each course:
    - Add assignments/projects.
    - Add important academic dates.
    - Use checkboxes to mark tasks as completed.
- Tasks marked as completed are automatically removed when you close the course window.
- View assignment and date counts directly from the main screen.
- Clean and responsive interface designed with IntelliJ's GUI Designer.

## 🧠 Concepts Demonstrated

- ✅ Object-Oriented Programming:
    - Encapsulation (`Course`, `Task`, `Homework`, `ImportantDate`)
    - Inheritance (`Homework` and `ImportantDate` extend `Task`)
- ✅ Use of lists (`ArrayList`, `JList`, `DefaultListModel`)
- ✅ Event handling (`ActionListener`, `MouseListener`)
- ✅ Custom rendering (`CheckboxRenderer` for checkboxes in JList)
- ✅ Method decomposition and clean modular code
- ✅ GUI development with Swing

## 📦 Structure

- `Main.java` – Launches the app
- `OrganizerForm.java` – First screen UI and logic (course list)
- `CourseDetailsForm.java` – Second screen UI for managing individual course content
- `Task.java` – Abstract class for reusable assignment/date structure
- `Homework.java`, `ImportantDate.java` – Inherited task types
- `ChecklistItem.java` – Model for checkbox items in lists
- `CheckboxRenderer.java` – Renderer for showing checkboxes inside JLists

## 🛠 How to Run

1. Open the project in IntelliJ IDEA
2. Make sure you're using a JDK (e.g., Java 17 or later)
3. Run the `Main` class
4. Start adding your courses and organizing your tasks!