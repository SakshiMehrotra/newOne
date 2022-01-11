package shop.buyAndSell.quickr.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import shop.buyAndSell.quickr.models.User;

public interface UserRepo extends MongoRepository<User, String> {

}
