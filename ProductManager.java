import java.io.*;
import java.util.*;

public class ProductManager {
    private static final String FILE_NAME = "products.txt";

    public static void addProduct(Product product) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
        writer.write(product.toString());
        writer.newLine();
        writer.close();
    }

    public static List<Product> getAllProducts() throws IOException {
        List<Product> list = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return list;

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            list.add(Product.fromString(line));
        }
        reader.close();
        return list;
    }

    public static void updateProduct(Product updatedProduct) throws IOException {
        List<Product> products = getAllProducts();
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
        for (Product p : products) {
            if (p.getProductId().equals(updatedProduct.getProductId())) {
                writer.write(updatedProduct.toString());
            } else {
                writer.write(p.toString());
            }
            writer.newLine();
        }
        writer.close();
    }

    public static void deleteProduct(String productId) throws IOException {
        List<Product> products = getAllProducts();
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
        for (Product p : products) {
            if (!p.getProductId().equals(productId)) {
                writer.write(p.toString());
                writer.newLine();
            }
        }
        writer.close();
    }
}
