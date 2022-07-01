package jana60;

public class Oratore {

	private String nome;
	private String cognome;
	private String titolo2;

	public Oratore(String nome, String cognome, String titolo2) {
		super();
		this.cognome = cognome;
		this.nome = nome;
		this.titolo2 = titolo2;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTitolo2() {
		return titolo2;
	}

	public void setTitolo2(String titolo2) {
		this.titolo2 = titolo2;
	}

	@Override
	public String toString() {
		return "Nome oratore:" + titolo2 + " " + cognome + " " + nome;
	}
	
	
}
