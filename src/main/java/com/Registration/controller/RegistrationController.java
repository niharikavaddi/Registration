package com.Registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.NotAcceptable;
import com.Registration.exception.DataNotUnique;
import com.Registration.model.Admin;
import com.Registration.model.Donor;
import com.Registration.model.Requestor;
import com.Registration.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RegistrationController {

	@Autowired
	private RegistrationService service;

	@PostMapping(value = "/createrequestor")
	public ResponseEntity<Requestor> createRequestor(@RequestBody Requestor requestor) throws DataNotUnique {

		try {
			log.info("Requestor added");
			return new ResponseEntity<Requestor>(service.createRequestor(requestor), HttpStatus.OK);
		} catch (NotAcceptable ex) {
			throw new DataNotUnique();
		}
	}

	@PostMapping(value = "/createdonor")
	public ResponseEntity<Donor> createDonor(@RequestBody Donor donor) throws DataNotUnique {
		try {
			log.info("Donor added");
			return new ResponseEntity<Donor>(service.createDonor(donor), HttpStatus.OK);
		} catch (NotAcceptable ex) {
			throw new DataNotUnique();
		}
	}

	@PostMapping(value = "/createadmin")
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) throws DataNotUnique {
		try {
			log.info("Admin added");
			return new ResponseEntity<Admin>(service.createAdmin(admin), HttpStatus.OK);
		} catch (NotAcceptable ex) {
			throw new DataNotUnique();
		}
	}

}
