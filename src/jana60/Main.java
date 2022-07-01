package jana60;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Benvenuto nel gestore eventi! inserire i dati per prenotare un evento:");
		
		boolean riprova = true;
		
		Evento e = null;
		
		do {
			try {
				System.out.println("Inserire titolo:");
				String titolo = scan.nextLine();
				System.out.println("Inserire giorno:");
				int giorno = Integer.parseInt(scan.nextLine());
				System.out.println("Inserire mese:");
				int mese = Integer.parseInt(scan.nextLine());
				System.out.println("Inserire anno:");
				int anno = Integer.parseInt(scan.nextLine());
				System.out.println("Capienza dell'evento");
				int postiTotali = Integer.parseInt(scan.nextLine());
	
				LocalDate data = LocalDate.of(anno, mese, giorno);
				e = new Evento(titolo, data, postiTotali);
				riprova = false;
				} catch (NumberFormatException e2) {
					e2.printStackTrace();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			}while(riprova);
			
		try {
			
			int prenotazione;
			
			do {
				System.out.println("Quanti posti vuoi prenotare?");
				prenotazione = Integer.parseInt(scan.nextLine());
				if(prenotazione < 0) {
					System.out.println("Inserire un valore maggiore di 0.");
				}
			}while(prenotazione < 0);
			
			for (int i = 0; i < prenotazione; i++) {
				e.prenota();
			}
			
			int postirimasti = e.getNumPostiTot() - e.getNumPostiPrenotati();
			
			System.out.println("Hai prenotato: " + e.getNumPostiPrenotati() + " posti. Posti rimasti all'evento " + postirimasti);
			
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		}catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		
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
			    		
			    	int postirimasti = e.getNumPostiTot() - e.getNumPostiPrenotati();
			    	System.out.println("Modifica effettuata. Adesso hai prenotato: " + e.getNumPostiPrenotati() + " posti. Posti rimanenti: " + postirimasti);
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
