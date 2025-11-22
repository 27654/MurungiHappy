package happy27654qn9;
import java.util.*;
import java.util.regex.Pattern;

// Base Entity class
class Entity {
    private int id;
    private Date createdDate;
    private Date updatedDate;

    public Entity(int id, Date createdDate, Date updatedDate) {
        if (id <= 0) throw new IllegalArgumentException("ID must be greater than 0");
        this.id = id;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public int getId() { return id; }
}

// Store class
class Store extends Entity {
    private String storeName;
    private String address;
    private String email;

    public Store(int id, Date createdDate, Date updatedDate, String storeName, String address, String email) {
        super(id, createdDate, updatedDate);
        if (!Pattern.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$", email))
            throw new IllegalArgumentException("Invalid email");
        this.storeName = storeName;
        this.address = address;
        this.email = email;
    }

    public String getStoreName() { return storeName; }
}

// Category class
class Category extends Entity {
    private String categoryName;
    private String categoryCode;

    public Category(int id, Date createdDate, Date updatedDate, String categoryName, String categoryCode) {
        super(id, createdDate, updatedDate);
        if (categoryCode.length() < 3) throw new IllegalArgumentException("Category code must be at least 3 characters");
        this.categoryName = categoryName;
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() { return categoryName; }
}

// Product class
class Product extends Entity {
    private String productName;
    private String productCode;
    private double price;

    public Product(int id, Date createdDate, Date updatedDate, String productName, String productCode, double price) {
        super(id, createdDate, updatedDate);
        if (price <= 0) throw new IllegalArgumentException("Price must be greater than 0");
        this.productName = productName;
        this.productCode = productCode;
        this.price = price;
    }

    public double getPrice() { return price; }
    public String getProductName() { return productName; }
}

//  Customer class
class Customer extends Entity {
    private String customerName;
    private String contactNumber;
    private String address;

    public Customer(int id, Date createdDate, Date updatedDate, String customerName, String contactNumber, String address) {
        super(id, createdDate, updatedDate);
        if (customerName.isEmpty() || contactNumber.isEmpty() || address.isEmpty())
            throw new IllegalArgumentException("Customer fields cannot be empty");
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    public String getCustomerName() { return customerName; }
}

// Order class
class Order extends Entity {
    private Date orderDate;
    private String orderId;

    public Order(int id, Date createdDate, Date updatedDate, Date orderDate, String orderId) {
        super(id, createdDate, updatedDate);
        if (orderDate == null || orderId.isEmpty()) throw new IllegalArgumentException("Order date and ID cannot be empty");
        this.orderDate = orderDate;
        this.orderId = orderId;
    }

    public Date getOrderDate() { return orderDate; }
}

// Payment class
class Payment extends Entity {
    private String paymentMethod;
    private String paymentStatus;

    public Payment(int id, Date createdDate, Date updatedDate, String paymentMethod, String paymentStatus) {
        super(id, createdDate, updatedDate);
        if (paymentMethod.isEmpty() || paymentStatus.isEmpty()) throw new IllegalArgumentException("Payment fields cannot be empty");
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() { return paymentMethod; }
}

// Shipping class
class Shipping extends Entity {
    private String shippingAddress;
    private double shippingCost;

    public Shipping(int id, Date createdDate, Date updatedDate, String shippingAddress, double shippingCost) {
        super(id, createdDate, updatedDate);
        if (shippingCost < 0) throw new IllegalArgumentException("Shipping cost cannot be negative");
        this.shippingAddress = shippingAddress;
        this.shippingCost = shippingCost;
    }

    public double getShippingCost() { return shippingCost; }
}

// Invoice class
class Invoice extends Entity {
    private double totalAmount;

    public Invoice(int id, Date createdDate, Date updatedDate, double totalAmount) {
        super(id, createdDate, updatedDate);
        if (totalAmount <= 0) throw new IllegalArgumentException("Total amount must be greater than 0");
        this.totalAmount = totalAmount;
    }

    public double getTotalAmount() { return totalAmount; }
}

// Final OrderRecord class
final class OrderRecord extends Invoice {
    private Product product;
    private Shipping shipping;

    public OrderRecord(int id, Date createdDate, Date updatedDate, double totalAmount, Product product, Shipping shipping) {
        super(id, createdDate, updatedDate, totalAmount);
        this.product = product;
        this.shipping = shipping;
    }

    // calculateTotalAmount = price + shippingCost
    public double calculateTotalAmount() {
        return product.getPrice() + shipping.getShippingCost();
    }
}

// Main class
public class OnlineShoppingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<OrderRecord> orderRecords = new ArrayList<>();

        try {
            // Store input
            System.out.print("Enter store name: ");
            String storeName = sc.nextLine();
            System.out.print("Enter address: ");
            String storeAddress = sc.nextLine();
            System.out.print("Enter store email: ");
            String storeEmail = sc.nextLine();
            Store store = new Store(1, new Date(), new Date(), storeName, storeAddress, storeEmail);

            // Category input
            System.out.print("Enter category name: ");
            String categoryName = sc.nextLine();
            System.out.print("Enter category code: ");
            String categoryCode = sc.nextLine();
            Category category = new Category(2, new Date(), new Date(), categoryName, categoryCode);

            // Number of orders
            System.out.print("Enter number of orders: ");
            int numOrders = sc.nextInt();
            sc.nextLine(); // consume newline

            for (int i = 1; i <= numOrders; i++) {
                System.out.println("\n--- Order " + i + " ---");

                // Product input
                System.out.print("Enter product name: ");
                String productName = sc.nextLine();
                System.out.print("Enter product code: ");
                String productCode = sc.nextLine();
                System.out.print("Enter product price: ");
                double price = sc.nextDouble();
                sc.nextLine();
                Product product = new Product(i + 2, new Date(), new Date(), productName, productCode, price);

                // Customer input
                System.out.print("Enter customer name: ");
                String customerName = sc.nextLine();
                System.out.print("Enter contact number: ");
                String contact = sc.nextLine();
                System.out.print("Enter customer address: ");
                String custAddress = sc.nextLine();
                Customer customer = new Customer(i + 2, new Date(), new Date(), customerName, contact, custAddress);

                // Order input
                System.out.print("Enter order ID: ");
                String orderId = sc.nextLine();
                Order order = new Order(i + 2, new Date(), new Date(), new Date(), orderId);

                // Payment input
                System.out.print("Enter payment method: ");
                String paymentMethod = sc.nextLine();
                System.out.print("Enter payment status: ");
                String paymentStatus = sc.nextLine();
                Payment payment = new Payment(i + 2, new Date(), new Date(), paymentMethod, paymentStatus);

                // Shipping input
                System.out.print("Enter shipping address: ");
                String shippingAddress = sc.nextLine();
                System.out.print("Enter shipping cost: ");
                double shippingCost = sc.nextDouble();
                sc.nextLine();
                Shipping shipping = new Shipping(i + 2, new Date(), new Date(), shippingAddress, shippingCost);

                // OrderRecord
                OrderRecord orderRecord = new OrderRecord(i + 2, new Date(), new Date(), price + shippingCost, product, shipping);
                orderRecords.add(orderRecord);

                System.out.println("Order for " + customerName + " recorded.\n");
            }

            // Print summary
            System.out.println("\n===== All Orders Summary =====");
            for (int i = 0; i < orderRecords.size(); i++) {
                OrderRecord or = orderRecords.get(i);
                System.out.println("Order " + (i + 1) + " Total Amount: $" + or.calculateTotalAmount());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
