package review;

import Admin.demo.StudentExample;
import jakarta.persistence.*;
import posting.Posting;
import tutor.Tutor;

import java.time.LocalDate;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String reviewMessage;
    private LocalDate dateCreated;

    // The Tutor of the class who got the review
    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    private Tutor tutor;

    // The Student who wrote the review
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentExample student;

    // The Class that received the review
    @ManyToOne
    @JoinColumn(name = "posting_id", nullable = false)
    private Posting posting;

    // DTO to represent a simplified Review
    public static class ReviewDTO {

        private int studentId;
        private String studentName;
        private int tutorId;
        private String tutorName;
        private String className;
        private String reviewMessage;
        private LocalDate dateCreated;

        public ReviewDTO(int studentId, String studentName, int tutorId, String tutorName, String className, String reviewMessage, LocalDate dateCreated) {
            this.studentId = studentId;
            this.studentName = studentName;
            this.tutorId = tutorId;
            this.tutorName = tutorName;
            this.className = className;
            this.reviewMessage = reviewMessage;
            this.dateCreated = dateCreated;
        }

        // Getters and setters for ReviewDTO
        public int getStudentId() {
            return studentId;
        }

        public void setStudentId(int studentId) {
            this.studentId = studentId;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public int getTutorId() {
            return tutorId;
        }

        public void setTutorId(int tutorId) {
            this.tutorId = tutorId;
        }

        public String getTutorName() {
            return tutorName;
        }

        public void setTutorName(String tutorName) {
            this.tutorName = tutorName;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public String getReviewMessage() {
            return reviewMessage;
        }

        public void setReviewMessage(String reviewMessage) {
            this.reviewMessage = reviewMessage;
        }

        public LocalDate getDateCreated() {
            return dateCreated;
        }

        public void setDateCreated(LocalDate dateCreated) {
            this.dateCreated = dateCreated;
        }
    }

    // Getters and setters for Review entity
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReviewMessage() {
        return reviewMessage;
    }

    public void setReviewMessage(String reviewMessage) {
        this.reviewMessage = reviewMessage;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public StudentExample getStudent() {
        return student;
    }

    public void setStudent(StudentExample student) {
        this.student = student;
    }

    public Posting getPosting() {
        return posting;
    }

    public void setPosting(Posting posting) {
        this.posting = posting;
    }

    // Method to convert Review to a Data Transfer Object
    public ReviewDTO toDTO() {
        return new ReviewDTO(
                this.student.getId(), // Get the student's ID
                this.student.getUsername(), // Assuming 'getUsername()' exists for Student
                this.tutor.getTutorId(), // Get the tutor's ID
                this.tutor.getUsername(), // Assuming 'getUsername()' exists for Tutor
                this.posting.getTitle(), // Get the class name (or title)
                this.reviewMessage,
                this.dateCreated
        );
    }
}
