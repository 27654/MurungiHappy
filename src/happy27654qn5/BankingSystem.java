package happy27654qn5;

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

// Bank
class Bank extends Entity {
    private String bankName;
    private String branchCode;
    private String address;

    public Bank(int id, String createdDate, String updatedDate, String bankName, String branchCode, String address) {
        super(id, createdDate, updatedDate);
        if (bankName == null || bankName.isEmpty()) throw new IllegalArgumentException("bankName required");
        if (branchCode == null || branchCode.length() < 3) throw new IllegalArgumentException("branchCode ≥3 chars required");
        if (address == null || address.isEmpty()) throw new IllegalArgumentException("address required");
        this.bankName = bankName;
        this.branchCode = branchCode;
        this.address = address;
    }

    public String getBankName() { return bankName; }
    public String getBranchCode() { return branchCode; }
    public String getAddress() { return address; }
}

// Account
class Account extends Bank {
    private String accountNumber;
    private String accountType;
    private double balance;

    public Account(int id, String createdDate, String updatedDate, String bankName, String branchCode, String address,
                   String accountNumber, String accountType, double balance) {
        super(id, createdDate, updatedDate, bankName, branchCode, address);
        if (accountNumber == null || accountNumber.isEmpty()) throw new IllegalArgumentException("accountNumber required");
        if (accountType == null || accountType.isEmpty()) throw new IllegalArgumentException("accountType required");
        if (balance < 0) throw new IllegalArgumentException("balance must be ≥0");
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getAccountType() { return accountType; }
    public double getBalance() { return balance; }
}

// Customer
class Customer extends Account {
    private String customerName;
    private String email;
    private String phoneNumber;

    public Customer(int id, String createdDate, String updatedDate, String bankName, String branchCode, String address,
                    String accountNumber, String accountType, double balance,
                    String customerName, String email, String phoneNumber) {
        super(id, createdDate, updatedDate, bankName, branchCode, address, accountNumber, accountType, balance);
        if (customerName == null || customerName.isEmpty()) throw new IllegalArgumentException("customerName required");
        if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) throw new IllegalArgumentException("Invalid email");
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) throw new IllegalArgumentException("Phone must be 10 digits");
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerName() { return customerName; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
}

// Transaction
class Transaction extends Customer {
    private String transactionId;
    private String transactionType;
    private double amount;

    public Transaction(int id, String createdDate, String updatedDate, String bankName, String branchCode, String address,
                       String accountNumber, String accountType, double balance,
                       String customerName, String email, String phoneNumber,
                       String transactionId, String transactionType, double amount) {
        super(id, createdDate, updatedDate, bankName, branchCode, address, accountNumber, accountType, balance, customerName, email, phoneNumber);
        if (transactionId == null || transactionId.isEmpty()) throw new IllegalArgumentException("transactionId required");
        if (transactionType == null || transactionType.isEmpty()) throw new IllegalArgumentException("transactionType required");
        if (amount <= 0) throw new IllegalArgumentException("amount must be >0");
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public String getTransactionId() { return transactionId; }
    public String getTransactionType() { return transactionType; }
    public double getAmount() { return amount; }
}

// Deposit
class Deposit extends Transaction {
    private double depositAmount;
    private String depositDate;

    public Deposit(int id, String createdDate, String updatedDate, String bankName, String branchCode, String address,
                   String accountNumber, String accountType, double balance,
                   String customerName, String email, String phoneNumber,
                   String transactionId, String transactionType, double amount,
                   double depositAmount, String depositDate) {
        super(id, createdDate, updatedDate, bankName, branchCode, address, accountNumber, accountType, balance,
                customerName, email, phoneNumber, transactionId, transactionType, amount);
        if (depositAmount <= 0) throw new IllegalArgumentException("depositAmount must be >0");
        if (depositDate == null || depositDate.isEmpty()) throw new IllegalArgumentException("depositDate required");
        this.depositAmount = depositAmount;
        this.depositDate = depositDate;
    }

    public double getDepositAmount() { return depositAmount; }
    public String getDepositDate() { return depositDate; }
}

//  Withdrawal
class Withdrawal extends Deposit {
    private double withdrawalAmount;
    private String withdrawalDate;

    public Withdrawal(int id, String createdDate, String updatedDate, String bankName, String branchCode, String address,
                      String accountNumber, String accountType, double balance,
                      String customerName, String email, String phoneNumber,
                      String transactionId, String transactionType, double amount,
                      double depositAmount, String depositDate,
                      double withdrawalAmount, String withdrawalDate) {
        super(id, createdDate, updatedDate, bankName, branchCode, address, accountNumber, accountType, balance,
                customerName, email, phoneNumber, transactionId, transactionType, amount, depositAmount, depositDate);
        if (withdrawalAmount <= 0) throw new IllegalArgumentException("withdrawalAmount must be >0");
        if (withdrawalDate == null || withdrawalDate.isEmpty()) throw new IllegalArgumentException("withdrawalDate required");
        this.withdrawalAmount = withdrawalAmount;
        this.withdrawalDate = withdrawalDate;
    }

    public double getWithdrawalAmount() { return withdrawalAmount; }
    public String getWithdrawalDate() { return withdrawalDate; }
}

// Loan
class Loan extends Withdrawal {
    private double loanAmount;
    private double interestRate;
    private int duration; // in years

    public Loan(int id, String createdDate, String updatedDate, String bankName, String branchCode, String address,
                String accountNumber, String accountType, double balance,
                String customerName, String email, String phoneNumber,
                String transactionId, String transactionType, double amount,
                double depositAmount, String depositDate,
                double withdrawalAmount, String withdrawalDate,
                double loanAmount, double interestRate, int duration) {
        super(id, createdDate, updatedDate, bankName, branchCode, address, accountNumber, accountType, balance,
                customerName, email, phoneNumber, transactionId, transactionType, amount, depositAmount, depositDate,
                withdrawalAmount, withdrawalDate);
        if (loanAmount <=0 || interestRate <=0 || duration <=0) throw new IllegalArgumentException("Loan, interest, duration must be >0");
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.duration = duration;
    }

