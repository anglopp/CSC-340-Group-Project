package user;

import Admin.demo.AccountStatus;
import Admin.demo.StudentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Get the account status of a student by their ID.
     * URL: GET http://localhost:8080/admin/users/{studentId}/status
     *
     * @param studentId The ID of the student.
     * @return The account status of the student.
     */
    @GetMapping("/{studentId}/status")
    public ResponseEntity<AccountStatus> getAccountStatus(@PathVariable int studentId) {
        try {
            AccountStatus status = userService.getAccountStatus(studentId);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Update the account status of a student by their ID.
     * URL: PUT http://localhost:8080/admin/users/{studentId}/status
     *
     * @param studentId The ID of the student to update.
     * @param accountStatus The new account status to be set for the student.
     * @return The updated student object.
     */
    @PutMapping("/{studentId}/status")
    public ResponseEntity<StudentExample> updateAccountStatus(
            @PathVariable int studentId, @RequestBody AccountStatus accountStatus) {
        try {
            StudentExample updatedStudent = userService.updateAccountStatus(studentId, accountStatus);
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete a student's account if their status is denied or banned.
     * URL: DELETE http://localhost:8080/admin/users/{studentId}/delete
     *
     * @param studentId The ID of the student to delete.
     * @return HTTP response indicating whether the account was deleted successfully.
     */
    @DeleteMapping("/{studentId}/delete")
    public ResponseEntity<Void> deleteStudentAccount(@PathVariable int studentId) {
        try {
            userService.deleteStudentAccount(studentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
