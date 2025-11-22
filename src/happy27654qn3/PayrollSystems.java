package happy27654qn3;

import java.util.Scanner;
import java.time.LocalDate;

class Entity {
    private int id;
    private String createdDate;
    private String updatedDate;

    public Entity(int id, String createdDate, String updatedDate) {
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

class Company extends Entity {
    private String companyName;
    private String address;
    private String phoneNumber;
    private String email;

    public Company(int id, String createdDate, String updatedDate,
                   String companyName, String address, String phoneNumber, String email) {
        super(id, createdDate, updatedDate);
        if (companyName == null || companyName.isEmpty()) throw new IllegalArgumentException("companyName required");
        if (address == null || address.isEmpty()) throw new IllegalArgumentException("address required");
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) throw new IllegalArgumentException("phone must be 10 digits");
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) throw new IllegalArgumentException("invalid email");
        this.companyName = companyName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getCompanyName() { return companyName; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
}

class Department extends Company {
    private String departmentName;
    private String departmentCode;

    public Department(int id, String createdDate, String updatedDate,
                      String companyName, String address, String phoneNumber, String email,
                      String departmentName, String departmentCode) {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email);
        if (departmentName == null || departmentName.isEmpty()) throw new IllegalArgumentException("departmentName required");
        if (departmentCode == null || !departmentCode.matches("[A-Za-z0-9]{3,}")) throw new IllegalArgumentException("departmentCode must be alphanumeric and ≥3 chars");
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() { return departmentName; }
    public String getDepartmentCode() { return departmentCode; }
}

class Manager extends Department {
    private String managerName;
    private String managerEmail;
    private String phone;

    public Manager(int id, String createdDate, String updatedDate,
                   String companyName, String address, String phoneNumber, String email,
                   String departmentName, String departmentCode,
                   String managerName, String managerEmail, String phone) {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email, departmentName, departmentCode);
        if (managerName == null || managerName.isEmpty()) throw new IllegalArgumentException("managerName required");
        if (managerEmail == null || !managerEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) throw new IllegalArgumentException("invalid managerEmail");
        if (phone == null || !phone.matches("\\d{10}")) throw new IllegalArgumentException("manager phone must be 10 digits");
        this.managerName = managerName;
        this.managerEmail = managerEmail;
        this.phone = phone;
    }

    public String getManagerName() { return managerName; }
    public String getManagerEmail() { return managerEmail; }
    public String getPhone() { return phone; }
}

class Employee extends Manager {
    private String employeeName;
    private int employeeId;
    private String designation;
    private String contactNumber;

    public Employee(int id, String createdDate, String updatedDate,
                    String companyName, String address, String phoneNumber, String email,
                    String departmentName, String departmentCode,
                    String managerName, String managerEmail, String phone,
                    String employeeName, int employeeId, String designation, String contactNumber) {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email, departmentName, departmentCode, managerName, managerEmail, phone);
        if (employeeName == null || employeeName.isEmpty()) throw new IllegalArgumentException("employeeName required");
        if (employeeId <= 0) throw new IllegalArgumentException("employeeId must be > 0");
        if (designation == null || designation.isEmpty()) throw new IllegalArgumentException("designation required");
        if (contactNumber == null || !contactNumber.matches("\\d{10}")) throw new IllegalArgumentException("contactNumber must be 10 digits");
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.designation = designation;
        this.contactNumber = contactNumber;
    }

    public String getEmployeeName() { return employeeName; }
    public int getEmployeeId() { return employeeId; }
    public String getDesignation() { return designation; }
    public String getContactNumber() { return contactNumber; }
}

class Attendance extends Employee {
    private int totalDays;
    private int presentDays;
    private int leaveDays;

    public Attendance(int id, String createdDate, String updatedDate,
                      String companyName, String address, String phoneNumber, String email,
                      String departmentName, String departmentCode,
                      String managerName, String managerEmail, String phone,
                      String employeeName, int employeeId, String designation, String contactNumber,
                      int totalDays, int presentDays, int leaveDays) {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email,
                departmentName, departmentCode, managerName, managerEmail, phone,
                employeeName, employeeId, designation, contactNumber);
        if (totalDays < 0 || presentDays < 0 || leaveDays < 0) throw new IllegalArgumentException("days must be >= 0");
        if (presentDays > totalDays) throw new IllegalArgumentException("presentDays cannot exceed totalDays");
        this.totalDays = totalDays;
        this.presentDays = presentDays;
        this.leaveDays = leaveDays;
    }

    public int getTotalDays() { return totalDays; }
    public int getPresentDays() { return presentDays; }
    public int getLeaveDays() { return leaveDays; }
}

