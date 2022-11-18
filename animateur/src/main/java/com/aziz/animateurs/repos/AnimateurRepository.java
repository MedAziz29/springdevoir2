package com.aziz.animateurs.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.aziz.animateurs.entities.Tv;
import com.aziz.animateurs.entities.Animateur;
@RepositoryRestResource(path = "rest")
public interface AnimateurRepository extends JpaRepository<Animateur, Long> {
	List<Animateur> findByNomAnimateur(String nom);
	 List<Animateur> findByNomAnimateurContains(String nom);
	
	 @Query("select a from Animateur a where a.tv = ?1")
	 List<Animateur> findByTv (Tv Tv);
	 List<Animateur> findByTvIdTv(Long id);
	 List<Animateur> findByOrderByNomAnimateurAsc();

}