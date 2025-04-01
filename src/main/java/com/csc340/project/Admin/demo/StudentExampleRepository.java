package Admin.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentExampleRepository extends JpaRepository<StudentExample, Integer> {
    // You can define custom queries here if needed in the future.
}