class Allowance extends Attendance {
    private double housingAllowance;
    private double transportAllowance;

    public Allowance(int id, String createdDate, String updatedDate,
                     String companyName, String address, String phoneNumber, String email,
                     String departmentName, String departmentCode,
                     String managerName, String managerEmail, String phone,
                     String employeeName, int employeeId, String designation, String contactNumber,
                     int totalDays, int presentDays, int leaveDays,
                     double housingAllowance, double transportAllowance) {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email,
                departmentName, departmentCode, managerName, managerEmail, phone,
                employeeName, employeeId, designation, contactNumber,
                totalDays, presentDays, leaveDays);
        if (housingAllowance < 0 || transportAllowance < 0) throw new IllegalArgumentException("allowances must be >= 0");
        this.housingAllowance = housingAllowance;
        this.transportAllowance = transportAllowance;
    }

    public double getHousingAllowance() { return housingAllowance; }
    public double getTransportAllowance() { return transportAllowance; }
}

class Deduction extends Allowance {
    private double taxDeduction;
    private double loanDeduction;

    public Deduction(int id, String createdDate, String updatedDate,
                     String companyName, String address, String phoneNumber, String email,
                     String departmentName, String departmentCode,
                     String managerName, String managerEmail, String phone,
                     String employeeName, int employeeId, String designation, String contactNumber,
                     int totalDays, int presentDays, int leaveDays,
                     double housingAllowance, double transportAllowance,
                     double taxDeduction, double loanDeduction) {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email,
                departmentName, departmentCode, managerName, managerEmail, phone,
                employeeName, employeeId, designation, contactNumber,
                totalDays, presentDays, leaveDays,
                housingAllowance, transportAllowance);
        if (taxDeduction < 0 || loanDeduction < 0) throw new IllegalArgumentException("deductions must be >= 0");
        this.taxDeduction = taxDeduction;
        this.loanDeduction = loanDeduction;
    }

    public double getTaxDeduction() { return taxDeduction; }
    public double getLoanDeduction() { return loanDeduction; }
}

class Salary extends Deduction {
    private double basicSalary;
    private double grossSalary;
    private double netSalary;

    public Salary(int id, String createdDate, String updatedDate,
                  String companyName, String address, String phoneNumber, String email,
                  String departmentName, String departmentCode,
                  String managerName, String managerEmail, String phone,
                  String employeeName, int employeeId, String designation, String contactNumber,
                  int totalDays, int presentDays, int leaveDays,
                  double housingAllowance, double transportAllowance,
                  double taxDeduction, double loanDeduction,
                  double basicSalary) {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email,
                departmentName, departmentCode, managerName, managerEmail, phone,
                employeeName, employeeId, designation, contactNumber,
                totalDays, presentDays, leaveDays,
                housingAllowance, transportAllowance,
                taxDeduction, loanDeduction);
        if (basicSalary <= 0) throw new IllegalArgumentException("basicSalary must be > 0");
        this.basicSalary = basicSalary;
        // compute gross/net placeholders; final calculation happens in PayrollRecord
        this.grossSalary = basicSalary + getHousingAllowance() + getTransportAllowance();
        this.netSalary = grossSalary - (getTaxDeduction() + getLoanDeduction());
    }

    public double getBasicSalary() { return basicSalary; }
    public double getGrossSalary() { return grossSalary; }
    public double getNetSalary() { return netSalary; }
}

final class PayrollRecord extends Salary {

    public PayrollRecord(int id, String createdDate, String updatedDate,
                         String companyName, String address, String phoneNumber, String email,
                         String departmentName, String departmentCode,
                         String managerName, String managerEmail, String phone,
                         String employeeName, int employeeId, String designation, String contactNumber,
                         int totalDays, int presentDays, int leaveDays,
                         double housingAllowance, double transportAllowance,
                         double taxDeduction, double loanDeduction,
                         double basicSalary) {
        super(id, createdDate, updatedDate, companyName, address, phoneNumber, email,
                departmentName, departmentCode, managerName, managerEmail, phone,
                employeeName, employeeId, designation, contactNumber,
                totalDays, presentDays, leaveDays,
                housingAllowance, transportAllowance,
                taxDeduction, loanDeduction,
                basicSalary);
    }

