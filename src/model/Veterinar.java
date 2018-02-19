package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the veterinar database table.
 * 
 */
@Entity
@NamedQuery(name="Veterinar.findAll", query="SELECT v FROM Veterinar v")
public class Veterinar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVeterinar;

	private String ime;

	private String prezime;

	private String telefon;

	//bi-directional many-to-one association to Pregled
	@OneToMany(mappedBy="veterinar")
	private List<Pregled> pregleds;

	public Veterinar() {
	}

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdVeterinar() {
		return this.idVeterinar;
	}

	public void setIdVeterinar(int idVeterinar) {
		this.idVeterinar = idVeterinar;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public List<Pregled> getPregleds() {
		return this.pregleds;
	}

	public void setPregleds(List<Pregled> pregleds) {
		this.pregleds = pregleds;
	}

	public Pregled addPregled(Pregled pregled) {
		getPregleds().add(pregled);
		pregled.setVeterinar(this);

		return pregled;
	}

	public Pregled removePregled(Pregled pregled) {
		getPregleds().remove(pregled);
		pregled.setVeterinar(null);

		return pregled;
	}

	@Override
	public String toString() {
		return "Veterinar [idVeterinar=" + idVeterinar + ", ime=" + ime + ", prezime=" + prezime + ", telefon="
				+ telefon + ", pregleds=" + pregleds + "]";
	}

 

	

}