package jana60;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		String conferma;
		Scanner scan = new Scanner(System.in);

		System.out.println("Benvenuto nel gestore eventi! inserire i dati per prenotare un evento:");

		boolean riprova = true;
		boolean riprova2 = true;
		Evento e = null;

		do {
			System.out.println("Inserire titolo:");
			String titolo = scan.nextLine();
			try {
				System.out.println("Inserire giorno:");
				int giorno = Integer.parseInt(scan.nextLine());
				System.out.println("Inserire mese:");
				int mese = Integer.parseInt(scan.nextLine());
				System.out.println("Inserire anno:");
				int anno = Integer.parseInt(scan.nextLine());
				System.out.println("Capienza dell'evento");
				int postiTotali = Integer.parseInt(scan.nextLine());
				
				System.out.println("Questo evento corrisponde a una conferenza?");
				conferma = scan.nextLine();
				
				do {
					switch (conferma) {
					case "si":
						System.out.println("Inserire Argomento della conferenza:");
						String argomento = scan.nextLine();
						System.out.println("Inserire nome oratore:");
						String nome = scan.nextLine();
						System.out.println("Inserire cognome oratore:");
						String cognome = scan.nextLine();
						System.out.println("Inserire titolo oratore:");
						String titoloStudio = scan.nextLine();
						
						Oratore o = new Oratore(nome, cognome, titoloStudio);
						LocalDate data = LocalDate.of(anno, mese, giorno);
						Conferenza c = new Conferenza(titolo, data, postiTotali, o, argomento);
						System.out.println(c);
						riprova2 = false;
						break;
					case "no":
						LocalDate data2 = LocalDate.of(anno, mese, giorno);
						e = new Evento(titolo, data2, postiTotali);
						System.out.println(e);
						riprova2 = false;
						break;
					default:
						System.out.println("Valore non valido, riprovare.");
						break;
					}
				} while (riprova2);
				
				riprova = false;
			} catch (NumberFormatException e2) {
				System.out.println("Inserire un intero.");
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}while(riprova);

		riprova = true;
		
		do {
			try {
				int prenotazione;
				
				do {
					System.out.println("Quanti posti vuoi prenotare?");
					prenotazione = Integer.parseInt(scan.nextLine());
					if (prenotazione > e.getNumPostiTot()) {
						System.out.println("Non puoi prenotare più posti della capienza totale");
					}
					if (prenotazione < 0) {
						System.out.println("Inserire un valore maggiore di 0.");
					}
				} while (prenotazione < 0 || prenotazione > e.getNumPostiTot());

				for (int i = 0; i < prenotazione; i++) {
					e.prenota();
				}

				System.out.println("Hai prenotato: " + e.getNumPostiPrenotati() + " posti. Posti rimasti all'evento " + e.getPostiRimasti());
				riprova = false;
			} catch (NumberFormatException e1) {
				System.out.println("Inserire un intero.");
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			} 
		} while (riprova);
		boolean finito = false;

		try {
			while(!finito){
				System.out.println("Vuoi disdire una prenotazione? scrivere 1 per disdire o 2 per fermarsi qui.");
				String scelta = scan.nextLine();

				switch (scelta) {
				case "1":
					int disdire;
					do {
						do {
							System.out.println("Quanti posti vuoi disdire?");
							disdire = Integer.parseInt(scan.nextLine());
							if (disdire < 0) {
								System.out.println("Inserire un valore maggiore di 0.");
							}
						} while (disdire < 0);
						if (disdire > e.getNumPostiPrenotati()) {
							System.out.println("Non puoi disdire più posti di quanti ne abbia già prenotato");
						} else {
							riprova = false;
							for (int i = 0; i < disdire; i++) {
								e.disdici();
							}
						} 
					} while (riprova);

					System.out.println("Modifica effettuata. Adesso hai prenotato: " + e.getNumPostiPrenotati() + " posti. Posti rimanenti: " + e.getPostiRimasti());
					break;
				case "2":
					System.out.println("Va bene, Arrivederci!");
					finito = true;
					break;
				default:
					System.out.println("Scelta non valida");
					break;
				}

			}
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}

		
		
	}
}
