package com.danish.ContactManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins="*",allowedHeaders = "*")
public class Controller {

	
	@Autowired
	public DaoService dao;
	
	@GetMapping("getAllContacts")
	public ResponseEntity<List<Contact>> getAllContacs(){
		
		List<Contact> allContacts =	dao.getAllContacts();
		return new ResponseEntity<List<Contact>>(allContacts, HttpStatus.CREATED);
	}
	
	@PostMapping("saveContact")
	public ResponseEntity saveContact(@RequestBody  Contact contact){
		
		
		dao.saveContact(contact);
		return new ResponseEntity(HttpStatus.CREATED);
		
	}
}
