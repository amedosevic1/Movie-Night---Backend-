package ba.epbih.praksafilm.domena;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="Filmovi")
public class Film {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String naziv;
	private int godina;
	private String zanr;
	private int ocjena;
	
	@ManyToMany
	@JoinTable(
			  name = "filmovi_glumci", 
			  joinColumns = @JoinColumn(name = "film_id"), 
			  inverseJoinColumns = @JoinColumn(name = "glumac_id"))
	private List<Glumac> glumci;
	
	
	@Override
	public String toString() {
		return "Film [id=" + id + ", naziv=" + naziv + ", godina=" + godina + ", zanr=" + zanr + ", ocjena=" + ocjena
				+ ", glumci=" + glumci + "]";
	}

	public Film(Integer id, String naziv, int godina, String zanr, List<Glumac> glumci, int ocjena) {
		this.id = id;
		this.naziv = naziv;
		this.godina = godina;
		this.zanr = zanr;
		this.glumci = glumci;
		this.ocjena = ocjena;
	}
	
	public int getOcjena() {
		return ocjena;
	}

	public void setOcjena(int ocjena) {
		this.ocjena = ocjena;
	}

	public List<Glumac> getGlumci() {
		return glumci;
	}
	public void setGlumci(List<Glumac> glumci) {
		this.glumci = glumci;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getGodina() {
		return godina;
	}
	public void setGodina(int godina) {
		this.godina = godina;
	}
	public String getZanr() {
		return zanr;
	}
	public void setZanr(String zanr) {
		this.zanr = zanr;
	}
	
	
	public Film() {
		
	}
	
	
	
}
