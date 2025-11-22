package happy27654qn3;

import java.util.Scanner;
import java.time.LocalDate;

class EntityR {
    private int id;
    private String createdDate;
    private String updatedDate;

    public EntityR(int id, String createdDate, String updatedDate) {
        if (id <= 0) throw new IllegalArgumentException("id must be > 0");
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

class Hotel extends EntityR {
    private String hotelName;
    private String address;
    private String phoneNumber;
    private String email;

    public Hotel(int id, String createdDate, String updatedDate,
                 String hotelName, String address, String phoneNumber, String email) {
        super(id, createdDate, updatedDate);
        if (hotelName == null || hotelName.isEmpty()) throw new IllegalArgumentException("hotelName required");
        if (address == null || address.isEmpty()) throw new IllegalArgumentException("address required");
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) throw new IllegalArgumentException("phone must be 10 digits");
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) throw new IllegalArgumentException("invalid email");
        this.hotelName = hotelName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getHotelName() { return hotelName; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
}

class Room extends Hotel {
    private String roomNumber;
    private String roomType;
    private double pricePerNight;

    public Room(int id, String createdDate, String updatedDate,
                String hotelName, String address, String phoneNumber, String email,
                String roomNumber, String roomType, double pricePerNight) {
        super(id, createdDate, updatedDate, hotelName, address, phoneNumber, email);
        if (roomNumber == null || roomNumber.isEmpty()) throw new IllegalArgumentException("roomNumber required");
        if (roomType == null || roomType.isEmpty()) throw new IllegalArgumentException("roomType required");
        if (pricePerNight <= 0) throw new IllegalArgumentException("pricePerNight must be > 0");
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
    }

    public String getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public double getPricePerNight() { return pricePerNight; }
}

class Customer extends Room {
    private String customerName;
    private String customerEmail;
    private String contactNumber;

    public Customer(int id, String createdDate, String updatedDate,
                    String hotelName, String address, String phoneNumber, String email,
                    String roomNumber, String roomType, double pricePerNight,
                    String customerName, String customerEmail, String contactNumber) {
        super(id, createdDate, updatedDate, hotelName, address, phoneNumber, email, roomNumber, roomType, pricePerNight);
        if (customerName == null || customerName.isEmpty()) throw new IllegalArgumentException("customerName required");
        if (customerEmail == null || !customerEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) throw new IllegalArgumentException("invalid customerEmail");
        if (contactNumber == null || !contactNumber.matches("\\d{10}")) throw new IllegalArgumentException("contactNumber must be 10 digits");
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.contactNumber = contactNumber;
    }

    public String getCustomerName() { return customerName; }
    public String getCustomerEmail() { return customerEmail; }
    public String getContactNumber() { return contactNumber; }
}

class Booking extends Customer {
    private String bookingDate;
    private String checkInDate;
    private String checkOutDate;

    public Booking(int id, String createdDate, String updatedDate,
                   String hotelName, String address, String phoneNumber, String email,
                   String roomNumber, String roomType, double pricePerNight,
                   String customerName, String customerEmail, String contactNumber,
                   String bookingDate, String checkInDate, String checkOutDate) {
        super(id, createdDate, updatedDate, hotelName, address, phoneNumber, email, roomNumber, roomType, pricePerNight, customerName, customerEmail, contactNumber);
        if (bookingDate == null || bookingDate.isEmpty()) throw new IllegalArgumentException("bookingDate required");
        if (checkInDate == null || checkInDate.isEmpty()) throw new IllegalArgumentException("checkInDate required");
        if (checkOutDate == null || checkOutDate.isEmpty()) throw new IllegalArgumentException("checkOutDate required");
        this.bookingDate = bookingDate;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public String getBookingDate() { return bookingDate; }
    public String getCheckInDate() { return checkInDate; }
    public String getCheckOutDate() { return checkOutDate; }
}

class Service extends Booking {
    private String serviceName;
    private double serviceCost;

    public Service(int id, String createdDate, String updatedDate,
                   String hotelName, String address, String phoneNumber, String email,
                   String roomNumber, String roomType, double pricePerNight,
                   String customerName, String customerEmail, String contactNumber,
                   String bookingDate, String checkInDate, String checkOutDate,
                   String serviceName, double serviceCost) {
        super(id, createdDate, updatedDate, hotelName, address, phoneNumber, email, roomNumber, roomType, pricePerNight, customerName, customerEmail, contactNumber, bookingDate, checkInDate, checkOutDate);
        if (serviceName == null || serviceName.isEmpty()) throw new IllegalArgumentException("serviceName required");
        if (serviceCost <= 0) throw new IllegalArgumentException("serviceCost must be > 0");
        this.serviceName = serviceName;
        this.serviceCost = serviceCost;
    }

    public String getServiceName() { return serviceName; }
    public double getServiceCost() { return serviceCost; }
}

class Payment extends Service {
    private String paymentMethod;
    private String paymentDate;

    public Payment(int id, String createdDate, String updatedDate,
                   String hotelName, String address, String phoneNumber, String email,
                   String roomNumber, String roomType, double pricePerNight,
                   String customerName, String customerEmail, String contactNumber,
                   String bookingDate, String checkInDate, String checkOutDate,
                   String serviceName, double serviceCost,
                   String paymentMethod, String paymentDate) {
        super(id, createdDate, updatedDate, hotelName, address, phoneNumber, email, roomNumber, roomType, pricePerNight, customerName, customerEmail, contactNumber, bookingDate, checkInDate, checkOutDate, serviceName, serviceCost);
        if (paymentMethod == null || paymentMethod.isEmpty()) throw new IllegalArgumentException("paymentMethod required");
        if (paymentDate == null || paymentDate.isEmpty()) throw new IllegalArgumentException("paymentDate required");
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() { return paymentMethod; }
    public String getPaymentDate() { return paymentDate; }
}

class Bill extends Payment {
    private double roomCharge;
    private double serviceCharge;
    private double totalBill;

    public Bill(int id, String createdDate, String updatedDate,
                String hotelName, String address, String phoneNumber, String email,
                String roomNumber, String roomType, double pricePerNight,
                String customerName, String customerEmail, String contactNumber,
                String bookingDate, String checkInDate, String checkOutDate,
                String serviceName, double serviceCost,
                String paymentMethod, String paymentDate,
                double roomCharge, double serviceCharge) {
        super(id, createdDate, updatedDate, hotelName, address, phoneNumber, email, roomNumber, roomType, pricePerNight, customerName, customerEmail, contactNumber, bookingDate, checkInDate, checkOutDate, serviceName, serviceCost, paymentMethod, paymentDate);
        if (roomCharge <= 0 || serviceCharge < 0) throw new IllegalArgumentException("roomCharge must be >0; serviceCharge >=0");
        this.roomCharge = roomCharge;
        this.serviceCharge = serviceCharge;
        this.totalBill = roomCharge + serviceCharge;
    }

    public double getRoomCharge() { return roomCharge; }
    public double getServiceCharge() { return serviceCharge; }
    public double getTotalBill() { return totalBill; }
}

class Feedback extends Bill {
    private int rating;
    private String comments;

    public Feedback(int id, String createdDate, String updatedDate,
                    String hotelName, String address, String phoneNumber, String email,
                    String roomNumber, String roomType, double pricePerNight,
                    String customerName, String customerEmail, String contactNumber,
                    String bookingDate, String checkInDate, String checkOutDate,
                    String serviceName, double serviceCost,
                    String paymentMethod, String paymentDate,
                    double roomCharge, double serviceCharge,
                    int rating, String comments) {
        super(id, createdDate, updatedDate, hotelName, address, phoneNumber, email, roomNumber, roomType, pricePerNight, customerName, customerEmail, contactNumber, bookingDate, checkInDate, checkOutDate, serviceName, serviceCost, paymentMethod, paymentDate, roomCharge, serviceCharge);
        if (rating < 1 || rating > 5) throw new IllegalArgumentException("rating must be between 1 and 5");
        if (comments == null) comments = "";
        this.rating = rating;
        this.comments = comments;
    }

    public int getRating() { return rating; }
    public String getComments() { return comments; }
}

final class ReservationRecord extends Feedback {

    public ReservationRecord(int id, String createdDate, String updatedDate,
                             String hotelName, String address, String phoneNumber, String email,
                             String roomNumber, String roomType, double pricePerNight,
                             String customerName, String customerEmail, String contactNumber,
                             String bookingDate, String checkInDate, String checkOutDate,
                             String serviceName, double serviceCost,
                             String paymentMethod, String paymentDate,
                             double roomCharge, double serviceCharge,
                             int rating, String comments) {
        super(id, createdDate, updatedDate, hotelName, address, phoneNumber, email, roomNumber, roomType, pricePerNight, customerName, customerEmail, contactNumber, bookingDate, checkInDate, checkOutDate, serviceName, serviceCost, paymentMethod, paymentDate, roomCharge, serviceCharge, rating, comments);
    }

    public double generateBill() {
        return getRoomCharge() + getServiceCharge();
    }

    // Scanner-based main that validates input and prints the bill
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Hotel Reservation Input ===");

        int id;
        do {
            System.out.print("ID (>0): ");
            id = sc.nextInt();
        } while (id <= 0);

        sc.nextLine();
        System.out.print("Hotel Name: ");
        String hotelName = sc.nextLine();

        System.out.print("Hotel Address: ");
        String address = sc.nextLine();

        String phone;
        do {
            System.out.print("Hotel Phone (10 digits): ");
            phone = sc.next();
        } while (!phone.matches("\\d{10}"));

        String email;
        do {
            System.out.print("Hotel Email: ");
            email = sc.next();
        } while (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$"));

        sc.nextLine();
        System.out.print("Room Number: ");
        String roomNumber = sc.nextLine();

        System.out.print("Room Type: ");
        String roomType = sc.nextLine();

        double pricePerNight;
        do {
            System.out.print("Price per Night (>0): ");
            pricePerNight = sc.nextDouble();
        } while (pricePerNight <= 0);

        sc.nextLine();
        System.out.print("Customer Name: ");
        String customerName = sc.nextLine();

        String customerEmail;
        do {
            System.out.print("Customer Email: ");
            customerEmail = sc.next();
        } while (!customerEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$"));

        String contact;
        do {
            System.out.print("Customer Contact (10 digits): ");
            contact = sc.next();
        } while (!contact.matches("\\d{10}"));

        sc.nextLine();
        System.out.print("Booking Date (YYYY-MM-DD): ");
        String bookingDate = sc.nextLine();

        System.out.print("Check-in Date (YYYY-MM-DD): ");
        String checkInDate = sc.nextLine();

        System.out.print("Check-out Date (YYYY-MM-DD): ");
        String checkOutDate = sc.nextLine();

        sc.nextLine();
        System.out.print("Service Name (or \"none\"): ");
        String serviceName = sc.nextLine();
        double serviceCost = 0;
        if (!serviceName.equalsIgnoreCase("none")) {
            do {
                System.out.print("Service Cost (>0): ");
                serviceCost = sc.nextDouble();
            } while (serviceCost <= 0);
        }

        System.out.print("Payment Method: ");
        sc.nextLine();
        String paymentMethod = sc.nextLine();

        System.out.print("Payment Date (YYYY-MM-DD): ");
        String paymentDate = sc.nextLine();

        System.out.print("Number of nights: ");
        int nights = sc.nextInt();
        if (nights < 1) nights = 1;

        double roomCharge = pricePerNight * nights;
        double serviceCharge = serviceCost;

        sc.nextLine();
        int rating;
        do {
            System.out.print("Rating (1-5): ");
            rating = sc.nextInt();
        } while (rating < 1 || rating > 5);

        sc.nextLine();
        System.out.print("Comments (optional): ");
        String comments = sc.nextLine();

        ReservationRecord rr = new ReservationRecord(
                id, LocalDate.now().toString(), LocalDate.now().toString(),
                hotelName, address, phone, email,
                roomNumber, roomType, pricePerNight,
                customerName, customerEmail, contact,
                bookingDate, checkInDate, checkOutDate,
                serviceName, serviceCost,
                paymentMethod, paymentDate,
                roomCharge, serviceCharge,
                rating, comments
        );

        System.out.printf("Room Charge: %.2f\n", rr.getRoomCharge());
        System.out.printf("Service Charge: %.2f\n", rr.getServiceCharge());
        System.out.printf("Total Bill: %.2f\n", rr.generateBill());
        System.out.printf("Rating: %d, Comments: %s\n", rr.getRating(), rr.getComments());
        sc.close();
    }
}
