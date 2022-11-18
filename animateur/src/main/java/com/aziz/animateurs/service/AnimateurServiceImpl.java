package com.aziz.animateurs.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aziz.animateurs.entities.Animateur;
import com.aziz.animateurs.entities.Tv;
import com.aziz.animateurs.repos.AnimateurRepository;


@Service
public class AnimateurServiceImpl implements AnimateurService {
@Autowired
AnimateurRepository animateurRepository;
@Override
public Animateur saveAnimateur(Animateur p) {
	return animateurRepository.save(p);
	}
	@Override
	public Animateur updateAnimateur(Animateur p) {
	return animateurRepository.save(p);
	}
	@Override
	public void deleteAnimateur(Animateur p) {
	animateurRepository.delete(p);
	}
	 @Override
	public void deleteAnimateurById(Long id) {
	animateurRepository.deleteById(id);
	}
	@Override
	public Animateur getAnimateur(Long id) {
	return animateurRepository.findById(id).get();
	}
	@Override
	public List<Animateur> getAllAnimateurs() {
	return animateurRepository.findAll();
	}
	@Override
	public Page<Animateur> getAllAnimateursParPage(int page, int size) {
		return animateurRepository.findAll(PageRequest.of(page, size));

	}
	public List<Animateur> findByNomAnimateur(String nom) {
		return animateurRepository.findByNomAnimateur(nom);
		}
	@Override
	public List<Animateur> findByTv(Tv Tv) {
	
		return animateurRepository.findByTv (Tv);
	}
	@Override
	public List<Animateur> findByTvIdTv(Long id) {
		// TODO Auto-generated method stub
			return animateurRepository.findByTvIdTv(id);
	}
	@Override
	public List<Animateur> findByOrderByNomAnimateurAsc() {
		return animateurRepository.findByOrderByNomAnimateurAsc();
	}
	
	
	@Override
	public List<Animateur> findByNomAnimateurContains(String nom) {
	return animateurRepository.findByNomAnimateurContains(nom);
	}

	
}