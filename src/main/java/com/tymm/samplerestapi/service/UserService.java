package com.tymm.samplerestapi.service;

import com.tymm.samplerestapi.config.ServiceConfig;
import com.tymm.samplerestapi.entity.User;
import com.tymm.samplerestapi.util.HttpHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author cheong.tymm
 */
@Service
public class UserService {

    private final ServiceConfig servConfig;
    
    public UserService(ServiceConfig servConfig) {
        this.servConfig = servConfig;
    }
    
    // simulate post to a third party api
    public User add(User user) throws Exception{
        return HttpHelper.postForObject(this.servConfig.getOther_endpoint_1(), user, User.class);
    }
}
