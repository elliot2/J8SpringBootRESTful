package codingChallenge.models;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    //JPA Query method
    List<Transaction> findByAccountNumber(String accountNumber);
}
