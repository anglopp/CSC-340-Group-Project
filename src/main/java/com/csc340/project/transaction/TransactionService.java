package transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // Method for standard GET
    // Gets all transactions
    public List<Transaction.TransactionDTO> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        List<Transaction.TransactionDTO> transactionDTOs = new ArrayList<>();
        for (Transaction transaction : transactions) {
            Transaction.TransactionDTO dto = new Transaction.TransactionDTO(
                    transaction.getStudent().getId(),
                    transaction.getStudent().getUsername(),
                    transaction.getStudent().getEmail(),
                    transaction.getStudent().getProfilePicture(),
                    transaction.getTutor().getTutorId(),
                    transaction.getTutor().getUsername(),
                    transaction.getTutor().getPhoto(),
                    transaction.getPosting().getTitle(),
                    transaction.getRate(),
                    transaction.getPaymentType(),
                    transaction.getPaymentStatus(),
                    transaction.getTransactionDate()
            );
            transactionDTOs.add(dto);
        }
        return transactionDTOs;
    }

    // Method for GET (by ID)
    // Gets transaction by ID
    public Transaction.TransactionDTO getTransactionById(int transactionId) {
        Optional<Transaction> transactionOpt = transactionRepository.findById(transactionId);
        if (transactionOpt.isPresent()) {
            Transaction transaction = transactionOpt.get();
            return new Transaction.TransactionDTO(
                    transaction.getStudent().getId(),
                    transaction.getStudent().getUsername(),
                    transaction.getStudent().getEmail(),
                    transaction.getStudent().getProfilePicture(),
                    transaction.getTutor().getTutorId(),
                    transaction.getTutor().getUsername(),
                    transaction.getTutor().getPhoto(),
                    transaction.getPosting().getTitle(),
                    transaction.getRate(),
                    transaction.getPaymentType(),
                    transaction.getPaymentStatus(),
                    transaction.getTransactionDate()
            );
        }
        return null; // or throw custom exception
    }

    // Method for PUT
    // Updates a transaction (e.g., update payment status, student, tutor, etc.)
    public Transaction updateTransaction(int transactionId, Transaction updatedTransaction) {
        Optional<Transaction> transactionOpt = transactionRepository.findById(transactionId);
        if (transactionOpt.isPresent()) {
            Transaction transaction = transactionOpt.get();

            // Update fields (you can add other fields here as needed)
            transaction.setStudent(updatedTransaction.getStudent());
            transaction.setTutor(updatedTransaction.getTutor());
            transaction.setPosting(updatedTransaction.getPosting());
            transaction.setRate(updatedTransaction.getRate());
            transaction.setPaymentType(updatedTransaction.getPaymentType());
            transaction.setPaymentStatus(updatedTransaction.getPaymentStatus());
            transaction.setTransactionDate(updatedTransaction.getTransactionDate());

            // Save the updated transaction
            return transactionRepository.save(transaction);
        }
        return null; // or throw custom exception
    }

    // Method for DELETE
    // Deletes a transaction by ID
    public boolean deleteTransaction(int transactionId) {
        Optional<Transaction> transactionOpt = transactionRepository.findById(transactionId);
        if (transactionOpt.isPresent()) {
            transactionRepository.deleteById(transactionId);
            return true; // Transaction deleted successfully
        }
        return false; // Transaction not found
    }
}
