package com.ParcialBrayanMejia.PracialBrayanMejia.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ParcialBrayanMejia.PracialBrayanMejia.Documents.LoginDocuments;

public interface LoginRepositoty extends MongoRepository<LoginDocuments, String> {

	LoginDocuments findByUsuario(String usuario);	
}
