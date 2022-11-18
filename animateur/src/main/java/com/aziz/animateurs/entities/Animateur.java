package com.aziz.animateurs.entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.springframework.format.annotation.DateTimeFormat;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
@Entity
public class Animateur {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idAnimateur;

@NotNull

private String nomAnimateur;





@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")

private Date dateConfirmation;

@ManyToOne
private Tv tv;
public Animateur() {
super();
}
public Animateur(String nomAnimateur, Date dateConfirmation) {
super();
this.nomAnimateur = nomAnimateur;

this.dateConfirmation = dateConfirmation;
}


public Long getIdAnimateur() {
	return idAnimateur;
}
public void setIdAnimateur(Long idAnimateur) {
	this.idAnimateur = idAnimateur;
}
public String getNomAnimateur() {
	return nomAnimateur;
}
public void setNomAnimateur(String nomAnimateur) {
	this.nomAnimateur = nomAnimateur;
}
public Date getDateConfirmation() {
	return dateConfirmation;
}
public void setDateConfirmation(Date dateConfirmation) {
	this.dateConfirmation = dateConfirmation;
}


public Tv getTv() {
	return tv;
}
public void setTv(Tv tv) {
	this.tv = tv;
}
@Override
public String toString() {
	return "animateur [idAnimateur=" + idAnimateur + ", nomAnimateur=" + nomAnimateur + ", dateConfirmation="
			+ dateConfirmation + ", tv=" + tv + "]";
}

}
