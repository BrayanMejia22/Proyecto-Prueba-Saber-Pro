package com.ParcialBrayanMejia.PracialBrayanMejia.Documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "login")
public class LoginDocuments {
    
    @Id
    private String id;
    private String rol;
    private String usuario;
    private String contraseña;  
    
    @DocumentReference
    private EstudianteDocuments estudiante;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
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

	public EstudianteDocuments getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(EstudianteDocuments estudiante) {
		this.estudiante = estudiante;
	}	
}
