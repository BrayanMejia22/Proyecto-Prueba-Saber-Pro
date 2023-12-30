package com.ParcialBrayanMejia.PracialBrayanMejia.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ParcialBrayanMejia.PracialBrayanMejia.Documents.CoordinadorDocuments;

public interface CoordinadorRepository extends MongoRepository<CoordinadorDocuments, String> {
    CoordinadorDocuments findByUsuario(String usuario);    
}
