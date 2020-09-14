package com.danish.ContactManagementSystem;

import java.util.List;
public interface DaoService {

	public int saveContact(Contact contact);
	public Contact getContact(long id);
	public List<Contact> getAllContacts();
}
