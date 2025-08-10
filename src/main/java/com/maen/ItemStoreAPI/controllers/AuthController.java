package com.maen.ItemStoreAPI.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;
import java.util.Date;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        if ("user".equals(request.getUsername()) && "pass".equals(request.getPassword())){
            Key key = Keys.hmacShaKeyFor("MySuperSecretKeyThatIsLongEnough1234567890".getBytes());
            String token = Jwts.builder()
                    .setSubject(request.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 3600000)) //
                    .signWith(key, SignatureAlgorithm.HS256)
                    .compact();
            return ResponseEntity.ok(new AuthResponse(token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    public static class AuthRequest {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public AuthRequest(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public AuthRequest() {
        }
    }

    public static class AuthResponse {
        private String token;

        public String getToken(){
            return token;
        }
        public void setToken(String token){
            this.token = token;
        }

        public AuthResponse(String token) {
            this.token = token;
        }

        public AuthResponse() {
        }
    }
}