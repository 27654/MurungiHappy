package happy27654qn4;

import java.util.Scanner;
import java.time.LocalDate;

// Entity
class Entity {
    private int id;
    private String createdDate;
    private String updatedDate;

    public Entity(int id, String createdDate, String updatedDate) {
        if (id <= 0) throw new IllegalArgumentException("ID must be >0");
        if (createdDate == null || createdDate.isEmpty()) throw new IllegalArgumentException("createdDate required");
        if (updatedDate == null || updatedDate.isEmpty()) throw new IllegalArgumentException("updatedDate required");
        this.id = id;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public int getId() { return id; }
    public String getCreatedDate() { return createdDate; }
    public String getUpdatedDate() { return updatedDate; }
}

//  Company
class Company extends Entity {
    private String companyName;
    private String address;
    private String phoneNumber;

    public Company(int id, String createdDate, String updatedDate, String companyName, String address, String phoneNumber) {
        super(id, createdDate, updatedDate);
        if (companyName == null || companyName.isEmpty()) throw new IllegalArgumentException("companyName required");
        if (address == null || address.isEmpty()) throw new IllegalArgumentException("address required");
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) throw new IllegalArgumentException("Phone must be 10 digits");
        this.companyName = companyName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getCompanyName() { return companyName; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
}

//  Branch
class Branch extends Company {
    private String branchName;
    private String locationCode;

    public Branch(int id, String createdDate, String updatedDate, String companyName, String address, String phoneNumber,
                  String branchName, String locationCode) {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber);
        if (branchName == null || branchName.isEmpty()) throw new IllegalArgumentException("branchName required");
        if (locationCode == null || locationCode.length() < 3) throw new IllegalArgumentException("locationCode ≥3 chars required");
        this.branchName = branchName;
        this.locationCode = locationCode;
    }

    public String getBranchName() { return branchName; }
    public String getLocationCode() { return locationCode; }
}

//  Vehicle
class Vehicle extends Branch {
    private String vehicleType;
    private String registrationNumber;
    private double dailyRate;

    public Vehicle(int id, String createdDate, String updatedDate, String companyName, String address, String phoneNumber,
                   String branchName, String locationCode, String vehicleType, String registrationNumber, double dailyRate) {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, branchName, locationCode);
        if (vehicleType == null || vehicleType.isEmpty()) throw new IllegalArgumentException("vehicleType required");
        if (registrationNumber == null || registrationNumber.isEmpty()) throw new IllegalArgumentException("registrationNumber required");
        if (dailyRate <= 0) throw new IllegalArgumentException("dailyRate must be >0");
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
        this.dailyRate = dailyRate;
    }

    public String getVehicleType() { return vehicleType; }
    public String getRegistrationNumber() { return registrationNumber; }
    public double getDailyRate() { return dailyRate; }
}

//  Customer
class Customer extends Vehicle {
    private String customerName;
    private String licenseNumber;
    private String contactNumber;

    public Customer(int id, String createdDate, String updatedDate, String companyName, String address, String phoneNumber,
                    String branchName, String locationCode, String vehicleType, String registrationNumber, double dailyRate,
                    String customerName, String licenseNumber, String contactNumber) {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, branchName, locationCode, vehicleType, registrationNumber, dailyRate);
        if (customerName == null || customerName.isEmpty()) throw new IllegalArgumentException("customerName required");
        if (licenseNumber == null || licenseNumber.isEmpty()) throw new IllegalArgumentException("licenseNumber required");
        if (contactNumber == null || !contactNumber.matches("\\d{10}")) throw new IllegalArgumentException("contactNumber must be 10 digits");
        this.customerName = customerName;
        this.licenseNumber = licenseNumber;
        this.contactNumber = contactNumber;
    }

    public String getCustomerName() { return customerName; }
    public String getLicenseNumber() { return licenseNumber; }
    public String getContactNumber() { return contactNumber; }
}

