package ba.epbih.praksafilm.pristup;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ba.epbih.praksafilm.domena.Film;
import ba.epbih.praksafilm.domena.Glumac;

@CrossOrigin(origins = "*")
@RestController
public class FilmoviController {

	@Autowired
	private FilmoviReposotory filmoviReposotory;
	@Autowired
	private GlumciReposotory glumciReposotory; 
	
	
	@GetMapping("/filmovi") 
	public Iterable<Film> getAllFilmoviByGlumac() {
		return filmoviReposotory.findAllByOrderByIdDesc();
	}
	
	@GetMapping("/filmovi/{id}")
	public Film getOneFilm(@PathVariable Integer id) {
		return filmoviReposotory.findById(id).orElse(new Film());
	}
	
	@DeleteMapping("/filmovi/{id}")
	public void deleteFilm(@PathVariable Integer id) {
		filmoviReposotory.deleteById(id);
	}
	
	@PostMapping("/filmovi/dodaj")
	public void saveFilm(@RequestBody Film film) {
		Iterable<Glumac> actors = glumciReposotory.saveAll(film.getGlumci());
		List<Glumac> glumci = new ArrayList<>();
		actors.forEach(glumci::add);
		film.setGlumci(glumci);
		filmoviReposotory.save(film);
	}
	
}
