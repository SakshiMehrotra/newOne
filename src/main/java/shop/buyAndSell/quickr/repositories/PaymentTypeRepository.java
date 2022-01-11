package shop.buyAndSell.quickr.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import shop.buyAndSell.quickr.models.PaymentType;

public interface PaymentTypeRepository extends MongoRepository<PaymentType, String>{
    
}
