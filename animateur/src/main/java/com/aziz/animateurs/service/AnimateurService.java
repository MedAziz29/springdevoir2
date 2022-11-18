package com.aziz.animateurs.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.aziz.animateurs.entities.Animateur;
import com.aziz.animateurs.entities.Tv;

public interface AnimateurService {
Animateur saveAnimateur(Animateur p);
Animateur updateAnimateur(Animateur p);
void deleteAnimateur(Animateur p);
 void deleteAnimateurById(Long id);
Animateur getAnimateur(Long id);
List<Animateur> getAllAnimateurs();
Page<Animateur> getAllAnimateursParPage(int page, int size);
List<Animateur> findByNomAnimateur(String nom);
List<Animateur> findByTv (Tv Tv);
List<Animateur> findByTvIdTv(Long id);
List<Animateur> findByOrderByNomAnimateurAsc();
List<Animateur> findByNomAnimateurContains(String nom);

}