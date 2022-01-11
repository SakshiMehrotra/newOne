package shop.buyAndSell.quickr.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import shop.buyAndSell.quickr.models.Payment;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String>{
    
}
