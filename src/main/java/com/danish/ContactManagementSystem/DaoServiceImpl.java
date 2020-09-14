package com.danish.ContactManagementSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DaoServiceImpl implements DaoService {

	@Autowired
	JdbcTemplate jdbcTemplate ;
	public int saveContact(Contact contact) {
		// TODO Auto-generated method stub
		
		int count = jdbcTemplate.update("insert into contact (name,company,phone,address,email,dateContacted,jobTitle,comments) values"
				+ "(?,?,?,?,?,?,?,?)", contact.getName(), contact.getCompany(),contact.getPhone(),
				contact.getAddress(),contact.getEmail(),contact.getDateContacted(),contact.getJobTitle(),contact.getComments());
		
		
		return count;
	}

	public Contact getContact(long id) {
		// TODO Auto-generated method stub
		return (Contact)jdbcTemplate.query("select * from contact where id=" + id, new BeanPropertyRowMapper(Contact.class));
		
	}

	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		List<Contact> contactList = (List<Contact>) jdbcTemplate.query("select * from contact", new BeanPropertyRowMapper(Contact.class));
		return contactList;
	}

}
