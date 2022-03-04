package com.lendTech.digiLend.services;

import com.lendTech.digiLend.models.AuthToken;
import com.lendTech.digiLend.models.User;
import com.lendTech.digiLend.repositories.AuthTokenRepository;
import com.lendTech.digiLend.repositories.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    AuthTokenRepository authTokenRepository;

    @Autowired
    UserRepository userRepository;

    /**
     * Finds user details by auth token
     * @param authToken
     * @return
     */
    public JSONObject findUserByAuthToken(String authToken) {
        JSONObject userDetails = new JSONObject();
        Long userId = authTokenRepository.findByAuthToken(authToken).getUserId();
        Optional<User> byId = userRepository.findById(userId);
        if (byId.isPresent()) {
            User user = byId.get();
            userDetails.put("id", user.getId());
            userDetails.put("username", user.getUsername());
            userDetails.put("firstName", user.getFirstName());
            userDetails.put("secondName", user.getSecondName());
            userDetails.put("accountStatus", user.getAccountStatus());
        }
        System.out.println(userDetails);
        return userDetails;
    }

    /**
     * Saves auth tokens
     * @param jwt
     * @param id
     */
    public void saveAuthToken(String jwt, Long id) {
        AuthToken authToken = new AuthToken();
        authToken.setAuthToken(jwt);
        authToken.setUserId(id);
        authTokenRepository.save(authToken);
    }
}
