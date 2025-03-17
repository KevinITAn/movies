# Movie Statistics Manager

##  Descrizione
Movie Statistics Manager è un programma Java che analizza un dataset di film e calcola statistiche come:  
- Numero totale di film  
- Durata media  
- Miglior regista basato sul rating IMDB  
- Attore più presente  
- Anno più produttivo  

I dati vengono letti da un file CSV e i risultati salvati in un file di output.

---

## Installazione & Esecuzione  

###  Prerequisiti
- Java 17+  
- Apache Commons CSV (se non incluso nel JAR)  

###  Creazione del file di configurazione
Prima di eseguire il programma, **devi creare un file `preferences.txt`** nella stessa cartella del JAR:  

 ### Formato del file:
   inputfile path
   outFile path
