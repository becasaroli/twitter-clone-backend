package Twitter.demo.controller;

import java.text.ParseException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Twitter.demo.Repository.UsersRepository;
import Twitter.demo.orm.Users;

@RestController
public class UsersController{

   
   @Autowired
   private UsersRepository uRepository;

    @RequestMapping("/users")
    
     public List<Users> list(String username) throws ParseException{
        List<Users> users = uRepository.findByUsername(username);
        return users;
        
     }
    }

    
