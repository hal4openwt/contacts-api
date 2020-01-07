package fr.hildenbrand.contactapi.dbaccess;

import org.springframework.data.repository.CrudRepository;

import fr.hildenbrand.contactapi.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long>{

}
