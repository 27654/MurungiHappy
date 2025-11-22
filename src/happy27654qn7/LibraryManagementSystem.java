package happy27654qn7;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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

//  class
class Library extends Entity {
    private String libraryName;
    private String location;
    private String phoneNumber;

    public Library(int id, Date createdDate, Date updatedDate, String libraryName, String location, String phoneNumber) {
        super(id, createdDate, updatedDate);
        if (!phoneNumber.matches("\\d{9,}")) throw new IllegalArgumentException("Invalid phone number");
        this.libraryName = libraryName;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }

    public String getLibraryName() { return libraryName; }
}

// Section class
class Section extends Entity {
    private String sectionName;
    private String sectionCode;

    public Section(int id, Date createdDate, Date updatedDate, String sectionName, String sectionCode) {
        super(id, createdDate, updatedDate);
        if (sectionCode.length() < 3) throw new IllegalArgumentException("Section code must be at least 3 characters");
        this.sectionName = sectionName;
        this.sectionCode = sectionCode;
    }

    public String getSectionName() { return sectionName; }
}

// Book class
class Book extends Entity {
    private String title;
    private String author;
    private String ISBN;

    public Book(int id, Date createdDate, Date updatedDate, String title, String author, String ISBN) {
        super(id, createdDate, updatedDate);
        if (ISBN.length() < 10) throw new IllegalArgumentException("ISBN must be at least 10 characters");
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
}

// Member class
class Member extends Entity {
    private String memberName;
    private int memberId;
    private String contactNumber;

    public Member(int id, Date createdDate, Date updatedDate, String memberName, int memberId, String contactNumber) {
        super(id, createdDate, updatedDate);
        if (memberId <= 0) throw new IllegalArgumentException("Member ID must be greater than 0");
        this.memberName = memberName;
        this.memberId = memberId;
        this.contactNumber = contactNumber;
    }

    public String getMemberName() { return memberName; }
}

// Borrow class
class Borrow extends Entity {
    private Date borrowDate;
    private Date returnDate;

    public Borrow(int id, Date createdDate, Date updatedDate, Date borrowDate, Date returnDate) {
        super(id, createdDate, updatedDate);
        if (borrowDate == null || returnDate == null) throw new IllegalArgumentException("Borrow and return dates cannot be null");
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public Date getBorrowDate() { return borrowDate; }
    public Date getReturnDate() { return returnDate; }
}

// Fine class
class Fine extends Entity {
    private double fineAmount;
    private int daysLate;

    public Fine(int id, Date createdDate, Date updatedDate, double fineAmount, int daysLate) {
        super(id, createdDate, updatedDate);
        if (fineAmount < 0) throw new IllegalArgumentException("Fine amount cannot be negative");
        this.fineAmount = fineAmount;
        this.daysLate = daysLate;
    }

    public double getFineAmount() { return fineAmount; }
    public int getDaysLate() { return daysLate; }
}

// Payment class
class Payment extends Entity {
    private Date paymentDate;
    private String paymentMode;

    public Payment(int id, Date createdDate, Date updatedDate, Date paymentDate, String paymentMode) {
        super(id, createdDate, updatedDate);
        if (paymentMode.isEmpty() || paymentDate == null) throw new IllegalArgumentException("Payment details cannot be empty");
        this.paymentDate = paymentDate;
        this.paymentMode = paymentMode;
    }

    public String getPaymentMode() { return paymentMode; }
}

// Record class
class Record extends Entity {
    private double totalFine;

    public Record(int id, Date createdDate, Date updatedDate, double totalFine) {
        super(id, createdDate, updatedDate);
        if (totalFine <= 0) throw new IllegalArgumentException("Total fine must be > 0");
        this.totalFine = totalFine;
    }

    public double getTotalFine() { return totalFine; }
}

// Final LibraryRecord class
final class LibraryRecord extends Record {
    private Fine fine;

    public LibraryRecord(int id, Date createdDate, Date updatedDate, double totalFine, Fine fine) {
        super(id, createdDate, updatedDate, totalFine);
        this.fine = fine;
    }

    public double calculateFine() {
        return fine.getFineAmount() * fine.getDaysLate();
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Library input
            System.out.print("Enter library name: ");
            String libName = sc.nextLine();
            System.out.print("Enter library location: ");
            String location = sc.nextLine();
            System.out.print("Enter phone number: ");
            String phone = sc.nextLine();
            Library library = new Library(1, new Date(), new Date(), libName, location, phone);

            // Section input
            System.out.print("Enter section name: ");
            String secName = sc.nextLine();
            System.out.print("Enter section code: ");
            String secCode = sc.nextLine();
            Section section = new Section(2, new Date(), new Date(), secName, secCode);

            // Book input
            System.out.print("Enter book title: ");
            String bookTitle = sc.nextLine();
            System.out.print("Enter author: ");
            String author = sc.nextLine();
            System.out.print("Enter ISBN (>=10 chars): ");
            String isbn = sc.nextLine();
            Book book = new Book(3, new Date(), new Date(), bookTitle, author, isbn);

            // Member input
            System.out.print("Enter member name: ");
            String memName = sc.nextLine();
            System.out.print("Enter member ID (>0): ");
            int memId = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Enter contact number: ");
            String contact = sc.nextLine();
            Member member = new Member(4, new Date(), new Date(), memName, memId, contact);

            // Borrow input
            Date borrowDate = new Date(); // today
            Date returnDate = new Date(System.currentTimeMillis() + (5L * 24 * 60 * 60 * 1000)); // 5 days later
            Borrow borrow = new Borrow(5, new Date(), new Date(), borrowDate, returnDate);

            // Fine input
            System.out.print("Enter fine per day: ");
            double fineAmount = sc.nextDouble();
            System.out.print("Enter days late: ");
            int daysLate = sc.nextInt();
            Fine fine = new Fine(6, new Date(), new Date(), fineAmount, daysLate);

            // Payment input
            sc.nextLine(); // consume newline
            System.out.print("Enter payment mode: ");
            String payMode = sc.nextLine();
            Payment payment = new Payment(7, new Date(), new Date(), new Date(), payMode);

            // LibraryRecord
            LibraryRecord record = new LibraryRecord(8, new Date(), new Date(), fineAmount * daysLate, fine);

            // Display summary
            System.out.println("\n===== Library Record Summary =====");
            System.out.println("Library: " + library.getLibraryName());
            System.out.println("Section: " + section.getSectionName());
            System.out.println("Book: " + book.getTitle() + " by " + book.getAuthor());
            System.out.println("Member: " + member.getMemberName());
            System.out.println("Borrow Date: " + borrow.getBorrowDate());
            System.out.println("Return Date: " + borrow.getReturnDate());
            System.out.println("Fine per Day: $" + fine.getFineAmount());
            System.out.println("Days Late: " + fine.getDaysLate());
            System.out.println("Total Fine: $" + record.calculateFine());
            System.out.println("Payment Mode: " + payment.getPaymentMode());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
