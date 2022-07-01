package jana60;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

	private String titolo;
	private LocalDate data;
	private int numPostiTot;
	private int numPostiPrenotati = 0;
	private LocalDate oggi = LocalDate.now();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Evento(String titolo, LocalDate data, int numPostiTot) throws Exception{
		super();
		this.titolo = titolo;
		this.data = data;
		this.numPostiTot = numPostiTot;
		validaData();
		validaPosti();
		prenota();
		disdici();
		dataFormattata();
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getNumPostiPrenotati() {
		return numPostiPrenotati;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getTitolo() {
		return titolo;
	}

	public int getNumPostiTot() {
		return numPostiTot;
	}
	
	public void validaData() throws Exception {
		if (oggi.isAfter(data)) {
			throw new Exception ("Non puoi prenotare un' evento nel passato, riprova.");
		}
	}
	
	public void validaPosti() throws Exception {
		if (numPostiTot < 0) {
			throw new Exception ("Inserire un numero positivo per la capienza");
		}
	}
	
	public int prenota() throws Exception {
		if (numPostiTot < 0 || oggi.isAfter(data)) {
			throw new Exception ("Non ci sono più posti disponibili oppure la data è stata superata.");
		}
		numPostiPrenotati += 1;
		return numPostiPrenotati;
	}
	
	public int disdici() throws Exception {
		if (oggi.isAfter(data) || numPostiPrenotati < 0){
			throw new Exception ("La data è stata superata oppure i posti prenotati non sono pervenuti");
		} 
		numPostiPrenotati -= 1;
		return numPostiPrenotati;
	}

	public String dataFormattata() {
		return formatter.format(data);
	}
	
	public int getPostiRimasti () {
		return getNumPostiTot() - getNumPostiPrenotati();
	}
	@Override
	public String toString() {
		return "Data: " + dataFormattata() + "; Titolo evento: " + titolo;
	}
	
}
