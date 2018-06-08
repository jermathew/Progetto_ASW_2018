# Sentence

Questo sottoprogetto mostra come eseguire l'applicazione **sentence** 
utilizzando la **composizione** di contenitori Docker.  

### Build (Java)  

Per prima cosa, è necessario effettuare il build dell'applicazione con Gradle,  
nell'ambiente [developer](../../../environments/developer/): 

* eseguire lo script `build-all-projects.sh` nella cartella del sottoprogetto 
  
### Esecuzione (Docker Compose)  

In alternativa, è possibile costruire e mandare in esecuzione l'applicazione con Docker Compose, 
operando come segue nell'ambiente [docker](../../../environments/docker/): 

* eseguire il comando `docker-compose build`
  oppure lo script `build-images-with-compose.sh` per effettuare la build delle immagini dei contenitori Docker 
 
* eseguire il comando `docker-compose up` 
  oppure lo script `run-with-compose.sh` per mandare in esecuzione i contenitori necessari per l'applicazione  

* eseguire il comando `docker-compose down` 
  oppure lo script `stop-with-compose.sh` per terminare l'esecuzione dell'applicazione 
  e rimuovere tutti i suoi contenitori 
  
**Attenzione**: l'applicazione ci mette qualche minuto a partire. 

 
L'applicazione viene esposta sulla porta `8080` della macchina virtuale **docker**, sul path `/sentence`. 
Pertanto, il servizio sarà accessibile nella macchina virtuale **docker** 
all'indirizzo `localhost:8080/sentence` 
