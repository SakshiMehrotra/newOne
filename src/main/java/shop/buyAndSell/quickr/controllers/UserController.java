package shop.buyAndSell.quickr.controllers;

import java.util.List;

import shop.buyAndSell.quickr.models.User;
import shop.buyAndSell.quickr.repositories.UserRepo;
import shop.buyAndSell.quickr.responses.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin

public class UserController {
    @Autowired
    UserRepo userRepo;
    
    @PostMapping("/Register")
    public Response addUser(@RequestBody User user)
    {
        if(userRepo.count()>0)
        {
            List<User> list= userRepo.findAll();
            for (User user2 : list) {
                if(user2.getEmail().equals(user.getEmail())){
                    return new Response(400, "Already exists", user);
                }
                }
            }
            userRepo.save(user);
        return new Response(200, "registration successfull", user);
    }

    @PostMapping("/Login")
    public Response login(@RequestBody User user)
    {
        if(userRepo.count()>0){
            List<User> data = userRepo.findAll();
            for(User user2: data){
                if(user2.getEmail().equals(user.getEmail()) && user2.getPassword().equals(user.getPassword())){
                    return new Response(200,"Login Successfull",user);
                }
            }
        }       
        return new Response(400,"User Not found",user);
    }
    }
   
    
         
         

    
