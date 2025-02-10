package riepilogo_primipassi;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Menù principale\n");
		int i=0;

		do {
			menu();
			System.out.println("Per uscire dal menù immetti zero");
			 i =sc.nextInt();
			 Switch(i);
		} while (i!=0);

		sc.close();

	}

	// FUNZIONI
	private static void menu() {
		System.out.println("Lista esercizi primi passi");
		System.out.println("1. Saluto personalizzato");
		System.out.println("2. Numeri crescenti");
		System.out.println("3. Pari o dispari");
		System.out.println("4. Positivo negativo nullo");
		System.out.println("5. Vocale o consonante");
		System.out.println("6. primi 10 numeri");
		System.out.println("7. Conto alla rovescia");
		System.out.println("8. Valore assoluto");
		System.out.println("9. Swap");
		System.out.println("10. Tabellina");
		System.out.println("11. Mese");
		System.out.println("12. Numero finchè non è pari");
		System.out.println("13. Indovina il numero");
		System.out.println("14. I predecessori -> ATTENZIONE NON PRESENTE!");
		System.out.println("15. Menù -> ATTENZIONE NON PRESENTE!");
		System.out.println("16. Range");
		System.out.println("17. Stagioni");
		System.out.println("18. Primi 10 numeri pari positivi");

	}
	
	public static void Ritorno() {
		System.out.println("");
		System.out.println("Torno nel menù principale\n");
	}
	
	// ESERCIZIO 1
	public static void SalutoPersonalizzato() {
		
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Come ti chiami?");
		String nome = tastiera.nextLine();

//		System.out.println("Il nome inserito è : " +nome);

		int ora;
		do{
			System.out.println("Che ore sono (formato h24)?");
			ora = tastiera.nextInt();
		}while (ora<0 || ora>24);

//		Determina se è buongiorno o buonasera in base all'ora inserita
		String saluto;

		if (ora >= 0 && ora < 12) {
			saluto = "Buongiorno";
		} else if (ora >= 12 && ora < 18) {
			saluto = "Buon pomeriggio";
		} else {
			saluto = "Buonasera";
		}
		
		System.out.println(saluto + ", " + nome + "!");
		Ritorno();
		
	}
	
	// ESERCIZIO 2
	public static void NumeriCrescenti() {
		Scanner tastiera1 = new Scanner(System.in);				
		System.out.println("Dammi un numero intero positivo");
		int Valore1 = tastiera1.nextInt();
		System.out.println("Dammi un secondo numero intero positivo");
		int Valore2 = tastiera1.nextInt();
//		System.out.println("I numeri inseriti sono\n" +Valore1+ ";" +Valore2);

		
//		Determina quale dei due numeri è il più grande
		int maggiore=0;
		if(Valore1>= 0 && Valore2>=0){
			if(Valore1>Valore2) {
				maggiore=+ Valore1;
				System.out.println("Il numero maggiore è: " +maggiore);
				Ritorno();
			}else if(Valore1<Valore2) {
				maggiore=+ Valore2;
				System.out.println("Il numero maggiore è: " +maggiore);
				Ritorno();
			}else {
				System.out.println("Inserimento errato");
				Ritorno();
			}

		}else {
			System.out.println("Inserimento errato");
			Ritorno();
		}
	}
	
	// ESERCIZIO 3
	public static void PariDispari() {
		Scanner tastiera2 = new Scanner(System.in);
		System.out.println("Dammi un numero intero positivo");
		int numero = tastiera2.nextInt(); 
		
//	    Determina se il numero è pari o dispari
		if(numero>0) {
			if(numero%2==1){
				System.out.println("Il numero inserito è dispari");
				Ritorno();
				}
			else if(numero%2==0) {
				System.out.println("Il numero inserito è pari");
				Ritorno();
				}
		}else {
			System.out.println("Il numero inserito deve essere intero e positivo");
			Ritorno();
			}
	}
	
	// ESERCIZIO 4
	public static void PositivoNegativoNullo() {
		Scanner tastiera3 = new Scanner(System.in);
		System.out.println("Dammi un numero intero");
		int number = tastiera3.nextInt();

//		 Determina se il numero è positivo, negativo o nullo
		if(number>0) {
			System.out.println("Il numero inserito è positivo");
			Ritorno();
		}
		else if(number==0) {
			System.out.println("Il numero inserito è nullo");
			Ritorno();
			}
		else {
			System.out.println("Il numero inserito è negativo");
			Ritorno();
		}
	}
	
	// ESERCIZIO 5
	public static void VocaleConsonante() {
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Dammi una lettera dell'alfabeto");
		char lettera = tastiera.nextLine().charAt(0);

//		Determina se vocale o consonante
		if(lettera=='a' || lettera=='e' || lettera=='i' || lettera=='o' || lettera=='u') {
			
			System.out.println("La lettera è una vocale");
			Ritorno();
			
		}else {
			System.out.println("La lettera è una consonante"); 
			Ritorno();
		}
		
	}
	
	// ESERCIZIO 6
	public static void StampaPrimi10Numeri() {
		for(int j=1; j<=10;j++) {
			System.out.print(j+" ");
		} 
		Ritorno();
	}
	
	// ESERCIZIO 7
	public static void ContoAllaRovescia() {
		Scanner tastiera = new Scanner(System.in);		
		System.out.println("Inserisci un numero intero");
		int numero = tastiera.nextInt();
		
//		Conto alla rovescia
		int valore;
		for(int i=numero; i>= 0; i--) {
			valore=i;
			System.out.print(+valore+" ");
		}
		Ritorno();
	}
	
	// ESERCIZIO 8
	public static void ValoreAssoluto() {
		Scanner tastiera = new Scanner(System.in);	
		System.out.println("Dammi un numero intero \n");
		int numero = tastiera.nextInt();

		//calcolo il valore assoluto
		int x;
		if(numero<0) {
			x=numero*(-1);
//			System.out.print("Il valore assoluto è: " +x);
		}else {
			x=numero;
//			System.out.print("Il valore assoluto è: " +numero);
		}
		System.out.print("Il valore assoluto è: " +x);
		Ritorno();
	}
		
	// ESERCIZIO 9
	public static void Swap() {
		Scanner tastiera = new Scanner(System.in);		
		System.out.println("Dammi un numero intero positivo");
		int numero1 = tastiera.nextInt();	
		System.out.println("Dammi un secondo numero intero positivo");
		int numero2 = tastiera.nextInt();

//		 Scambio dei valori
		int x=numero1;
		numero1=numero2;
		numero2=x;
		System.out.print("Scambio: " +numero1+ ";" +numero2);
		Ritorno();
	}
	
	// ESERCIZIO 10
	public static void Tabellina() {
		Scanner tastiera = new Scanner(System.in);		
		System.out.println("Dammi un numero intero, io stampo la tabellina");
		int numero = tastiera.nextInt();

		int x,y;
		for(int i=0; i<= numero; i++) {
			x=numero;
			y=i;
			System.out.println(x+ "x"+y+ "=" +(x*i)+ " ");
		}
		Ritorno();
	}
	
	// ESERCIZIO 11
	public static void Mese() {
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Dammi un numero intero tra 1 e 12\n");
		int choice = tastiera.nextInt();

		switch (choice) {
		case 1:  
			System.out.println("Gennaio");
			break;
		case 2:
			System.out.println("Febbraio");
			break;
		case 3:  
			System.out.println("Marzo");
			break;
		case 4:
			System.out.println("Aprile");
			break;
		case 5:  
			System.out.println("Maggio");
			break;
		case 6:
			System.out.println("Giugno");
			break;
		case 7:  
			System.out.println("Luglio");
			break;
		case 8:
			System.out.println("Agosto");
			break;
		case 9:  
			System.out.println("Settembre");
			break;
		case 10:
			System.out.println("Ottobre");
			break;
		case 11:  
			System.out.println("Novembre");
			break;
		case 12:
			System.out.println("Dicembre");
			break;

		default:
			System.out.println("Numero errato");
		}
		Ritorno();
	}
	
	// ESERCIZIO 12
	public static void FinchePari() {
		Scanner tastiera = new Scanner(System.in);
		int numero;

		do {	
			System.out.println("Dammi un numero intero positivo pari");
			numero = tastiera.nextInt();
			if(numero%2!=0) {
				System.out.println("Il numero inserito è dispari");
			}
		}while (numero%2!=0);
	
		System.out.println("Il numero inserito è pari");
		Ritorno();
	}
	
	// ESERCIZIO 13
	public static void IndovinaIlNumero() {
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Dammi un numero intero");
		int numero1 = tastiera.nextInt(); 
		
		System.out.println("indovina il numero");
		
//		Indovino il numero
		int numero2;
		do {	
			 numero2 = tastiera.nextInt();
			if(numero2!=numero1) {
				System.out.println("Tenta ancora");
			}
		}while (numero2!=numero1);
		
		System.out.println("Bravo!");
		Ritorno();
	}
	
	// QUESTI DUE SONO UN PO' INUTILI...