    public double getLoanAmount() { return loanAmount; }
    public double getInterestRate() { return interestRate; }
    public int getDuration() { return duration; }
}

// Payment
class Payment extends Loan {
    private double paymentAmount;
    private String paymentDate;

    public Payment(int id, String createdDate, String updatedDate, String bankName, String branchCode, String address,
                   String accountNumber, String accountType, double balance,
                   String customerName, String email, String phoneNumber,
                   String transactionId, String transactionType, double amount,
                   double depositAmount, String depositDate,
                   double withdrawalAmount, String withdrawalDate,
                   double loanAmount, double interestRate, int duration,
                   double paymentAmount, String paymentDate) {
        super(id, createdDate, updatedDate, bankName, branchCode, address, accountNumber, accountType, balance,
                customerName, email, phoneNumber, transactionId, transactionType, amount, depositAmount, depositDate,
                withdrawalAmount, withdrawalDate, loanAmount, interestRate, duration);
        if (paymentAmount <=0) throw new IllegalArgumentException("paymentAmount must be >0");
        if (paymentDate == null || paymentDate.isEmpty()) throw new IllegalArgumentException("paymentDate required");
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
    }

    public double getPaymentAmount() { return paymentAmount; }
    public String getPaymentDate() { return paymentDate; }
}

//  AccountRecord
final class AccountRecord extends Payment {

    public AccountRecord(int id, String createdDate, String updatedDate, String bankName, String branchCode, String address,
                         String accountNumber, String accountType, double balance,
                         String customerName, String email, String phoneNumber,
                         String transactionId, String transactionType, double amount,
                         double depositAmount, String depositDate,
                         double withdrawalAmount, String withdrawalDate,
                         double loanAmount, double interestRate, int duration,
                         double paymentAmount, String paymentDate) {
        super(id, createdDate, updatedDate, bankName, branchCode, address, accountNumber, accountType, balance,
                customerName, email, phoneNumber, transactionId, transactionType, amount,
                depositAmount, depositDate, withdrawalAmount, withdrawalDate,
                loanAmount, interestRate, duration, paymentAmount, paymentDate);
    }

    public double calculateInterest() {
        return getLoanAmount() * getInterestRate() * getDuration() / 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Banking System ===");

        int id;
        do { System.out.print("ID (>0): "); id = sc.nextInt(); } while(id <=0);

        sc.nextLine();
        System.out.print("Bank Name: "); String bankName = sc.nextLine();
        String branchCode;
        do { System.out.print("Branch Code (≥3 chars): "); branchCode = sc.nextLine(); } while(branchCode.length()<3);
        System.out.print("Bank Address: "); String address = sc.nextLine();

        System.out.print("Account Number: "); String accountNumber = sc.nextLine();
        System.out.print("Account Type: "); String accountType = sc.nextLine();
        double balance;
        do { System.out.print("Balance (≥0): "); balance = sc.nextDouble(); } while(balance<0);

        sc.nextLine();
        System.out.print("Customer Name: "); String customerName = sc.nextLine();
        String email;
        do { System.out.print("Customer Email: "); email = sc.nextLine(); } while(!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$"));
        String phoneNumber;
        do { System.out.print("Phone Number (10 digits): "); phoneNumber = sc.next(); } while(!phoneNumber.matches("\\d{10}"));

        sc.nextLine();
        System.out.print("Transaction ID: "); String transactionId = sc.nextLine();
        System.out.print("Transaction Type: "); String transactionType = sc.nextLine();
        double amount;
        do { System.out.print("Amount (>0): "); amount = sc.nextDouble(); } while(amount<=0);

        double depositAmount;
        do { System.out.print("Deposit Amount (>0): "); depositAmount = sc.nextDouble(); } while(depositAmount<=0);
        sc.nextLine();
        System.out.print("Deposit Date: "); String depositDate = sc.nextLine();

        double withdrawalAmount;
        do { System.out.print("Withdrawal Amount (>0): "); withdrawalAmount = sc.nextDouble(); } while(withdrawalAmount<=0);
        sc.nextLine();
        System.out.print("Withdrawal Date: "); String withdrawalDate = sc.nextLine();

        double loanAmount;
        do { System.out.print("Loan Amount (>0): "); loanAmount = sc.nextDouble(); } while(loanAmount<=0);
        double interestRate;
        do { System.out.print("Interest Rate (>0): "); interestRate = sc.nextDouble(); } while(interestRate<=0);
        int duration;
        do { System.out.print("Duration (years, >0): "); duration = sc.nextInt(); } while(duration<=0);

        double paymentAmount;
        do { System.out.print("Payment Amount (>0): "); paymentAmount = sc.nextDouble(); } while(paymentAmount<=0);
        sc.nextLine();
        System.out.print("Payment Date: "); String paymentDate = sc.nextLine();

        AccountRecord record = new AccountRecord(id, LocalDate.now().toString(), LocalDate.now().toString(),
                bankName, branchCode, address,
                accountNumber, accountType, balance,
                customerName, email, phoneNumber,
                transactionId, transactionType, amount,
                depositAmount, depositDate,
                withdrawalAmount, withdrawalDate,
                loanAmount, interestRate, duration,
                paymentAmount, paymentDate
        );

        System.out.printf("Interest to be paid = %.2f\n", record.calculateInterest());
        sc.close();
    }
}