// Rental
class Rental extends Customer {
    private String rentalDate;
    private String returnDate;
    private int rentalDays;

    public Rental(int id, String createdDate, String updatedDate, String companyName, String address, String phoneNumber,
                  String branchName, String locationCode, String vehicleType, String registrationNumber, double dailyRate,
                  String customerName, String licenseNumber, String contactNumber,
                  String rentalDate, String returnDate, int rentalDays) {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, branchName, locationCode, vehicleType, registrationNumber, dailyRate,
                customerName, licenseNumber, contactNumber);
        if (rentalDate == null || rentalDate.isEmpty()) throw new IllegalArgumentException("rentalDate required");
        if (returnDate == null || returnDate.isEmpty()) throw new IllegalArgumentException("returnDate required");
        if (rentalDays <= 0) throw new IllegalArgumentException("rentalDays must be >0");
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.rentalDays = rentalDays;
    }

    public String getRentalDate() { return rentalDate; }
    public String getReturnDate() { return returnDate; }
    public int getRentalDays() { return rentalDays; }
}

//  Charge
class Charge extends Rental {
    private double rentalCharge;
    private double penaltyCharge;

    public Charge(int id, String createdDate, String updatedDate, String companyName, String address, String phoneNumber,
                  String branchName, String locationCode, String vehicleType, String registrationNumber, double dailyRate,
                  String customerName, String licenseNumber, String contactNumber,
                  String rentalDate, String returnDate, int rentalDays,
                  double rentalCharge, double penaltyCharge) {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, branchName, locationCode,
                vehicleType, registrationNumber, dailyRate, customerName, licenseNumber, contactNumber,
                rentalDate, returnDate, rentalDays);
        if (rentalCharge < 0 || penaltyCharge < 0) throw new IllegalArgumentException("Charges ≥0 required");
        this.rentalCharge = rentalCharge;
        this.penaltyCharge = penaltyCharge;
    }

    public double getRentalCharge() { return rentalCharge; }
    public double getPenaltyCharge() { return penaltyCharge; }
}

// Payment
class Payment extends Charge {
    private String paymentMode;
    private String transactionId;

    public Payment(int id, String createdDate, String updatedDate, String companyName, String address, String phoneNumber,
                   String branchName, String locationCode, String vehicleType, String registrationNumber, double dailyRate,
                   String customerName, String licenseNumber, String contactNumber,
                   String rentalDate, String returnDate, int rentalDays,
                   double rentalCharge, double penaltyCharge,
                   String paymentMode, String transactionId) {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, branchName, locationCode,
                vehicleType, registrationNumber, dailyRate, customerName, licenseNumber, contactNumber,
                rentalDate, returnDate, rentalDays, rentalCharge, penaltyCharge);
        if (paymentMode == null || paymentMode.isEmpty()) throw new IllegalArgumentException("paymentMode required");
        if (transactionId == null || transactionId.isEmpty()) throw new IllegalArgumentException("transactionId required");
        this.paymentMode = paymentMode;
        this.transactionId = transactionId;
    }

    public String getPaymentMode() { return paymentMode; }
    public String getTransactionId() { return transactionId; }
}

// Invoice
class Invoice extends Payment {
    private double totalCharge;

    public Invoice(int id, String createdDate, String updatedDate, String companyName, String address, String phoneNumber,
                   String branchName, String locationCode, String vehicleType, String registrationNumber, double dailyRate,
                   String customerName, String licenseNumber, String contactNumber,
                   String rentalDate, String returnDate, int rentalDays,
                   double rentalCharge, double penaltyCharge,
                   String paymentMode, String transactionId,
                   double totalCharge) {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, branchName, locationCode,
                vehicleType, registrationNumber, dailyRate, customerName, licenseNumber, contactNumber,
                rentalDate, returnDate, rentalDays, rentalCharge, penaltyCharge, paymentMode, transactionId);
        if (totalCharge <= 0) throw new IllegalArgumentException("totalCharge must be >0");
        this.totalCharge = totalCharge;
    }

    public double getTotalCharge() { return totalCharge; }
}