//________________________________________________________
	// HO GIA' FATTO UN MENU' E PURE I PREDECESSORI!
//	// ESERCIZIO 14
//	public static void l () {}
	
//	// ESERCIZIO 15
//	public static void l () {}
//________________________________________________________	
	// ESERCIZIO 16
	public static void Range() {

//		Acquisisco gli estremi dell'intervallo
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Dammi il valore minimo dell'intervallo");
		int minimo = tastiera.nextInt();
		System.out.println("Dammi il valore massimo dell'intervallo");
		int massimo = tastiera.nextInt();
		
		
//		Prendo valori finchè inclusi nell'intervallo [minimo;massimo]
		int x,i=0,somma=0,media=0;
		
		do {
			System.out.println("Dammi un valore nell'intervallo[" +minimo+";"+massimo+"]");
			x = tastiera.nextInt();
			if(x>= minimo && x<= massimo) {
				somma+=x;
				i+=1;
				media= somma/i;
			}
		}while(x>= minimo && x<= massimo);

		System.out.println("Somma:" +somma+ " Media:"+media);
		Ritorno();
		
	}
		
	// ESERCIZIO 17
	public static void Stagioni() {
		Scanner tastiera = new Scanner(System.in);		
		System.out.println("Dammi un numero intero tra 1 e 12\n");
		int choice = tastiera.nextInt();

		switch (choice) {
		case 1:  
			System.out.println("Inverno");
			break;
		case 2:
			System.out.println("Inverno");
			break;
		case 3:  
			System.out.println("Che giorno?");
			int marzo = tastiera.nextInt();
			if(marzo>=1 && marzo<21) {
				System.out.println("Inverno"); 
			}else {
				System.out.println("Primavera"); 
			}
			break;
		case 4:
			System.out.println("Primavera");
			break;
		case 5:  
			System.out.println("Primavera");
			break;
		case 6:
			System.out.println("Che giorno?");
			int giugno = tastiera.nextInt();
			if(giugno>=1 && giugno<21) {
				System.out.println("Primavera"); 
			}else {
				System.out.println("Estate"); 
			}
			break;
		case 7:  
			System.out.println("Estate");
			break;
		case 8:
			System.out.println("Estate");
			break;
		case 9: 
			System.out.println("Che giorno?");
			int settembre = tastiera.nextInt();
			if(settembre>=1 && settembre<23) {
				System.out.println("Estate"); 
			}else {
				System.out.println("Autunno"); 
			}
			break;
		case 10:
			System.out.println("Autunno");
			break;
		case 11:  
			System.out.println("Autunno");
			break;
		case 12:
			System.out.println("Che giorno?");
			int dicembre = tastiera.nextInt();
			if(dicembre>=1 && dicembre<21) {
				System.out.println("Autunno"); 
			}else {
				System.out.println("Inverno"); 
			}
			break;

		default:
			System.out.println("Numero non riconosciuto");
		}
		Ritorno();
	}
			
	// ESERCIZIO18
	public static void Primi10NumeriPariPositivi() {
		Scanner tastiera = new Scanner(System.in);	

		//		Chiedo l'immissione di valori fino ad inserire 10 numeri pari positivi
		int i=0,numero;
		do {
			System.out.print("Immetti un numero pari positivo");
			numero=tastiera.nextInt();
			if (numero%2==0) {
				i+=1;
			}else {
				System.out.println("Hai sbagliato!");
			}	
		}while(i<10);

		System.out.println("hai immesso 10 numeri pari positivi, bravo!");
		Ritorno();
	}
	
	public static void Switch(int choice) {
		 switch (choice) {
			case 1:
				SalutoPersonalizzato();
				break;
			case 2:
				NumeriCrescenti();						
				break;
			case 3:
				PariDispari();
				break;
			case 4:
				PositivoNegativoNullo();
				break;
			case 5:
				VocaleConsonante();				
				break;
			case 6:
				StampaPrimi10Numeri();
				break;
			case 7:
				ContoAllaRovescia();
				break;
			case 8:
				ValoreAssoluto();
				break;
			case 9:
				Swap();
				break;
			case 10:
				Tabellina();
				break;
			case 11:
				Mese();
				break;
			case 12:
				FinchePari();
				break;
			case 13:
				IndovinaIlNumero();
				break;
			case 14:
				System.out.println("NON PRESENTE!");
				break;
			case 15:
				System.out.println("NON PRESENTE!");
				break;
			case 16:
				Range();
				break;
			case 17:
				Stagioni();
				break;
			case 18:
				Primi10NumeriPariPositivi();
				break;
			default:
				break;
			}
	}


}
