package happy27654qn1;
import java.util.*;

//Custom Exception
class HospitalDataException extends Exception {
    public HospitalDataException(String message) {
        super(message);
    }
}

//Entity Class
class Entity {
    private int id;
    private Date createdDate;
    private Date updatedDate;

    public Entity(int id, Date createdDate, Date updatedDate) throws HospitalDataException {
        if (id <= 0) throw new HospitalDataException("ID must be greater than 0");
        if (createdDate == null || updatedDate == null)
            throw new HospitalDataException("Dates cannot be null");

        this.id = id;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public int getId() { return id; }
}

// Hospital Class
class Hospital extends Entity {
    private String hospitalName;
    private String address;
    private String phoneNumber;
    private String email;

    public Hospital(int id, Date cd, Date ud, String hospitalName,
                    String address, String phoneNumber, String email)
            throws HospitalDataException {

        super(id, cd, ud);

        if (!phoneNumber.matches("\\d{10}"))
            throw new HospitalDataException("Phone must be 10 digits");

        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$"))
            throw new HospitalDataException("Invalid email format");

        this.hospitalName = hospitalName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getHospitalName() { return hospitalName; }
}

// Department Class
class Department extends Entity {
    private String departmentName;
    private String departmentCode;

    public Department(int id, Date cd, Date ud, String name, String code)
            throws HospitalDataException {

        super(id, cd, ud);

        if (code.length() < 3)
            throw new HospitalDataException("Department code must be at least 3 characters");

        this.departmentName = name;
        this.departmentCode = code;
    }

    public String getDepartmentName() { return departmentName; }
}

// Doctor Class
class Doctor extends Entity {
    private String doctorName;
    private String specialization;
    private String doctorEmail;
    private String phone;

    public Doctor(int id, Date cd, Date ud, String doctorName,
                  String specialization, String doctorEmail, String phone)
            throws HospitalDataException {

        super(id, cd, ud);

        if (specialization.isEmpty())
            throw new HospitalDataException("Specialization cannot be empty");

        if (!doctorEmail.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$"))
            throw new HospitalDataException("Invalid doctor email");

        if (!phone.matches("\\d{10}"))
            throw new HospitalDataException("Doctor phone must be 10 digits");

        this.doctorName = doctorName;
        this.specialization = specialization;
        this.doctorEmail = doctorEmail;
        this.phone = phone;
    }

    public String getDoctorName() { return doctorName; }
}

// Nurse Class
class Nurse extends Entity {
    private String nurseName;
    private String shift;
    private int yearsOfExperience;

    public Nurse(int id, Date cd, Date ud, String nurseName, String shift, int years)
            throws HospitalDataException {

        super(id, cd, ud);

        if (!shift.equalsIgnoreCase("Day") &&
                !shift.equalsIgnoreCase("Night"))
            throw new HospitalDataException("Shift must be Day or Night");

        if (years < 0)
            throw new HospitalDataException("Years of experience cannot be negative");

        this.nurseName = nurseName;
        this.shift = shift;
        this.yearsOfExperience = years;
    }
}

// Patient Class
class Patient extends Entity {
    private String patientName;
    private int age;
    private String gender;
    private String contactNumber;

    public Patient(int id, Date cd, Date ud, String name, int age,
                   String gender, String contact)
            throws HospitalDataException {

        super(id, cd, ud);

        if (age <= 0) throw new HospitalDataException("Age must be > 0");

        if (!gender.equalsIgnoreCase("Male") &&
                !gender.equalsIgnoreCase("Female") &&
                !gender.equalsIgnoreCase("Other"))
            throw new HospitalDataException("Gender must be Male/Female/Other");

        if (contact.isEmpty())
            throw new HospitalDataException("Contact cannot be empty");

        this.patientName = name;
        this.age = age;
        this.gender = gender;
        this.contactNumber = contact;
    }

    public String getPatientName() { return patientName; }
    public int getAge() { return age; }
}

// Admission Class
class Admission extends Entity {
    private Date admissionDate;
    private String roomNumber;
    private double roomCharges;

    public Admission(int id, Date cd, Date ud, Date admissionDate,
                     String roomNumber, double roomCharges)
            throws HospitalDataException {

        super(id, cd, ud);

        if (admissionDate == null)
            throw new HospitalDataException("Admission date cannot be null");

        if (roomCharges <= 0)
            throw new HospitalDataException("Room charges must be > 0");

        this.admissionDate = admissionDate;
        this.roomNumber = roomNumber;
        this.roomCharges = roomCharges;
    }

    public double getRoomCharges() { return roomCharges; }
}

// Treatment Class
class Treatment extends Entity {
    private String diagnosis;
    private String treatmentGiven;
    private double treatmentCost;

