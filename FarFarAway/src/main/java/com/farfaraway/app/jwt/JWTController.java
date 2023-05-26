package com.farfaraway.app.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farfaraway.app.exception.UserNotFoundException;
import org.json.JSONObject;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "https://main.df7xyjdxqxvgb.amplifyapp.com", maxAge = 3600)
@RequestMapping("/login")
public class JWTController {
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @PostMapping
    public Object getTokenForAuthenticatedUser(@RequestBody JWTAuthenticationRequest authRequest){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        if (authentication.isAuthenticated()){
            String token =  jwtService.generateToken(authRequest.getUserName());
            JSONObject jsonObject = new JSONObject("{\"token\": \"" + token + "\"}");
            jsonObject.put("token",token );
            return jsonObject.toMap();//devuelve token por body
        }
        else {
        	System.out.println("Invalid user credentials");
            throw new UserNotFoundException("Invalid user credentials");
        }
    }
}