//  RentalRecord
final class RentalRecord extends Invoice {

    public RentalRecord(int id, String createdDate, String updatedDate, String companyName, String address, String phoneNumber,
                        String branchName, String locationCode, String vehicleType, String registrationNumber, double dailyRate,
                        String customerName, String licenseNumber, String contactNumber,
                        String rentalDate, String returnDate, int rentalDays,
                        double rentalCharge, double penaltyCharge,
                        String paymentMode, String transactionId,
                        double totalCharge) {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, branchName, locationCode, vehicleType,
                registrationNumber, dailyRate, customerName, licenseNumber, contactNumber, rentalDate, returnDate,
                rentalDays, rentalCharge, penaltyCharge, paymentMode, transactionId, totalCharge);
    }

    public double calculateTotalCharge() {
        return getRentalCharge() + getPenaltyCharge();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Vehicle Rental System ===");

        int id;
        do {
            System.out.print("ID (>0): "); id = sc.nextInt();
        } while (id <= 0);

        sc.nextLine();
        System.out.print("Company Name: "); String companyName = sc.nextLine();
        System.out.print("Company Address: "); String address = sc.nextLine();
        String phone;
        do { System.out.print("Company Phone (10 digits): "); phone = sc.next(); } while (!phone.matches("\\d{10}"));

        sc.nextLine();
        System.out.print("Branch Name: "); String branchName = sc.nextLine();
        String locationCode;
        do { System.out.print("Location Code (≥3 chars): "); locationCode = sc.nextLine(); } while (locationCode.length()<3);

        System.out.print("Vehicle Type: "); String vehicleType = sc.nextLine();
        System.out.print("Registration Number: "); String regNumber = sc.nextLine();
        double dailyRate;
        do { System.out.print("Daily Rate (>0): "); dailyRate = sc.nextDouble(); } while (dailyRate <=0);

        sc.nextLine();
        System.out.print("Customer Name: "); String customerName = sc.nextLine();
        String licenseNumber;
        do { System.out.print("License Number: "); licenseNumber = sc.nextLine(); } while (licenseNumber.isEmpty());
        String contactNumber;
        do { System.out.print("Contact Number (10 digits): "); contactNumber = sc.next(); } while (!contactNumber.matches("\\d{10}"));

        sc.nextLine();
        System.out.print("Rental Date (YYYY-MM-DD): "); String rentalDate = sc.nextLine();
        System.out.print("Return Date (YYYY-MM-DD): "); String returnDate = sc.nextLine();
        int rentalDays;
        do { System.out.print("Rental Days (>0): "); rentalDays = sc.nextInt(); } while (rentalDays <=0);

        double rentalCharge;
        do { System.out.print("Rental Charge (≥0): "); rentalCharge = sc.nextDouble(); } while (rentalCharge<0);
        double penaltyCharge;
        do { System.out.print("Penalty Charge (≥0): "); penaltyCharge = sc.nextDouble(); } while (penaltyCharge<0);

        sc.nextLine();
        String paymentMode;
        do { System.out.print("Payment Mode: "); paymentMode = sc.nextLine(); } while(paymentMode.isEmpty());
        System.out.print("Transaction ID: "); String transactionId = sc.nextLine();

        double totalCharge = rentalCharge + penaltyCharge;

        RentalRecord record = new RentalRecord(id, LocalDate.now().toString(), LocalDate.now().toString(),
                companyName, address, phone, branchName, locationCode, vehicleType, regNumber, dailyRate,
                customerName, licenseNumber, contactNumber,
                rentalDate, returnDate, rentalDays,
                rentalCharge, penaltyCharge, paymentMode, transactionId, totalCharge
        );

        System.out.printf("Total Charge = %.2f\n", record.calculateTotalCharge());
        sc.close();
    }
}
