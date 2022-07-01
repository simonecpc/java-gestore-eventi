package jana60;

import java.time.LocalDate;

public class Conferenza extends Evento{

	private Oratore oratore;
	private String argomento;
	
	public Conferenza(String titolo, LocalDate data, int numPostiTot, Oratore oratore, String argomento)
			throws Exception {
		super(titolo, data, numPostiTot);
		this.oratore = oratore;
		this.argomento = argomento;
	}

	public Oratore getOratore() {
		return oratore;
	}

	public void setOratore(Oratore oratore) {
		this.oratore = oratore;
	}

	public String getArgomento() {
		return argomento;
	}

	public void setArgomento(String argomento) {
		this.argomento = argomento;
	}

	@Override
	public String toString() {
		return super.toString() + oratore + "; Argomento:" + argomento;
	}
	
}
