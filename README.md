In questa attività abbiamo iniziato a mettere mano alla programmazione di servizi web con java. L'attività prevedeva di creare delle pagine .jsp e delle API RESTFUL. Per farlo abbiamo utilizzato i seguenti strumenti:
Maven -> per la gestione della struttura del progetto e di dipendenze e librerie
Jersey -> per la creazione delle API REST ed implementazione di JAX-RS
Jetty -> server web usato per il deploy e l'esecuzione dell'applicazione
Servlets 3.0+ -> per la configurazione descriptor-less, quindi senza file web.xml. Estende ResourceConfig e annota con @ApplicationPath

Come utilizzarlo:
Per avviare il server con jetty bisogna eseguire il comando mvn jetty:run per avviare il server e poi accedere alla porta 8080 sul localhost

NOTE:
-Molte versione delle dipendenze erano obsolete e quindi ho dovuto aggiornarle
-La parte delle API non funziona in quanto il tutorial risulta oramai obsoleto come molte versioni delle dipendenze. Ho fatto vari tentativi ma il server continua a restituirmi errore 404 sulle API
