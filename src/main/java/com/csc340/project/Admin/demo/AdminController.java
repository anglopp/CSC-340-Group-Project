package Admin.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Admin CRUD operations
    @GetMapping("/admins")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/admins/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable int id) {
        Optional<Admin> admin = adminService.getAdminById(id);
        return admin.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/admins")
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    @PutMapping("/admins/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable int id, @RequestBody Admin admin) {
        Admin updatedAdmin = adminService.updateAdmin(id, admin);
        return updatedAdmin != null ? ResponseEntity.ok(updatedAdmin) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/admins/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable int id) {
        return adminService.deleteAdmin(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // User Management CRUD
//    @GetMapping("/users")
//    public List<User> getAllUsers() {
//        return adminService.getAllUsers();
//    }
//
//    @GetMapping("/users/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable int id) {
//        Optional<User> user = adminService.getUserById(id);
//        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/users/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
//        return adminService.deleteUser(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
//    }
//
//    // Transaction Management CRUD
//    @GetMapping("/transactions")
//    public List<Transaction> getAllTransactions() {
//        return adminService.getAllTransactions();
//    }
//
//    @GetMapping("/transactions/{id}")
//    public ResponseEntity<Transaction> getTransactionById(@PathVariable int id) {
//        Optional<Transaction> transaction = adminService.getTransactionById(id);
//        return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/transactions/{id}")
//    public ResponseEntity<Void> deleteTransaction(@PathVariable int id) {
//        return adminService.deleteTransaction(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
//    }
//
//    // Review Management CRUD
//    @GetMapping("/reviews")
//    public List<Review> getAllReviews() {
//        return adminService.getAllReviews();
//    }
//
//    @GetMapping("/reviews/{id}")
//    public ResponseEntity<Review> getReviewById(@PathVariable int id) {
//        Optional<Review> review = adminService.getReviewById(id);
//        return review.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/reviews/{id}")
//    public ResponseEntity<Void> deleteReview(@PathVariable int id) {
//        return adminService.deleteReview(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
//    }
//
//    // Admin Statistics
//    @GetMapping("/statistics")
//    public ResponseEntity<String> getStatistics() {
//        int userCount = adminService.getUserCount();
//        int reviewCount = adminService.getReviewCount();
//        int transactionCount = adminService.getTransactionCount();
//
//        return ResponseEntity.ok(String.format("Users: %d, Reviews: %d, Transactions: %d", userCount, reviewCount, transactionCount));
//    }
}
