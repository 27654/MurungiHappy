package happy27654qn6;
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

// Agency class
class Agency extends Entity {
    private String agencyName;
    private String location;
    private String phoneNumber;

    public Agency(int id, Date createdDate, Date updatedDate, String agencyName, String location, String phoneNumber) {
        super(id, createdDate, updatedDate);
        if (!phoneNumber.matches("\\d{9,}")) throw new IllegalArgumentException("Invalid phone number");
        this.agencyName = agencyName;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }

    public String getAgencyName() { return agencyName; }
}

// Agent class
class Agent extends Entity {
    private String agentName;
    private String email;
    private String licenseNumber;

    public Agent(int id, Date createdDate, Date updatedDate, String agentName, String email, String licenseNumber) {
        super(id, createdDate, updatedDate);
        if (!Pattern.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$", email))
            throw new IllegalArgumentException("Invalid email");
        this.agentName = agentName;
        this.email = email;
        this.licenseNumber = licenseNumber;
    }

    public String getAgentName() { return agentName; }
}

// Property class
class Property extends Entity {
    private String propertyCode;
    private String propertyType;
    private double price;

    public Property(int id, Date createdDate, Date updatedDate, String propertyCode, String propertyType, double price) {
        super(id, createdDate, updatedDate);
        if (price <= 0) throw new IllegalArgumentException("Price must be greater than 0");
        this.propertyCode = propertyCode;
        this.propertyType = propertyType;
        this.price = price;
    }

    public double getPrice() { return price; }
    public String getPropertyCode() { return propertyCode; }
}

//  Seller class
class Seller extends Entity {
    private String sellerName;
    private String contactNumber;

    public Seller(int id, Date createdDate, Date updatedDate, String sellerName, String contactNumber) {
        super(id, createdDate, updatedDate);
        if (sellerName.isEmpty() || contactNumber.isEmpty())
            throw new IllegalArgumentException("Seller name and contact cannot be empty");
        this.sellerName = sellerName;
        this.contactNumber = contactNumber;
    }

    public String getSellerName() { return sellerName; }
}

// Buyer class
class Buyer extends Entity {
    private String buyerName;
    private String email;

    public Buyer(int id, Date createdDate, Date updatedDate, String buyerName, String email) {
        super(id, createdDate, updatedDate);
        if (!Pattern.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$", email))
            throw new IllegalArgumentException("Invalid email");
        this.buyerName = buyerName;
        this.email = email;
    }

    public String getBuyerName() { return buyerName; }
}

//  Agreement class
class Agreement extends Entity {
    private Date agreementDate;
    private String terms;

    public Agreement(int id, Date createdDate, Date updatedDate, Date agreementDate, String terms) {
        super(id, createdDate, updatedDate);
        if (agreementDate == null || terms.isEmpty())
            throw new IllegalArgumentException("Agreement date and terms cannot be empty");
        this.agreementDate = agreementDate;
        this.terms = terms;
    }

    public Date getAgreementDate() { return agreementDate; }
}

// Payment class
class Payment extends Entity {
    private double paymentAmount;
    private Date paymentDate;

    public Payment(int id, Date createdDate, Date updatedDate, double paymentAmount, Date paymentDate) {
        super(id, createdDate, updatedDate);
        if (paymentAmount <= 0) throw new IllegalArgumentException("Payment amount must be greater than 0");
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
    }

    public double getPaymentAmount() { return paymentAmount; }
}

//  Commission class
class Commission extends Entity {
    private double commissionRate; // %
    private double commissionAmount;

    public Commission(int id, Date createdDate, Date updatedDate, double commissionRate) {
        super(id, createdDate, updatedDate);
        if (commissionRate < 0) throw new IllegalArgumentException("Commission rate must be ≥ 0");
        this.commissionRate = commissionRate;
        this.commissionAmount = 0; // will calculate later
    }

    public double getCommissionRate() { return commissionRate; }
    public void setCommissionAmount(double amount) { this.commissionAmount = amount; }
    public double getCommissionAmount() { return commissionAmount; }
}

// Final RealEstateRecord class
final class RealEstateRecord extends Commission {
    private Property property;

    public RealEstateRecord(int id, Date createdDate, Date updatedDate, Property property, double commissionRate) {
        super(id, createdDate, updatedDate, commissionRate);
        this.property = property;
    }

    // calculate commission = (price × rate)/100
    public double calculateCommission() {
        double commission = (property.getPrice() * getCommissionRate()) / 100;
        setCommissionAmount(commission);
        return commission;
    }
}

// Main class
public class RealEstateManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<RealEstateRecord> records = new ArrayList<>();

        try {
            // Agency input
            System.out.print("Enter agency name: ");
            String agencyName = sc.nextLine();
            System.out.print("Enter location: ");
            String location = sc.nextLine();
            System.out.print("Enter phone number: ");
            String phone = sc.nextLine();
            Agency agency = new Agency(1, new Date(), new Date(), agencyName, location, phone);

            // Agent input
            System.out.print("Enter agent name: ");
            String agentName = sc.nextLine();
            System.out.print("Enter email: ");
            String email = sc.nextLine();
            System.out.print("Enter license number: ");
            String license = sc.nextLine();
            Agent agent = new Agent(2, new Date(), new Date(), agentName, email, license);

            // Number of properties to record
            System.out.print("Enter number of properties to record: ");
            int numProperties = sc.nextInt();
            sc.nextLine();

            for (int i = 1; i <= numProperties; i++) {
                System.out.println("\n--- Property " + i + " ---");

                // Property input
                System.out.print("Enter property code: ");
                String propertyCode = sc.nextLine();
                System.out.print("Enter property type: ");
                String propertyType = sc.nextLine();
                System.out.print("Enter property price: ");
                double price = sc.nextDouble();
                sc.nextLine();
                Property property = new Property(i + 2, new Date(), new Date(), propertyCode, propertyType, price);

                // Seller input
                System.out.print("Enter seller name: ");
                String sellerName = sc.nextLine();
                System.out.print("Enter contact number: ");
                String sellerContact = sc.nextLine();
                Seller seller = new Seller(i + 2, new Date(), new Date(), sellerName, sellerContact);

                // Buyer input
                System.out.print("Enter buyer name: ");
                String buyerName = sc.nextLine();
                System.out.print("Enter buyer email: ");
                String buyerEmail = sc.nextLine();
                Buyer buyer = new Buyer(i + 2, new Date(), new Date(), buyerName, buyerEmail);

                // Agreement input
                Agreement agreement = new Agreement(i + 2, new Date(), new Date(), new Date(), "Standard Terms");

                // Payment input
                System.out.print("Enter payment amount: ");
                double paymentAmount = sc.nextDouble();
                sc.nextLine();
                Payment payment = new Payment(i + 2, new Date(), new Date(), paymentAmount, new Date());

                // Commission input
                System.out.print("Enter commission rate (%): ");
                double rate = sc.nextDouble();
                sc.nextLine();
                RealEstateRecord record = new RealEstateRecord(i + 2, new Date(), new Date(), property, rate);
                record.calculateCommission(); // calculate commission
                records.add(record);

                System.out.println("Property " + propertyCode + " recorded.\n");
            }

            // Display summary
            System.out.println("\n===== Real Estate Records Summary =====");
            for (int i = 0; i < records.size(); i++) {
                RealEstateRecord r = records.get(i);
                System.out.println("Property " + (i + 1) + " Code: " + r.calculateCommission() + " | Commission: $" + r.getCommissionAmount());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
