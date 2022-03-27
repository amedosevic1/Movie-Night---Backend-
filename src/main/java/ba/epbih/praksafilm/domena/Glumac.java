package ba.epbih.praksafilm.domena;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Glumci")
public class Glumac {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String ime;
	private String prezime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	@Override
	public String toString() {
		return "Glumac [id=" + id + ", ime=" + ime + ", prezime=" + prezime + "]";
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public Glumac(Integer id, String ime, String prezime) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
	}
	
	public Glumac() {
	}
	
	
	
}
