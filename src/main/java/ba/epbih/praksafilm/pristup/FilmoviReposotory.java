package ba.epbih.praksafilm.pristup;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import ba.epbih.praksafilm.domena.Film;


public interface FilmoviReposotory extends CrudRepository<Film, Integer> {
	
	public List<Film> findAllByOrderByIdDesc();

}