    public Treatment(int id, Date cd, Date ud, String diagnosis,
                     String treatmentGiven, double cost)
            throws HospitalDataException {

        super(id, cd, ud);

        if (diagnosis.isEmpty() || treatmentGiven.isEmpty())
            throw new HospitalDataException("Diagnosis and treatment cannot be empty");

        if (cost <= 0)
            throw new HospitalDataException("Treatment cost must be > 0");

        this.diagnosis = diagnosis;
        this.treatmentGiven = treatmentGiven;
        this.treatmentCost = cost;
    }

    public double getTreatmentCost() { return treatmentCost; }
}

//  Bill Class
class Bill extends Entity {
    private double doctorFee;
    private double medicineCost;
    private double totalBill;

    public Bill(int id, Date cd, Date ud, double doctorFee, double medicineCost)
            throws HospitalDataException {

        super(id, cd, ud);

        if (doctorFee <= 0 || medicineCost <= 0)
            throw new HospitalDataException("Fees must be > 0");

        this.doctorFee = doctorFee;
        this.medicineCost = medicineCost;
    }

    public double getDoctorFee() { return doctorFee; }
    public double getMedicineCost() { return medicineCost; }
}

// Final HospitalRecord
final class HospitalRecord extends Bill {
    private Admission admission;
    private Treatment treatment;

    public HospitalRecord(int id, Date cd, Date ud, double doctorFee,
                          double medicineCost, Admission admission,
                          Treatment treatment)
            throws HospitalDataException {

        super(id, cd, ud, doctorFee, medicineCost);
        this.admission = admission;
        this.treatment = treatment;
    }

    // REQUIRED METHOD
    public double generateBill() {
        return admission.getRoomCharges() +
                treatment.getTreatmentCost() +
                getDoctorFee() +
                getMedicineCost();
    }
}

//  MAIN PROGRAM
public class HospitalManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("\n=== HOSPITAL MANAGEMENT SYSTEM ===");

            // Hospital
            System.out.print("Hospital name: ");
            String hname = sc.nextLine();
            System.out.print("Address: ");
            String haddr = sc.nextLine();
            System.out.print("Phone (10 digits): ");
            String hphone = sc.nextLine();
            System.out.print("Email: ");
            String hemail = sc.nextLine();

            Hospital hospital = new Hospital(
                    1, new Date(), new Date(), hname, haddr, hphone, hemail
            );

            // Patient
            System.out.print("\nPatient name: ");
            String pname = sc.nextLine();
            System.out.print("Age: ");
            int age = sc.nextInt(); sc.nextLine();
            System.out.print("Gender: ");
            String gender = sc.nextLine();
            System.out.print("Contact: ");
            String pcontact = sc.nextLine();

            Patient patient = new Patient(
                    2, new Date(), new Date(), pname, age, gender, pcontact
            );

            // Admission
            System.out.print("\nRoom Number: ");
            String room = sc.nextLine();
            System.out.print("Room Charges: ");
            double roomCharges = sc.nextDouble(); sc.nextLine();

            Admission admission = new Admission(
                    3, new Date(), new Date(), new Date(), room, roomCharges
            );

            // Treatment
            System.out.print("\nDiagnosis: ");
            String diagnosis = sc.nextLine();
            System.out.print("Treatment Given: ");
            String treat = sc.nextLine();
            System.out.print("Treatment Cost: ");
            double tcost = sc.nextDouble(); sc.nextLine();

            Treatment treatment = new Treatment(
                    4, new Date(), new Date(), diagnosis, treat, tcost
            );

            // Bill
            System.out.print("\nDoctor Fee: ");
            double dFee = sc.nextDouble();
            System.out.print("Medicine Cost: ");
            double mCost = sc.nextDouble();

            HospitalRecord record = new HospitalRecord(
                    10, new Date(), new Date(), dFee, mCost, admission, treatment
            );

            double finalBill = record.generateBill();

            // ===================== OUTPUT =====================
            System.out.println("\n====== FINAL BILL ======");
            System.out.println("Hospital: " + hospital.getHospitalName());
            System.out.println("Patient Name: " + patient.getPatientName());
            System.out.println("Age: " + patient.getAge());
            System.out.println("Diagnosis: " + diagnosis);
            System.out.println("Room Charges: " + admission.getRoomCharges());
            System.out.println("Treatment Cost: " + treatment.getTreatmentCost());
            System.out.println("Doctor Fee: " + dFee);
            System.out.println("Medicine Cost: " + mCost);
            System.out.println("----------------------------------");
            System.out.println("Total Bill = " + finalBill);
            System.out.println("==================================");

        } catch (HospitalDataException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
