package transaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    // You can add custom queries here if needed (e.g., find by student, tutor, etc.)
}
