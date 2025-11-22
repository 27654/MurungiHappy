package happy27654qn2;

import java.util.Scanner;

class Entity {
    private int id;
    private String createdDate;
    private String updatedDate;

    public Entity(int id, String createdDate, String updatedDate) {
        if (id <= 0) throw new IllegalArgumentException("ID must be > 0");
        if (createdDate == null || createdDate.isEmpty())
            throw new IllegalArgumentException("Created date required");
        if (updatedDate == null || updatedDate.isEmpty())
            throw new IllegalArgumentException("Updated date required");

        this.id = id;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public int getId() { return id; }
    public String getCreatedDate() { return createdDate; }
    public String getUpdatedDate() { return updatedDate; }
}

class School extends Entity {
    private String schoolName;
    private String address;
    private String phoneNumber;
    private String email;

    public School(int id, String createdDate, String updatedDate,
                  String schoolName, String address, String phoneNumber, String email) {
        super(id, createdDate, updatedDate);

        if (schoolName.isEmpty()) throw new IllegalArgumentException("School name required");
        if (address.isEmpty()) throw new IllegalArgumentException("Address required");
        if (!phoneNumber.matches("\\d{10,15}")) throw new IllegalArgumentException("Invalid phone");
        if (!email.contains("@")) throw new IllegalArgumentException("Invalid email");

        this.schoolName = schoolName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}

class Department extends School {
    private String departmentName;
    private String departmentCode;

    public Department(int id, String createdDate, String updatedDate,
                      String schoolName, String address, String phone, String email,
                      String departmentName, String departmentCode) {
        super(id, createdDate, updatedDate, schoolName, address, phone, email);

        if (departmentName.isEmpty()) throw new IllegalArgumentException("Dept name required");
        if (departmentCode.length() < 3 || !departmentCode.matches("[a-zA-Z0-9]+"))
            throw new IllegalArgumentException("Invalid dept code");

        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
    }
}

class Teacher extends Department {
    private String teacherName;
    private String subject;
    private String teacherEmail;
    private String phone;

    public Teacher(int id, String createdDate, String updatedDate,
                   String schoolName, String address, String phoneNumber, String email,
                   String departmentName, String departmentCode,
                   String teacherName, String subject, String teacherEmail, String phone) {

        super(id, createdDate, updatedDate, schoolName, address, phoneNumber, email,
                departmentName, departmentCode);

        if (teacherName.isEmpty()) throw new IllegalArgumentException("Teacher name required");
        if (subject.isEmpty()) throw new IllegalArgumentException("Subject required");
        if (!teacherEmail.contains("@")) throw new IllegalArgumentException("Invalid teacher email");
        if (!phone.matches("\\d{10,15}")) throw new IllegalArgumentException("Invalid phone");

        this.teacherName = teacherName;
        this.subject = subject;
        this.teacherEmail = teacherEmail;
        this.phone = phone;
    }
}

class Student extends Teacher {
    private String studentName;
    private int rollNumber;
    private String grade;
    private String contactNumber;

    public Student(int id, String createdDate, String updatedDate,
                   String schoolName, String address, String phoneNumber, String email,
                   String departmentName, String departmentCode,
                   String teacherName, String subject, String teacherEmail, String phone,
                   String studentName, int rollNumber, String grade, String contactNumber) {

        super(id, createdDate, updatedDate, schoolName, address, phoneNumber, email,
                departmentName, departmentCode, teacherName, subject, teacherEmail, phone);

        if (studentName.isEmpty()) throw new IllegalArgumentException("Student name required");
        if (rollNumber <= 0) throw new IllegalArgumentException("Roll number must be > 0");
        if (grade.isEmpty()) throw new IllegalArgumentException("Grade required");
        if (!contactNumber.matches("\\d{10,15}")) throw new IllegalArgumentException("Invalid contact");

        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.contactNumber = contactNumber;
    }
}

class Course extends Student {
    private String courseName;
    private String courseCode;
    private int creditHours;

    public Course(int id, String createdDate, String updatedDate,
                  String schoolName, String address, String phoneNumber, String email,
                  String departmentName, String departmentCode,
                  String teacherName, String subject, String teacherEmail, String phone,
                  String studentName, int rollNumber, String grade, String contactNumber,
                  String courseName, String courseCode, int creditHours) {

        super(id, createdDate, updatedDate, schoolName, address, phoneNumber, email,
                departmentName, departmentCode, teacherName, subject, teacherEmail, phone,
                studentName, rollNumber, grade, contactNumber);

        if (courseName.isEmpty()) throw new IllegalArgumentException("Course name required");
        if (courseCode.isEmpty()) throw new IllegalArgumentException("Course code required");
        if (creditHours <= 0) throw new IllegalArgumentException("Credit hours > 0 required");

        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
    }
}

class Exam extends Course {
    private String examName;
    private int maxMarks;
    private String examDate;

