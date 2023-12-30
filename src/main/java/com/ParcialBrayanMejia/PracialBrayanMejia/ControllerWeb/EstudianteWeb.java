package com.ParcialBrayanMejia.PracialBrayanMejia.ControllerWeb;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ParcialBrayanMejia.PracialBrayanMejia.Documents.EstudianteDocuments;
import com.ParcialBrayanMejia.PracialBrayanMejia.NotFundException.NotFundException;
import com.ParcialBrayanMejia.PracialBrayanMejia.Repository.EstudianteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("estudiantes")
public class EstudianteWeb {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @GetMapping("/")
    public List<EstudianteDocuments> findAll() {
        return estudianteRepository.findAll();
    }

    @GetMapping("/{id}")
    public EstudianteDocuments findById(@PathVariable String id) {
        return estudianteRepository.findById(id).orElseThrow(() -> new NotFundException("ESTUDIANTE NO ENCONTRADO"));
    }

    @PostMapping("/")
    public EstudianteDocuments save(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        EstudianteDocuments estudiante = mapper.convertValue(body, EstudianteDocuments.class);
        return estudianteRepository.save(estudiante);
    }

    @PostMapping("/{id}")
    public EstudianteDocuments update(@PathVariable String id, EstudianteDocuments estudiante){
        estudiante.setId(id);
        return estudianteRepository.save(estudiante);
    }

    @DeleteMapping("/{id}")
    public EstudianteDocuments delete(@PathVariable String id){
        EstudianteDocuments estudiante = estudianteRepository.findById(id).orElseThrow(() -> new NotFundException("ESTUDIANTE NO ENCONTRADO"));
        estudianteRepository.deleteById(id);
        return estudiante;
    }
}
