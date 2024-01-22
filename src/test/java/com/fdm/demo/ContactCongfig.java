package com.fdm.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fdm.demo.contact.ContactRepository;
import com.fdm.demo.contact.ContactService;

@Configuration
public class ContactCongfig {

	@Bean
	ContactService contactService(ContactRepository contactRepo) {
		return new ContactService(contactRepo);
	}
	
	
}
