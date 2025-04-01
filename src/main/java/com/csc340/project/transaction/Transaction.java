package transaction;

import Admin.demo.StudentExample;
import tutor.Tutor;
import posting.Posting;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentExample student;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name = "posting_id", nullable = false)
    private Posting posting;

    @Column(nullable = false)
    private double rate;

    @Column(nullable = false)
    private String paymentType;

    @Column(nullable = false)
    private String paymentStatus;

    @Column(nullable = false)
    private LocalDateTime transactionDate;

    // Constructor
    public Transaction() {
    }

    public Transaction(StudentExample student, Tutor tutor, Posting posting, double rate, String paymentType, String paymentStatus, LocalDateTime transactionDate) {
        this.student = student;
        this.tutor = tutor;
        this.posting = posting;
        this.rate = rate;
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
        this.transactionDate = transactionDate;
    }

    // Getters and Setters
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public StudentExample getStudent() {
        return student;
    }

    public void setStudent(StudentExample student) {
        this.student = student;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Posting getPosting() {
        return posting;
    }

    public void setPosting(Posting posting) {
        this.posting = posting;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    // Method to convert Transaction to TransactionDTO
    public TransactionDTO toDTO() {
        return new TransactionDTO(
                this.student.getId(),
                this.student.getUsername(),
                this.student.getEmail(),
                this.student.getProfilePicture(),
                this.tutor.getTutorId(),
                this.tutor.getUsername(),
                this.tutor.getPhoto(),
                this.posting.getTitle(),
                this.rate,
                this.paymentType,
                this.paymentStatus,
                this.transactionDate
        );
    }

    // Nested static DTO class for Transaction
    public static class TransactionDTO {

        private int studentId;
        private String studentName;
        private String studentEmail;
        private String studentProfilePic;

        private int tutorId;
        private String tutorName;
        private String tutorProfilePic;

        private String className;
        private double rate;
        private String paymentType;
        private String paymentStatus;
        private LocalDateTime transactionDate;

        // Constructor
        public TransactionDTO(int studentId, String studentName, String studentEmail, String studentProfilePic,
                              int tutorId, String tutorName, String tutorProfilePic,
                              String className, double rate, String paymentType, String paymentStatus, LocalDateTime transactionDate) {
            this.studentId = studentId;
            this.studentName = studentName;
            this.studentEmail = studentEmail;
            this.studentProfilePic = studentProfilePic;
            this.tutorId = tutorId;
            this.tutorName = tutorName;
            this.tutorProfilePic = tutorProfilePic;
            this.className = className;
            this.rate = rate;
            this.paymentType = paymentType;
            this.paymentStatus = paymentStatus;
            this.transactionDate = transactionDate;
        }

        // Getters
        public int getStudentId() {
            return studentId;
        }

        public String getStudentName() {
            return studentName;
        }

        public String getStudentEmail() {
            return studentEmail;
        }

        public String getStudentProfilePic() {
            return studentProfilePic;
        }

        public int getTutorId() {
            return tutorId;
        }

        public String getTutorName() {
            return tutorName;
        }

        public String getTutorProfilePic() {
            return tutorProfilePic;
        }

        public String getClassName() {
            return className;
        }

        public double getRate() {
            return rate;
        }

        public String getPaymentType() {
            return paymentType;
        }

        public String getPaymentStatus() {
            return paymentStatus;
        }

        public LocalDateTime getTransactionDate() {
            return transactionDate;
        }
    }
}
