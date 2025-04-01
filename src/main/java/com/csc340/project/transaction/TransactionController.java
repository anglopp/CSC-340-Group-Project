package transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutelage/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    /**
     * Get all transactions from the database.
     * URL: http://localhost:8080/tutelage/transactions
     * Method: GET
     *
     * @return A list of all transactions with student, tutor, and transaction details
     */
    @GetMapping
    public List<Transaction.TransactionDTO> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    /**
     * Update the information of an existing transaction.
     * URL: http://localhost:8080/tutelage/transactions/{transactionId}
     * Method: PUT
     *
     * @param transactionId The ID of the transaction to be updated.
     * @param updatedTransaction The updated transaction data.
     * @return Response indicating the status of the update operation.
     */
    @PutMapping("/{transactionId}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable int transactionId, @RequestBody Transaction updatedTransaction) {
        // Assuming the service layer handles the update logic
        Transaction updated = transactionService.updateTransaction(transactionId, updatedTransaction);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build(); // If the transaction with the given ID doesn't exist
        }
    }

    /**
     * Delete a transaction.
     * URL: http://localhost:8080/tutelage/transactions/{transactionId}
     * Method: DELETE
     *
     * @param transactionId The ID of the transaction to be deleted.
     * @return Response indicating the status of the delete operation.
     */
    @DeleteMapping("/{transactionId}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable int transactionId) {
        boolean deleted = transactionService.deleteTransaction(transactionId);
        if (deleted) {
            return ResponseEntity.noContent().build(); // Successfully deleted
        } else {
            return ResponseEntity.notFound().build(); // If the transaction with the given ID doesn't exist
        }
    }
}
