package com.fdm.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.fdm.demo.contact.Contact;
import com.fdm.demo.contact.ContactInfo;
import com.fdm.demo.contact.ContactService;
import com.fdm.demo.contact.InfoType;

@SpringBootApplication
public class SpringDemo1Application implements CommandLineRunner {

	ApplicationContext appContext;

	public SpringDemo1Application(ApplicationContext appContext) {
		super();
		this.appContext = appContext;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDemo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ContactService contactService = appContext.getBean(ContactService.class);
		List<ContactInfo> johnsContactInfo = new ArrayList<>();
		Contact johnContact = new Contact("John Wick", johnsContactInfo);
		johnsContactInfo.add(new ContactInfo(0L, "+1234567890", InfoType.CELL_PHONE, johnContact));

		Optional<Contact> createdContactJohn = contactService.createContact(johnContact);

		if (createdContactJohn.isPresent()) {
			System.out.println("\n\nsyso createdContactJohn: \n\t" + createdContactJohn);
		}

		List<Contact> allContacts = contactService.getAll();
		System.out.println("\nallContacts:\n\n" + allContacts);

		System.out.println("\n\nsyso contactService.readContactById(johnContact.getId()):\n\t"
				+ contactService.readContactById(johnContact.getId()));

		// More beans @Scope prototype demo coming up.
		Contact fdmContact = appContext.getBean("fdmContact", Contact.class);
		System.out.println("fdmContact: \n\t" + fdmContact);

		Contact fdmContactUsa = appContext.getBean("fdmContact", Contact.class);
		System.out.println("fdmContactUsa: \n\t" + fdmContactUsa);
		
		fdmContactUsa.setName("FDM USA");
		System.out.println("\n\nExecute: fdmContactUsa.setName(\"FDM USA\");");
		System.out.println("fdmContact: \n\t" + fdmContact);
		System.out.println("fdmContactUsa: \n\t" + fdmContactUsa);
		
		Contact fdmContactByName = appContext.getBean("fdmContact", Contact.class);

	}

}
