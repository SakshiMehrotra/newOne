package shop.buyAndSell.quickr.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import shop.buyAndSell.quickr.models.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order,String>{
    
}
