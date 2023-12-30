package com.ParcialBrayanMejia.PracialBrayanMejia.ControllerWeb;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ParcialBrayanMejia.PracialBrayanMejia.Documents.CoordinadorDocuments;
import com.ParcialBrayanMejia.PracialBrayanMejia.NotFundException.NotFundException;
import com.ParcialBrayanMejia.PracialBrayanMejia.Repository.CoordinadorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("coordinador")
public class CoordinadorWeb {

    @Autowired
    private CoordinadorRepository coordinadorRepository;

    @GetMapping("/")
    public List<CoordinadorDocuments> findAll(){
        return coordinadorRepository.findAll();
    }

    @GetMapping("/{id}")
    public CoordinadorDocuments findById(@PathVariable String id){
        return coordinadorRepository.findById(id).orElseThrow(() -> new NotFundException("COORDINADOR NO ENCONTRADA"));
    }

    @PostMapping("/")
    public CoordinadorDocuments save(@RequestBody Map<String, Object> body){
        ObjectMapper mapper = new ObjectMapper();
        CoordinadorDocuments coordinador = mapper.convertValue(body,CoordinadorDocuments.class);
        return coordinadorRepository.save(coordinador);
    }

    @PostMapping("/{id}")
    public CoordinadorDocuments update(@PathVariable String id, CoordinadorDocuments coordinador){
        coordinador.setId(id);
        return coordinadorRepository.save(coordinador);
    }

    @DeleteMapping("/{id}")
    public CoordinadorDocuments delete(@PathVariable String id){
        CoordinadorDocuments coordinador = coordinadorRepository.findById(id).orElseThrow(() -> new NotFundException("COORDINADOR NO ENCONTRADA"));
        return coordinador;
    }
}
