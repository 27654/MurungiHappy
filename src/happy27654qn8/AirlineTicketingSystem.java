package happy27654qn8;
import java.util.*;
import java.util.regex.Pattern;

//  Base Entity class
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

// Airline class
class Airline extends Entity {
    private String airlineName;
    private String address;
    private String contactEmail;

    public Airline(int id, Date createdDate, Date updatedDate, String airlineName, String address, String contactEmail) {
        super(id, createdDate, updatedDate);
        if (!Pattern.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$", contactEmail))
            throw new IllegalArgumentException("Invalid email");
        this.airlineName = airlineName;
        this.address = address;
        this.contactEmail = contactEmail;
    }

    public String getAirlineName() { return airlineName; }
}

// Flight class
class Flight extends Entity {
    private String flightNumber;
    private String destination;
    private Date departureTime;

    public Flight(int id, Date createdDate, Date updatedDate, String flightNumber, String destination, Date departureTime) {
        super(id, createdDate, updatedDate);
        if (flightNumber.isEmpty() || destination.isEmpty() || departureTime == null)
            throw new IllegalArgumentException("Flight info cannot be empty");
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    public String getFlightNumber() { return flightNumber; }
    public String getDestination() { return destination; }
}

// Passenger class
class Passenger extends Entity {
    private String passengerName;
    private String passportNumber;
    private String nationality;

    public Passenger(int id, Date createdDate, Date updatedDate, String passengerName, String passportNumber, String nationality) {
        super(id, createdDate, updatedDate);
        if (passportNumber.isEmpty()) throw new IllegalArgumentException("Passport number cannot be empty");
        this.passengerName = passengerName;
        this.passportNumber = passportNumber;
        this.nationality = nationality;
    }

    public String getPassengerName() { return passengerName; }
}

// Seat class
class Seat extends Entity {
    private String seatNumber;
    private String seatType; // Economy/Business

    public Seat(int id, Date createdDate, Date updatedDate, String seatNumber, String seatType) {
        super(id, createdDate, updatedDate);
        if (!seatType.equalsIgnoreCase("Economy") && !seatType.equalsIgnoreCase("Business"))
            throw new IllegalArgumentException("Seat type must be Economy or Business");
        this.seatNumber = seatNumber;
        this.seatType = seatType;
    }

    public String getSeatNumber() { return seatNumber; }
    public String getSeatType() { return seatType; }
}

// Ticket class
class Ticket extends Entity {
    private String ticketNumber;
    private double price;

    public Ticket(int id, Date createdDate, Date updatedDate, String ticketNumber, double price) {
        super(id, createdDate, updatedDate);
        if (price <= 0) throw new IllegalArgumentException("Price must be greater than 0");
        this.ticketNumber = ticketNumber;
        this.price = price;
    }

    public double getPrice() { return price; }
    public String getTicketNumber() { return ticketNumber; }
}

// Baggage class
class Baggage extends Entity {
    private double baggageWeight;
    private double baggageFee;

    public Baggage(int id, Date createdDate, Date updatedDate, double baggageWeight, double baggageFee) {
        super(id, createdDate, updatedDate);
        if (baggageWeight < 0 || baggageFee < 0) throw new IllegalArgumentException("Baggage values cannot be negative");
        this.baggageWeight = baggageWeight;
        this.baggageFee = baggageFee;
    }

    public double getBaggageFee() { return baggageFee; }
}

// Payment class
class Payment extends Entity {
    private Date paymentDate;
    private String paymentMode;

    public Payment(int id, Date createdDate, Date updatedDate, Date paymentDate, String paymentMode) {
        super(id, createdDate, updatedDate);
        if (paymentDate == null || paymentMode.isEmpty())
            throw new IllegalArgumentException("Payment info cannot be empty");
        this.paymentDate = paymentDate;
        this.paymentMode = paymentMode;
    }

    public String getPaymentMode() { return paymentMode; }
}

//  Invoice class
class Invoice extends Entity {
    private double totalFare;

