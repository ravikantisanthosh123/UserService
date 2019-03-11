package com.stackroute.userservice.controller;
import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User saveUser=userService.saveUser(user);
        return new ResponseEntity<User>(saveUser, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return  new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable int id) {
        return new ResponseEntity<Optional<User>>(userService.getUserById(id),HttpStatus.OK);
    }
   @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User user){
        User updateUser = userService.updateUser(user,id);
        return new ResponseEntity<User>(updateUser,HttpStatus.OK);
   }
   @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable int id)
   {
      userService.deleteUserById(id);
   }

}
