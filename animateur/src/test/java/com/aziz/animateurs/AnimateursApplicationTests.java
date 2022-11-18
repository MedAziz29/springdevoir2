package com.aziz.animateurs;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.aziz.animateurs.entities.Animateur;
import com.aziz.animateurs.entities.Tv;
import com.aziz.animateurs.repos.AnimateurRepository;
import com.aziz.animateurs.service.AnimateurService;
@SpringBootTest
class AnimateursApplicationTests {
@Autowired
private AnimateurRepository animateurRepository;

@Autowired
private AnimateurService animateurService;

@Test
public void testCreateAnimateur() {
Animateur animateur = new Animateur("naoufel ouertani",new Date());
animateurRepository.save(animateur);
}
@Test
public void testFindAnimateur()
{
Animateur p = animateurRepository.findById(1L).get(); 
System.out.println(p);
}
@Test
public void testUpdateAnimateur()
{
Animateur a = animateurRepository.findById(1L).get();
a.setNomAnimateur("Hedi Zaiem");
animateurRepository.save(a);
}
@Test
public void testDeleteAnimateur()
{
animateurRepository.deleteById(1L);;
}
 
@Test
public void testListerTousAnimateurs()
{
List<Animateur> anims = animateurRepository.findAll();
for (Animateur a : anims)
{
System.out.println(a);
}
}
@Test
public void testFindByNomAnimateurContains()
{
Page<Animateur> anims = animateurService.getAllAnimateursParPage(0,2);
System.out.println(anims.getSize());
System.out.println(anims.getTotalElements());
System.out.println(anims.getTotalPages());
anims.getContent().forEach(p -> {System.out.println(p.toString());
 });
/*ou bien
for (Produit p : prods.getContent()
{
System.out.println(p);
} */
}
@Test
public void testFindByNomAnimateur()
{
List<Animateur> anims = animateurRepository.findByNomAnimateur("Hedi");
for (Animateur a: anims)
{
System.out.println(a);
}
}
@Test
public void findByNomAnimateurContains()
{
List<Animateur> anims=animateurRepository.findByNomAnimateurContains("a");
for (Animateur a : anims)
{
System.out.println(a);
} }


@Test
public void testfindByTv()
{
Tv tv = new Tv();
tv.setIdTv(1L);
List<Animateur> anims= animateurRepository.findByTv(tv);
for (Animateur a : anims)
{
System.out.println(a);
}
}
@Test
public void findByTvIdTv()
{
List<Animateur> anims = animateurRepository.findByTvIdTv(1L);
for (Animateur a : anims)
{
System.out.println(a);
}
 }
@Test
public void testfindByOrderByNomProduitAsc()
{
List<Animateur> anims = 
animateurRepository.findByOrderByNomAnimateurAsc();
for (Animateur a : anims)
{
System.out.println(a);
}
}

}
