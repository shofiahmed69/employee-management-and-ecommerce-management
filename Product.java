public class Product {
    private String productId;
    private String name;
    private String category;
    private double price;
    private int stock;

    public Product(String productId, String name, String category, double price, int stock) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        setPrice(price);
        setStock(stock);
    }

    // Getters and Setters with validation
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price > 0)
            this.price = price;
        else
            throw new IllegalArgumentException("Price must be positive.");
    }

    public int getStock() { return stock; }
    public void setStock(int stock) {
        if (stock >= 0)
            this.stock = stock;
        else
            throw new IllegalArgumentException("Stock must be non-negative.");
    }

    @Override
    public String toString() {
        return productId + "," + name + "," + category + "," + price + "," + stock;
    }

    public static Product fromString(String line) {
        String[] parts = line.split(",");
        return new Product(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]), Integer.parseInt(parts[4]));
    }
}
