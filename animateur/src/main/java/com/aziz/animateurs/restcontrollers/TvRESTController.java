package com.aziz.animateurs.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.aziz.animateurs.entities.Tv;
import com.aziz.animateurs.repos.TvRepository;
@RestController
@RequestMapping("/api/tv")
@CrossOrigin("*")
public class TvRESTController {
@Autowired
TvRepository TvRepository;
@RequestMapping(method=RequestMethod.GET)
public List<Tv> getAllTv()
{
return TvRepository.findAll();
}
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Tv getTVById(@PathVariable("id") Long id) {
return TvRepository.findById(id).get();
}
}



