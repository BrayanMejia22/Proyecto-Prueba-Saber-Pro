package com.ParcialBrayanMejia.PracialBrayanMejia.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ParcialBrayanMejia.PracialBrayanMejia.Documents.EstudianteDocuments;
import com.ParcialBrayanMejia.PracialBrayanMejia.Documents.NotasDocuments;

public interface NotasRepository extends MongoRepository <NotasDocuments, String>{

	List<NotasDocuments> findByEstudiante(EstudianteDocuments estudiante);

    
}
