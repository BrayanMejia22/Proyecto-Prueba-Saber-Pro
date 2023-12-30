package com.ParcialBrayanMejia.PracialBrayanMejia.Documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "estudiante")
public class EstudianteDocuments {

    @Id
    private String id;
    private String usuario;
    private String contraseña; 
    private String TipoDocumento;
    private String NumeroDocumento;
    private String PrimerApellido;
    private String SegundoApellido;
    private String PrimerNombre;
    private String SegundoNombre;
    private String CorreoElectronico;
    private String NumeroTelefono;
    private String NumeroRegistro;       
    private int Puntaje;
    private boolean notasVistas;
  

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

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        TipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return NumeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        NumeroDocumento = numeroDocumento;
    }

    public String getPrimerApellido() {
        return PrimerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        PrimerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return SegundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        SegundoApellido = segundoApellido;
    }

    public String getPrimerNombre() {
        return PrimerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        PrimerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return SegundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        SegundoNombre = segundoNombre;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        CorreoElectronico = correoElectronico;
    }

    public String getNumeroTelefono() {
        return NumeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        NumeroTelefono = numeroTelefono;
    }

    public String getNumeroRegistro() {
        return NumeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        NumeroRegistro = numeroRegistro;
    }

	public int getPuntaje() {
		return Puntaje;
	}

	public void setPuntaje(int puntajeTotal) {
		Puntaje = puntajeTotal;
	}

	public boolean isNotasVistas() {
		return notasVistas;
	}

	public void setNotasVistas(boolean notasVistas) {
		this.notasVistas = notasVistas;
	}	
}
