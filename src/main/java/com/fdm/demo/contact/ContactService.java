package com.fdm.demo.contact;

import java.util.List;
import java.util.Optional;

public class ContactService {
	private ContactRepository contactRepo;

	public ContactService(ContactRepository contactRepo) {
		super();
		this.contactRepo = contactRepo;
	}

	public Optional<Contact> createContact(Contact contact) {
		Optional<Contact> contactOpt = Optional.empty();
		if(!contactRepo.existsById(contact.getId())) {
			contactOpt = Optional.of(contactRepo.save(contact));
		}
		return contactOpt;
	}
	
	public Optional<Contact> readContactById(long id){
		return contactRepo.findById(id);
	}
//	List<T> findAll();
	public List<Contact> getAll() {
		return contactRepo.findAll();
	}
}
