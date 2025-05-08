import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Employegui {
    private JFrame frame;
    private JTextArea displayArea;

    public Employegui() {
        frame = new JFrame("Employee Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton addBtn = new JButton("Add New Employee");
        JButton viewBtn = new JButton("View All Employee");
        JButton updateBtn = new JButton("Update Employee Details");
        JButton deleteBtn = new JButton("Delete an Employee Record");

        displayArea = new JTextArea();
        displayArea.setEditable(false);

        panel.add(addBtn);
        panel.add(viewBtn);
        panel.add(updateBtn);
        panel.add(deleteBtn);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        addBtn.addActionListener(e -> addEmploye());
        viewBtn.addActionListener(e -> viewEmploye());
        updateBtn.addActionListener(e -> updateEmploye());
        deleteBtn.addActionListener(e -> deleteEmploye());

        frame.setVisible(true);
    }
    public void addEmploye(){
        try {
            String id = JOptionPane.showInputDialog("Enter Employee ID:");
            String name = JOptionPane.showInputDialog("Enter Name:");
            String Department = JOptionPane.showInputDialog("Enter department:");
            double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter salary:"));
           String email = JOptionPane.showInputDialog("enter email");

            Employe p = new Employe(id, name, Department, salary, email);
            EmployeManager.addEmploye(p);
            JOptionPane.showMessageDialog(frame, "employeee info Added!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Invalid Input: " + e.getMessage());
        }
    }
    private void viewEmploye() {
        try {
            List<Employe> list = EmployeManager.getallEmploye();
            displayArea.setText("");
            for (Employe p : list) {
                displayArea.append(p.toString() + "\n");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error reading info.");
        }
    }

    private void updateEmploye() {
        try {
            String id = JOptionPane.showInputDialog("Enter emloyee ID to update:");
            String name = JOptionPane.showInputDialog("Enter New Name:");
            String Department = JOptionPane.showInputDialog("Enter New department:");
            double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter New salary:"));
            String email = JOptionPane.showInputDialog("enter email");

            Employe updated = new Employe(id, name, Department, salary, email);
            EmployeManager.updateEmploye(updated);
            JOptionPane.showMessageDialog(frame, "Employe info Updated!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage());
        }
    }
    private void deleteEmploye() {
        try {
            String id = JOptionPane.showInputDialog("Enter employee ID to delete:");
            EmployeManager.deleteemployee(id);
            JOptionPane.showMessageDialog(frame, "employee info Deleted!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        new Employegui();
    }
}
