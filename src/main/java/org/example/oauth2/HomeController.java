package org.example.oauth2;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("")
    public ResponseEntity<?> login(OAuth2AuthenticationToken token){
        return ResponseEntity.ok(token.getPrincipal().getAttributes());
    }
}
