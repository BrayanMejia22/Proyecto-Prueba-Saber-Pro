package com.ParcialBrayanMejia.PracialBrayanMejia.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ParcialBrayanMejia.PracialBrayanMejia.Documents.EstudianteDocuments;

public interface EstudianteRepository extends MongoRepository<EstudianteDocuments, String> {
	EstudianteDocuments findByUsuario(String usuario);
}
