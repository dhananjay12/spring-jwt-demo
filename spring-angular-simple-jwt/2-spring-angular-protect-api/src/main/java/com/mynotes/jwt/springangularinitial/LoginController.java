package com.mynotes.jwt.springangularinitial;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
	
	 @Autowired
	    private AuthenticationManager authenticationManager;
	 
	 @Autowired
	 private JwtTokenUtil jwtTokenUtil;
	
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public ResponseEntity<?> createAuthenticationToken(HttpServletResponse res,@RequestBody LoginRequest loginRequest) throws AuthenticationException {

	        // Perform the security
	        final Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                		loginRequest.getUsername(),
	                		loginRequest.getPassword(),
	                		 Collections.emptyList()
	                )
	        );
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        Map<String, Object> claims = new HashMap<>();
	        claims.put("username", authentication.getName());
	        final String token = jwtTokenUtil.generateToken(claims);

	        // Return the token
	        return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body(token);
	    }

}
