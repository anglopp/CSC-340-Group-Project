package user;

import Admin.demo.StudentExample;
import Admin.demo.AccountStatus;
import Admin.demo.StudentExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private StudentExampleRepository studentExampleRepository;

    // Get the account status of a student by ID
    public AccountStatus getAccountStatus(int studentId) {
        Optional<StudentExample> student = studentExampleRepository.findById(studentId);
        if (student.isPresent()) {
            return student.get().getAccountStatus();
        } else {
            throw new IllegalArgumentException("Student not found with ID: " + studentId);
        }
    }

    // Update the account status of a student by ID
    public StudentExample updateAccountStatus(int studentId, AccountStatus accountStatus) {
        Optional<StudentExample> student = studentExampleRepository.findById(studentId);
        if (student.isPresent()) {
            StudentExample studentExample = student.get();
            studentExample.setAccountStatus(accountStatus);
            return studentExampleRepository.save(studentExample);
        } else {
            throw new IllegalArgumentException("Student not found with ID: " + studentId);
        }
    }

    // Delete a student's account if their status is denied/banned
    public void deleteStudentAccount(int studentId) {
        Optional<StudentExample> student = studentExampleRepository.findById(studentId);
        if (student.isPresent()) {
            StudentExample studentExample = student.get();
            if (studentExample.getAccountStatus() == AccountStatus.DENIED) {
                studentExampleRepository.delete(studentExample);
            } else {
                throw new IllegalArgumentException("Account status is not denied/banned, cannot delete.");
            }
        } else {
            throw new IllegalArgumentException("Student not found with ID: " + studentId);
        }
    }
}
