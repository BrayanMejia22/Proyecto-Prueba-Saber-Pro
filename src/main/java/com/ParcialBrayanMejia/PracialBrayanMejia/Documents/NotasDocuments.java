package com.ParcialBrayanMejia.PracialBrayanMejia.Documents;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "notas")
public class NotasDocuments implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
    private String id;
    private int PuntajeTotal;
    private String nivel1;
    private int ComunicacionEscrita;
    private String nivel2;
    private int RazonamientoCuantitativo;
    private String nivel3;
    private int LecturaCritica;
    private String nivel4;
    private int CompetenciaCiudadana;
    private String nivel5;
    private int Ingles;
    private String nivel6;
    private int FormulacionProyectos;
    private String nivel7;
    private int PensamientoCientificoMatematico;
    private String nivel8;
    private int DisenoSoftware;
    private String nivel9;
    private String nivel10;

    @DocumentReference
    private EstudianteDocuments estudiante;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPuntajeTotal() {
		return PuntajeTotal;
	}

	public void setPuntajeTotal(int puntajeTotal) {
		PuntajeTotal = puntajeTotal;
	}

	public String getNivel1() {
		return nivel1;
	}

	public void setNivel1(String nivel1) {
		this.nivel1 = nivel1;
	}

	public int getComunicacionEscrita() {
		return ComunicacionEscrita;
	}

	public void setComunicacionEscrita(int comunicacionEscrita) {
		ComunicacionEscrita = comunicacionEscrita;
	}

	public String getNivel2() {
		return nivel2;
	}

	public void setNivel2(String nivel2) {
		this.nivel2 = nivel2;
	}

	public int getRazonamientoCuantitativo() {
		return RazonamientoCuantitativo;
	}

	public void setRazonamientoCuantitativo(int razonamientoCuantitativo) {
		RazonamientoCuantitativo = razonamientoCuantitativo;
	}

	public String getNivel3() {
		return nivel3;
	}

	public void setNivel3(String nivel3) {
		this.nivel3 = nivel3;
	}

	public int getLecturaCritica() {
		return LecturaCritica;
	}

	public void setLecturaCritica(int lecturaCritica) {
		LecturaCritica = lecturaCritica;
	}

	public String getNivel4() {
		return nivel4;
	}

	public void setNivel4(String nivel4) {
		this.nivel4 = nivel4;
	}

	public int getCompetenciaCiudadana() {
		return CompetenciaCiudadana;
	}

	public void setCompetenciaCiudadana(int competenciaCiudadana) {
		CompetenciaCiudadana = competenciaCiudadana;
	}

	public String getNivel5() {
		return nivel5;
	}

	public void setNivel5(String nivel5) {
		this.nivel5 = nivel5;
	}

	public int getIngles() {
		return Ingles;
	}

	public void setIngles(int ingles) {
		Ingles = ingles;
	}

	public String getNivel6() {
		return nivel6;
	}

	public void setNivel6(String nivel6) {
		this.nivel6 = nivel6;
	}

	public int getFormulacionProyectos() {
		return FormulacionProyectos;
	}

	public void setFormulacionProyectos(int formulacionProyectos) {
		FormulacionProyectos = formulacionProyectos;
	}

	public String getNivel7() {
		return nivel7;
	}

	public void setNivel7(String nivel7) {
		this.nivel7 = nivel7;
	}

	public int getPensamientoCientificoMatematico() {
		return PensamientoCientificoMatematico;
	}

	public void setPensamientoCientificoMatematico(int pensamientoCientificoMatematico) {
		PensamientoCientificoMatematico = pensamientoCientificoMatematico;
	}

	public String getNivel8() {
		return nivel8;
	}

	public void setNivel8(String nivel8) {
		this.nivel8 = nivel8;
	}

	public int getDisenoSoftware() {
		return DisenoSoftware;
	}

	public void setDisenoSoftware(int disenoSoftware) {
		DisenoSoftware = disenoSoftware;
	}

	public String getNivel9() {
		return nivel9;
	}

	public void setNivel9(String nivel9) {
		this.nivel9 = nivel9;
	}

	public String getNivel10() {
		return nivel10;
	}

	public void setNivel10(String nivel10) {
		this.nivel10 = nivel10;
	}

	public EstudianteDocuments getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(EstudianteDocuments estudiante) {
		this.estudiante = estudiante;
	}
}
