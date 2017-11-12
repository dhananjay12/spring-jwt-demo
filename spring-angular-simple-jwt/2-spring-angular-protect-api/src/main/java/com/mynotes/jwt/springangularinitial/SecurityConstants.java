package com.mynotes.jwt.springangularinitial;

public class SecurityConstants {

  public static final long EXPIRATIONTIME = 86400000; // 24 hrs
  public static final String SECRET = "ThisIsASecret";
  public static final String TOKEN_PREFIX = "Bearer";
  public static final String HEADER_STRING = "Authorization";
}
