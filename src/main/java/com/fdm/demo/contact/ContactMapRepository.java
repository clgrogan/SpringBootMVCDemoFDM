package com.fdm.demo.contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ContactMapRepository implements ContactRepository {

	private Map<Long, Contact> contacts;
	private long nextId;
		
	public ContactMapRepository(Map<Long, Contact> contacts) {
		super();
		this.contacts = contacts;
		this.nextId = contacts.keySet().stream().mapToLong(id -> id).max().orElse(1L);
	}
	
	public ContactMapRepository(Map<Long, Contact> contacts, long nextId) {
		super();
		this.contacts = contacts;
		this.nextId = nextId;
	}

	@Override
	public Contact save(Contact contact) {
		if(contact.getId() == 0) {
			contact.setId(nextId);
			nextId++;
			
		}
		contacts.put(contact.getId(), contact);
		return contact;
	}

	@Override
	public Optional<Contact> findById(Long id) {
		return Optional.ofNullable(contacts.get(id));
	}

	@Override
	public List<Contact> findAll() {
		return new ArrayList<>(contacts.values());
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

}