    public Exam(int id, String createdDate, String updatedDate,
                String schoolName, String address, String phoneNumber, String email,
                String departmentName, String departmentCode,
                String teacherName, String subject, String teacherEmail, String phone,
                String studentName, int rollNumber, String grade, String contactNumber,
                String courseName, String courseCode, int creditHours,
                String examName, int maxMarks, String examDate) {

        super(id, createdDate, updatedDate, schoolName, address, phoneNumber, email,
                departmentName, departmentCode, teacherName, subject, teacherEmail, phone,
                studentName, rollNumber, grade, contactNumber,
                courseName, courseCode, creditHours);

        if (examName.isEmpty()) throw new IllegalArgumentException("Exam name required");
        if (maxMarks <= 0) throw new IllegalArgumentException("Max marks must > 0");
        if (examDate.isEmpty()) throw new IllegalArgumentException("Exam date required");

        this.examName = examName;
        this.maxMarks = maxMarks;
        this.examDate = examDate;
    }

    public int getMaxMarks() { return maxMarks; }
}

class Result extends Exam {
    private int obtainedMarks;
    private String remarks;

    public Result(int id, String createdDate, String updatedDate,
                  String schoolName, String address, String phoneNumber, String email,
                  String departmentName, String departmentCode,
                  String teacherName, String subject, String teacherEmail, String phone,
                  String studentName, int rollNumber, String grade, String contactNumber,
                  String courseName, String courseCode, int creditHours,
                  String examName, int maxMarks, String examDate,
                  int obtainedMarks, String remarks) {

        super(id, createdDate, updatedDate, schoolName, address, phoneNumber, email,
                departmentName, departmentCode, teacherName, subject, teacherEmail, phone,
                studentName, rollNumber, grade, contactNumber,
                courseName, courseCode, creditHours,
                examName, maxMarks, examDate);

        if (obtainedMarks < 0) throw new IllegalArgumentException("Marks cannot be negative");
        if (remarks.isEmpty()) throw new IllegalArgumentException("Remarks required");

        this.obtainedMarks = obtainedMarks;
        this.remarks = remarks;
    }

    public int getObtainedMarks() { return obtainedMarks; }
}

class Fee extends Result {
    private double tuitionFee;
    private double examFee;
    private double totalFee;

    public Fee(int id, String createdDate, String updatedDate,
               String schoolName, String address, String phoneNumber, String email,
               String departmentName, String departmentCode,
               String teacherName, String subject, String teacherEmail, String phone,
               String studentName, int rollNumber, String grade, String contactNumber,
               String courseName, String courseCode, int creditHours,
               String examName, int maxMarks, String examDate,
               int obtainedMarks, String remarks,
               double tuitionFee, double examFee, double totalFee) {

        super(id, createdDate, updatedDate, schoolName, address, phoneNumber, email,
                departmentName, departmentCode, teacherName, subject, teacherEmail, phone,
                studentName, rollNumber, grade, contactNumber,
                courseName, courseCode, creditHours,
                examName, maxMarks, examDate, obtainedMarks, remarks);

        if (tuitionFee <= 0 || examFee <= 0 || totalFee <= 0)
            throw new IllegalArgumentException("Fees must be > 0");

        this.tuitionFee = tuitionFee;
        this.examFee = examFee;
        this.totalFee = totalFee;
    }
}

final class StudentRecord extends Fee {

    public StudentRecord(int id, String createdDate, String updatedDate,
                         String schoolName, String address, String phoneNumber, String email,
                         String departmentName, String departmentCode,
                         String teacherName, String subject, String teacherEmail, String phone,
                         String studentName, int rollNumber, String grade, String contactNumber,
                         String courseName, String courseCode, int creditHours,
                         String examName, int maxMarks, String examDate,
                         int obtainedMarks, String remarks,
                         double tuitionFee, double examFee, double totalFee) {

        super(id, createdDate, updatedDate, schoolName, address, phoneNumber, email,
                departmentName, departmentCode, teacherName, subject, teacherEmail, phone,
                studentName, rollNumber, grade, contactNumber,
                courseName, courseCode, creditHours,
                examName, maxMarks, examDate, obtainedMarks, remarks,
                tuitionFee, examFee, totalFee);
    }

    public double calculateAverageMarks() {
        return ((double) getObtainedMarks() / getMaxMarks()) * 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter roll number:");
        int roll = sc.nextInt();

        System.out.println("Enter obtained marks:");
        int marks = sc.nextInt();

        System.out.println("Enter max marks:");
        int max = sc.nextInt();

        StudentRecord sr = new StudentRecord(
                1, "2025-01-01", "2025-01-02",
                "ABC School", "Main Road", "0780000000", "school@mail.com",
                "Science", "SCI001",
                "John Teacher", "Math", "teacher@mail.com", "0781111111",
                "Student A", roll, "A", "0782222222",
                "Maths", "M101", 3,
                "Midterm", max, "2025-02-01",
                marks, "Good",
                200000, 50000, 250000
        );

        System.out.println("Average Marks: " + sr.calculateAverageMarks() + "%");
    }
}