    public double calculateNetSalary() {
        double allowances = getHousingAllowance() + getTransportAllowance();
        double deductions = getTaxDeduction() + getLoanDeduction();
        double gross = getBasicSalary() + allowances;
        double net = gross - deductions;
        return net;
    }

    // Scanner-based main that validates input and prints payroll
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Payroll Record Input ===");

        // Basic validated inputs
        int id;
        do {
            System.out.print("ID (>0): ");
            id = sc.nextInt();
        } while (id <= 0);

        sc.nextLine(); // consume newline
        System.out.print("Company Name: ");
        String companyName = sc.nextLine();
        System.out.print("Company Address: ");
        String address = sc.nextLine();

        String phone;
        do {
            System.out.print("Company Phone (10 digits): ");
            phone = sc.next();
        } while (!phone.matches("\\d{10}"));

        String email;
        do {
            System.out.print("Company Email: ");
            email = sc.next();
        } while (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$"));

        sc.nextLine(); // consume
        System.out.print("Department Name: ");
        String deptName = sc.nextLine();

        String deptCode;
        do {
            System.out.print("Department Code (alphanumeric ≥3): ");
            deptCode = sc.next();
        } while (!deptCode.matches("[A-Za-z0-9]{3,}"));

        sc.nextLine();
        System.out.print("Manager Name: ");
        String managerName = sc.nextLine();

        String managerEmail;
        do {
            System.out.print("Manager Email: ");
            managerEmail = sc.next();
        } while (!managerEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$"));

        String managerPhone;
        do {
            System.out.print("Manager Phone (10 digits): ");
            managerPhone = sc.next();
        } while (!managerPhone.matches("\\d{10}"));

        sc.nextLine();
        System.out.print("Employee Name: ");
        String empName = sc.nextLine();

        int empId;
        do {
            System.out.print("Employee ID (>0): ");
            empId = sc.nextInt();
        } while (empId <= 0);

        sc.nextLine();
        System.out.print("Designation: ");
        String designation = sc.nextLine();

        String contact;
        do {
            System.out.print("Employee Contact (10 digits): ");
            contact = sc.next();
        } while (!contact.matches("\\d{10}"));

        int totalDays;
        do {
            System.out.print("Total Days (>=0): ");
            totalDays = sc.nextInt();
        } while (totalDays < 0);

        int presentDays;
        do {
            System.out.print("Present Days (>=0 and <= totalDays): ");
            presentDays = sc.nextInt();
        } while (presentDays < 0 || presentDays > totalDays);

        int leaveDays;
        do {
            System.out.print("Leave Days (>=0): ");
            leaveDays = sc.nextInt();
        } while (leaveDays < 0);

        double housingAllowance;
        do {
            System.out.print("Housing Allowance (>=0): ");
            housingAllowance = sc.nextDouble();
        } while (housingAllowance < 0);

        double transportAllowance;
        do {
            System.out.print("Transport Allowance (>=0): ");
            transportAllowance = sc.nextDouble();
        } while (transportAllowance < 0);

        double taxDeduction;
        do {
            System.out.print("Tax Deduction (>=0): ");
            taxDeduction = sc.nextDouble();
        } while (taxDeduction < 0);

        double loanDeduction;
        do {
            System.out.print("Loan Deduction (>=0): ");
            loanDeduction = sc.nextDouble();
        } while (loanDeduction < 0);

        double basicSalary;
        do {
            System.out.print("Basic Salary (>0): ");
            basicSalary = sc.nextDouble();
        } while (basicSalary <= 0);

        PayrollRecord pr = new PayrollRecord(
                id, LocalDate.now().toString(), LocalDate.now().toString(),
                companyName, address, phone, email,
                deptName, deptCode,
                managerName, managerEmail, managerPhone,
                empName, empId, designation, contact,
                totalDays, presentDays, leaveDays,
                housingAllowance, transportAllowance,
                taxDeduction, loanDeduction,
                basicSalary
        );

        double net = pr.calculateNetSalary();
        System.out.printf("Gross Salary: %.2f\n", pr.getBasicSalary() + pr.getHousingAllowance() + pr.getTransportAllowance());
        System.out.printf("Net Salary: %.2f\n", net);
        sc.close();
    }
}
