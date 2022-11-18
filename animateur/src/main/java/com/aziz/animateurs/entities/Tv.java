package com.aziz.animateurs.entities;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@Entity
public class Tv {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idTv;
private String nomTv;
private String descriptionTv;
@JsonIgnore
@OneToMany(mappedBy = "tv")
private List<Animateur> animateurs;
public Tv() {}
public Tv(String nomTv, String descriptionTV, List<Animateur> animateurs) 
{
super();
this.nomTv = nomTv;
this.descriptionTv = descriptionTV;
this.animateurs = animateurs;
}
public Long getIdTv() {
return idTv;
}
public void setIdTv(Long idTv) {
this.idTv = idTv;
}
public String getNomTv() {
return nomTv;
}
public void setNomTv(String nomTv) {
this.nomTv = nomTv;
}
public String getDescriptionTv() {
return descriptionTv;
}
public void setDescriptionCat(String descriptionCat) {
this.descriptionTv = descriptionTv;
}
public List<Animateur> getAnimateurs() {
return animateurs;
}
public void setAnimateurs(List<Animateur> animateurs) {
this.animateurs = animateurs;
}
@Override
public String toString() {
	return "tv [idCat=" + idTv + ", nomCat=" + nomTv + ", descriptionCat=" + descriptionTv + "]";
}
}