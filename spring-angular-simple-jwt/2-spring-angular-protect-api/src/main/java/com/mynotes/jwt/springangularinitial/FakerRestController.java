package com.mynotes.jwt.springangularinitial;

import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.company.Company;
import io.codearte.jfairy.producer.person.Address;
import io.codearte.jfairy.producer.person.Person;

@RestController
@RequestMapping(value = "/fake")
public class FakerRestController {

  ObjectMapper mapper = new ObjectMapper();

  @GetMapping(value = "/address")
  @RolesAllowed(value = "ROLE_ADMIN")
  public @ResponseBody Address getAddress() throws JsonProcessingException {
    Fairy fairy = Fairy.create();
    Person person = fairy.person();
    return person.getAddress();
  }

  @GetMapping(value = "/company")
  public @ResponseBody Company getCompany() throws JsonProcessingException {
    Fairy fairy = Fairy.create();
    Person person = fairy.person();
    return person.getCompany();
  }
}
