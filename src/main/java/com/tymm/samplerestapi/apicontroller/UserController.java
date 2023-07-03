package com.tymm.samplerestapi.apicontroller;

import com.tymm.samplerestapi.entity.User;
import com.tymm.samplerestapi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cheong.tymm
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    
    private final UserService userService;
    
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody User param) throws Exception {
        // perform necessary sanitization and checking
        // ...
        try{
            User updatedUser = userService.add(param);
            log.info("Add user success");
            return ResponseEntity.ok(updatedUser);
        }
        catch(Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}
