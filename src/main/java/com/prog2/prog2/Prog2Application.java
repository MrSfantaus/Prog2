package com.prog2.prog2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Prog2Application {

	public static void main(String[] args) {
		SpringApplication.run(Prog2Application.class, args);
	}
	/*
	  - Giorno 1
	    Fare:
	  	-	un servizio rest che torni lista utenti 														[ OK ]
	  	-	un servizio rest che dato il nome ritorni utente specifico (Query param o path variable)		[ OK ]
	  	-	un servizio rest che permetta l'aggiunta di utenti nuovi										[ OK ]
	  	-	un servizio rest che permetta l'eliminazione di un utente dato l'id								[ OK ]
	  	-	un servizio rest che permetta l'update <PLUS>													[ OK ]
		
		- GET di tutti i todo di 1 utente -> /users/{userid}/todos GET										[ OK ]
		- Creazione di un todo per uno specifico utente -> /users/{userid}/todos POST 						[ OK ]
		- Eliminazione di uno specifico todo di un utente -> /users/{userid}/todos/{todoid} DELETE			[ OK ]		
		- Se il TODO ha titolo e descrizione visualizza tutto												[ OK ]
		- Visualizzare tutti i TODO di un utente (solo lista)												[ OK ]
		- Se seleziono un TODO ne vedo il contenuto															[  ]
		- Verifica il collegamento tra TODO e Users															[  ]
	 */
}
