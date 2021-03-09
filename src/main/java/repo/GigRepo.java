package repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Gig;

@Repository
public interface GigRepo extends JpaRepository<Gig, Long>{
	Gig findByArtist(String artist);
	//Gig findById(Long id);
}


