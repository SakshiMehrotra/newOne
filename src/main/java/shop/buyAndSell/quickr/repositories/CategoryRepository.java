package shop.buyAndSell.quickr.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import shop.buyAndSell.quickr.models.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String>{
    
}