    public Invoice(int id, Date createdDate, Date updatedDate, double totalFare) {
        super(id, createdDate, updatedDate);
        if (totalFare <= 0) throw new IllegalArgumentException("Total fare must be greater than 0");
        this.totalFare = totalFare;
    }

    public double getTotalFare() { return totalFare; }
}

// Final TicketRecord class
final class TicketRecord extends Invoice {
    private Ticket ticket;
    private Baggage baggage;

    public TicketRecord(int id, Date createdDate, Date updatedDate, double totalFare, Ticket ticket, Baggage baggage) {
        super(id, createdDate, updatedDate, totalFare);
        this.ticket = ticket;
        this.baggage = baggage;
    }

    // generateInvoice = price + baggageFee
    public double generateInvoice() {
        return ticket.getPrice() + baggage.getBaggageFee();
    }
}

// Main class
public class AirlineTicketingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<TicketRecord> ticketRecords = new ArrayList<>();

        try {
            // Airline input
            System.out.print("Enter airline name: ");
            String airlineName = sc.nextLine();
            System.out.print("Enter address: ");
            String address = sc.nextLine();
            System.out.print("Enter contact email: ");
            String email = sc.nextLine();
            Airline airline = new Airline(1, new Date(), new Date(), airlineName, address, email);

            // Flight input
            System.out.print("Enter flight number: ");
            String flightNumber = sc.nextLine();
            System.out.print("Enter destination: ");
            String destination = sc.nextLine();
            Flight flight = new Flight(2, new Date(), new Date(), flightNumber, destination, new Date());

            // Number of passengers
            System.out.print("Enter number of passengers: ");
            int numPassengers = sc.nextInt();
            sc.nextLine(); // consume newline

            for (int i = 1; i <= numPassengers; i++) {
                System.out.println("\n--- Passenger " + i + " ---");

                // Passenger input
                System.out.print("Enter passenger name: ");
                String passengerName = sc.nextLine();
                System.out.print("Enter passport number: ");
                String passport = sc.nextLine();
                System.out.print("Enter nationality: ");
                String nationality = sc.nextLine();
                Passenger passenger = new Passenger(i + 2, new Date(), new Date(), passengerName, passport, nationality);

                // Seat input
                System.out.print("Enter seat number: ");
                String seatNumber = sc.nextLine();
                System.out.print("Enter seat type (Economy/Business): ");
                String seatType = sc.nextLine();
                Seat seat = new Seat(i + 2, new Date(), new Date(), seatNumber, seatType);

                // Ticket input
                System.out.print("Enter ticket number: ");
                String ticketNumber = sc.nextLine();
                System.out.print("Enter ticket price: ");
                double price = sc.nextDouble();

                Ticket ticket = new Ticket(i + 2, new Date(), new Date(), ticketNumber, price);

                // Baggage input
                System.out.print("Enter baggage weight: ");
                double weight = sc.nextDouble();
                System.out.print("Enter baggage fee: ");
                double fee = sc.nextDouble();
                sc.nextLine(); // consume newline
                Baggage baggage = new Baggage(i + 2, new Date(), new Date(), weight, fee);

                // Payment input
                System.out.print("Enter payment mode: ");
                String paymentMode = sc.nextLine();
                Payment payment = new Payment(i + 2, new Date(), new Date(), new Date(), paymentMode);

                // TicketRecord
                TicketRecord record = new TicketRecord(i + 2, new Date(), new Date(), price + fee, ticket, baggage);
                ticketRecords.add(record);

                System.out.println("Passenger " + passengerName + " ticket recorded.\n");
            }

            // Print summary
            System.out.println("\n===== All Passengers Ticket Summary =====");
            for (int i = 0; i < ticketRecords.size(); i++) {
                TicketRecord tr = ticketRecords.get(i);
                System.out.println("Passenger " + (i + 1) + " Total Invoice: $" + tr.generateInvoice());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
