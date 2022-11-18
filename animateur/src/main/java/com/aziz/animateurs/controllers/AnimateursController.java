package com.aziz.animateurs.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aziz.animateurs.entities.Animateur;
import com.aziz.animateurs.service.AnimateurService;
@Controller
public class AnimateursController {
@Autowired
AnimateurService animateurService;
@RequestMapping("/showCreate")
public String showCreate()
{
return "createAnimateur";
}
@RequestMapping("/saveAnimateur")
public String saveProduit(@ModelAttribute("animateur") Animateur animateur, 
 @RequestParam("date") String date,
 ModelMap modelMap) throws
ParseException 
{
//conversion de la date 
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateConfirmation = dateformat.parse(String.valueOf(date));
 animateur.setDateConfirmation(dateConfirmation);
 
Animateur saveAnimateur = animateurService.saveAnimateur(animateur);
String msg ="animateur enregistré avec Id "+saveAnimateur.getIdAnimateur();
modelMap.addAttribute("msg", msg);
return "createAnimateur";
}
@RequestMapping("/ListeAnimateur")
public String listeAnimateurs(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
Page<Animateur> anims = animateurService.getAllAnimateursParPage(page, size);
modelMap.addAttribute("animateurs", anims);
 modelMap.addAttribute("pages", new int[anims.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listeAnimateurs";
}
@RequestMapping("/supprimerAnimateur")
public String supprimerAnimateur(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
animateurService.deleteAnimateurById(id);
Page<Animateur> anims = animateurService.getAllAnimateursParPage(page, 
size);
modelMap.addAttribute("animateurs", anims);
modelMap.addAttribute("pages", new int[anims.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "listeAnimateurs";
}
@RequestMapping("/modifierAnimateur")
public String editerAnimateur(@RequestParam("id") Long id,ModelMap modelMap)
{
Animateur a= animateurService.getAnimateur(id);
modelMap.addAttribute("animateur", a);
return "editerAnimateur";
}
@RequestMapping("/updateAnimateur")
public String updateAnimateur(@ModelAttribute("animateur") Animateur animateur,
@RequestParam("date") String date,ModelMap modelMap) throws ParseException {
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateConfirmation = dateformat.parse(String.valueOf(date));
	 animateur.setDateConfirmation(dateConfirmation);
	 
	 animateurService.updateAnimateur(animateur);
	 List<Animateur> anims = animateurService.getAllAnimateurs();
	 modelMap.addAttribute("animateurs", anims);
	return "listeAnimateurs";
	}

}