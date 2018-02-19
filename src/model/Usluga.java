package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usluga database table.
 * 
 */
@Entity
@NamedQuery(name="Usluga.findAll", query="SELECT u FROM Usluga u")
public class Usluga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsluga;

	private int cena;

	private String naziv;

	//bi-directional many-to-one association to Pregled
	@OneToMany(mappedBy="usluga")
	private List<Pregled> pregleds;

	public Usluga() {
	}

	public int getIdUsluga() {
		return this.idUsluga;
	}

	public void setIdUsluga(int idUsluga) {
		this.idUsluga = idUsluga;
	}

	public int getCena() {
		return this.cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Pregled> getPregleds() {
		return this.pregleds;
	}

	public void setPregleds(List<Pregled> pregleds) {
		this.pregleds = pregleds;
	}

	public Pregled addPregled(Pregled pregled) {
		getPregleds().add(pregled);
		pregled.setUsluga(this);

		return pregled;
	}

	public Pregled removePregled(Pregled pregled) {
		getPregleds().remove(pregled);
		pregled.setUsluga(null);

		return pregled;
	}

	@Override
	public String toString() {
		return "Usluga [idUsluga=" + idUsluga + ", cena=" + cena + ", naziv=" + naziv  + "]";
	}

}