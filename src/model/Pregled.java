package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the pregled database table.
 * 
 */
@Entity
@NamedQuery(name="Pregled.findAll", query="SELECT p FROM Pregled p")
public class Pregled implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPregled;

	@Temporal(TemporalType.TIMESTAMP)
	private Date vremeDo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date vremeOd;

	private int zauzet;

	//bi-directional many-to-one association to Veterinar
	@ManyToOne
	private Veterinar veterinar;

	//bi-directional many-to-one association to Usluga
	@ManyToOne
	private Usluga usluga;

	public Pregled() {
	}

	public int getIdPregled() {
		return this.idPregled;
	}

	public void setIdPregled(int idPregled) {
		this.idPregled = idPregled;
	}

	public Date getVremeDo() {
		return this.vremeDo;
	}

	public void setVremeDo(Date vremeDo) {
		this.vremeDo = vremeDo;
	}

	public Date getVremeOd() {
		return this.vremeOd;
	}

	public void setVremeOd(Date vremeOd) {
		this.vremeOd = vremeOd;
	}

	public int getZauzet() {
		return this.zauzet;
	}

	public void setZauzet(int zauzet) {
		this.zauzet = zauzet;
	}

	public Veterinar getVeterinar() {
		return this.veterinar;
	}

	public void setVeterinar(Veterinar veterinar) {
		this.veterinar = veterinar;
	}

	public Usluga getUsluga() {
		return this.usluga;
	}

	public void setUsluga(Usluga usluga) {
		this.usluga = usluga;
	}
/*
	@Override
	public String toString() {
		return "Pregled [vremeDo=" + vremeDo + ", vremeOd=" + vremeOd + "]";
	}*/

	@Override
	public String toString() {
		return "Pregled [idPregled=" + idPregled + ", vremeDo=" + vremeDo + ", vremeOd=" + vremeOd + ", zauzet="
				+ zauzet    +", usluga=" + usluga + "]";
	}


	

}