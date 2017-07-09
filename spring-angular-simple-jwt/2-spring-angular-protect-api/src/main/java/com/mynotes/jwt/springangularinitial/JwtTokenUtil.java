package com.mynotes.jwt.springangularinitial;

import java.util.Date;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenUtil {
	
	static final long EXPIRATIONTIME = 86400000; // 24 hrs 
	  static final String SECRET = "ThisIsASecret";
	  static final String TOKEN_PREFIX = "Bearer";
	  static final String HEADER_STRING = "Authorization";
	  
	  String generateToken(Map<String, Object> claims) {
		  Date now=new Date();
		    String JWT = Jwts.builder()
		    		.setClaims(claims)
		        .setIssuedAt(now)
		        .setExpiration(new Date(now.getTime()+EXPIRATIONTIME))
		        .signWith(SignatureAlgorithm.HS512, SECRET)
		        .compact();
		    return JWT;
		  }

}
