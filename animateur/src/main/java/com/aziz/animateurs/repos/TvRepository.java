package com.aziz.animateurs.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.aziz.animateurs.entities.Tv;

@RepositoryRestResource(path = "tv")
@CrossOrigin(origins="http://localhost:4200/")
@Repository
	public interface TvRepository extends JpaRepository<Tv, Long> {
		
	}


