import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ProductManagementGUI {
    private JFrame frame;
    private JTextArea displayArea;

    public ProductManagementGUI() {
        frame = new JFrame("E-Commerce Product Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton addBtn = new JButton("Add Product");
        JButton viewBtn = new JButton("View Products");
        JButton updateBtn = new JButton("Update Product");
        JButton deleteBtn = new JButton("Delete Product");

        displayArea = new JTextArea();
        displayArea.setEditable(false);

        panel.add(addBtn);
        panel.add(viewBtn);
        panel.add(updateBtn);
        panel.add(deleteBtn);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        addBtn.addActionListener(e -> addProduct());
        viewBtn.addActionListener(e -> viewProducts());
        updateBtn.addActionListener(e -> updateProduct());
        deleteBtn.addActionListener(e -> deleteProduct());

        frame.setVisible(true);
    }

    private void addProduct() {
        try {
            String id = JOptionPane.showInputDialog("Enter Product ID:");
            String name = JOptionPane.showInputDialog("Enter Name:");
            String category = JOptionPane.showInputDialog("Enter Category:");
            double price = Double.parseDouble(JOptionPane.showInputDialog("Enter Price:"));
            int stock = Integer.parseInt(JOptionPane.showInputDialog("Enter Stock:"));

            Product p = new Product(id, name, category, price, stock);
            ProductManager.addProduct(p);
            JOptionPane.showMessageDialog(frame, "Product Added!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Invalid Input: " + e.getMessage());
        }
    }

    private void viewProducts() {
        try {
            List<Product> list = ProductManager.getAllProducts();
            displayArea.setText("");
            for (Product p : list) {
                displayArea.append(p.toString() + "\n");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error reading products.");
        }
    }

    private void updateProduct() {
        try {
            String id = JOptionPane.showInputDialog("Enter Product ID to update:");
            String name = JOptionPane.showInputDialog("Enter New Name:");
            String category = JOptionPane.showInputDialog("Enter New Category:");
            double price = Double.parseDouble(JOptionPane.showInputDialog("Enter New Price:"));
            int stock = Integer.parseInt(JOptionPane.showInputDialog("Enter New Stock:"));

            Product updated = new Product(id, name, category, price, stock);
            ProductManager.updateProduct(updated);
            JOptionPane.showMessageDialog(frame, "Product Updated!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage());
        }
    }

    private void deleteProduct() {
        try {
            String id = JOptionPane.showInputDialog("Enter Product ID to delete:");
            ProductManager.deleteProduct(id);
            JOptionPane.showMessageDialog(frame, "Product Deleted!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new ProductManagementGUI();
    }
}
