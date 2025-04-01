package Admin.demo;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class StudentExample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String email;
    private String password;
    private String profilePicture;
    private boolean isStudent; // true = Student, false = Tutor

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus accountStatus = AccountStatus.PENDING; // Default status

    @ElementCollection
    private List<String> classesTaken; // For students

    @ElementCollection
    private List<String> classesOffered; // For tutors

    @ElementCollection
    private List<String> schedule; // Simplified placeholder for schedules

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public List<String> getClassesTaken() {
        return classesTaken;
    }

    public void setClassesTaken(List<String> classesTaken) {
        this.classesTaken = classesTaken;
    }

    public List<String> getClassesOffered() {
        return classesOffered;
    }

    public void setClassesOffered(List<String> classesOffered) {
        this.classesOffered = classesOffered;
    }

    public List<String> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<String> schedule) {
        this.schedule = schedule;
    }
}
