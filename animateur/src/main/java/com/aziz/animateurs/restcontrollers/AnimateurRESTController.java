package com.aziz.animateurs.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aziz.animateurs.entities.Animateur;
import com.aziz.animateurs.service.AnimateurService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class AnimateurRESTController {
@Autowired
AnimateurService animateurService;
@RequestMapping(method = RequestMethod.GET)
public List<Animateur> getAllAnimateurs() {
return animateurService.getAllAnimateurs();
}
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Animateur getAnimateurById(@PathVariable("id") Long id) {
return animateurService.getAnimateur(id);
 }
@RequestMapping(method = RequestMethod.POST)
public Animateur createAnimateur(@RequestBody Animateur animateur) {
return animateurService.saveAnimateur(animateur);
}

@RequestMapping(method = RequestMethod.PUT)
public Animateur updateAnimateur(@RequestBody Animateur animateur) {
return animateurService.updateAnimateur(animateur);
}
@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deleteAnimateur(@PathVariable("id") Long id)
{
animateurService.deleteAnimateurById(id);
}
@RequestMapping(value="/animtv/{idTv}",method = RequestMethod.GET)
public List<Animateur> getAnimateursByTvId(@PathVariable("idTv") Long idTv) {
return animateurService.findByTvIdTv(idTv);
}
@RequestMapping(value="/animsByName/{nom}",method = RequestMethod.GET)
public List<Animateur> findByNomProduitContains(@PathVariable("nom") String nom) {
return animateurService.findByNomAnimateurContains(nom);
}

}
