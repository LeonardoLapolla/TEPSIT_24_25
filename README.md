In questa attività abbiamo iniziato a mettere mano alla programmazione di servizi web con java. L'attività prevedeva di creare delle pagine .jsp e delle API RESTFUL. Per farlo abbiamo utilizzato i seguenti strumenti:
Maven -> per la gestione della struttura del progetto e di dipendenze e librerie
Jersey -> per la creazione delle API REST ed implementazione di JAX-RS
Jetty -> server web usato per il deploy e l'esecuzione dell'applicazione
Servlets 3.0+ -> per la configurazione descriptor-less, quindi senza file web.xml. Estende ResourceConfig e annota con @ApplicationPath

Come utilizzarlo:
Il progetto si suddivide in due sottoprogetti, il server ed il client.Per avviare il server con jetty bisogna eseguire il comando mvn jetty:run per avviare il server e poi accedere alla porta 8080 sul localhost. Per avviare il client bisogna aprirne il progetto ed avviare il main che esegue le richieste HTTP

NOTE:
-C'è un problema nell'eseguire le richieste GET in al server dato che continuano a ritornare un errore a runtime sul server stesso. Indagando forse il problema potrebbe essere nella conversione delle informazioni in JSON dato l'errore che viene mostrato
