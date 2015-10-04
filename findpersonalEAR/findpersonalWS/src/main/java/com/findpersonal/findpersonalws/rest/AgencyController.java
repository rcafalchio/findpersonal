package com.findpersonal.findpersonalws.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgencyController {

    
    @RequestMapping(value = "/agencies", method = RequestMethod.POST)
    public ResponseEntity<AgencyResource> saveAgency(
            @Validated @RequestBody AgencyResource agencyResource) {

        System.out.println(agencyResource.getName());

        //save to DB or ?

        return new ResponseEntity<AgencyResource>(agencyResource, HttpStatus.OK);
    }
	
}
