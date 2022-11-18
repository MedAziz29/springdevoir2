package com.aziz.animateurs.entities;

import org.springframework.data.rest.core.config.Projection;
@Projection(name = "nomAnimateur", types = { Animateur.class })
public interface AnimateurProjection {
public String getNomAnimateur();
}