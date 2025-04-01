package Admin.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//imports for generating Id stuff, might not use
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Admin {

    @Id
    private int id;
    private String username;
    private String password;
    private String email;
    private String role; // Admin-specific role, might be expanded

    public void setId(int id) {
    }

    // Add other fields or relationships if needed
    // For example, a list of managed users or reviews

    // Getters and Setters
}
