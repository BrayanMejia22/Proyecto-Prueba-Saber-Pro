package com.ParcialBrayanMejia.PracialBrayanMejia.Documents;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "coordinador")
public class CoordinadorDocuments {

    @Id
    private String id;
    private String usuario;
    private String contraseña;

    @DocumentReference
    private List<NotasDocuments> notas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public List<NotasDocuments> getNotas() {
        return notas;
    }

    public void setNotas(List<NotasDocuments> notas) {
        this.notas = notas;
    }    
}
