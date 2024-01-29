package com.fdm.demo.config;

import java.util.Map;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.fdm.demo.contact.Contact;
import com.fdm.demo.contact.ContactInfo;
import com.fdm.demo.contact.ContactMapRepository;
import com.fdm.demo.contact.ContactRepository;
import com.fdm.demo.contact.ContactService;

@Configuration
public class ContactCongfig {

	@Bean
	ContactService contactService(ContactRepository contactRepo) {
		return new ContactService(contactRepo);
	}
	@Bean
	ContactMapRepository contactRepo(Map<Long, Contact> contacts) {
		return new ContactMapRepository(contacts);
	}
	
	@Bean("fdmContact")
	@Scope("prototype")
	Contact fdmGroup() {
		return new Contact("FDM Group", new ArrayList<ContactInfo>());
	}
	
	@Bean("genericContact")
	@Scope("prototype")
	Contact genericContact() {
		return new Contact("Contact Name", new ArrayList<ContactInfo>());
	}
	
	
}
