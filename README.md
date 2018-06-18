# Progetto ASW 2018
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT) [![Build Status](https://travis-ci.org/jgm25/Progetto_ASW_2018.svg?branch=master)](https://travis-ci.org/jgm25/Progetto_ASW_2018)

Progetto per il corso di Architettura dei Sistemi Software (a.a. 2017/2018)



## Table of Contents 

- [Caratteristiche generali](#caratteristiche-generali)
- [Applicazione](#applicazione)
- [Step deployment pipeline](#step-deployment-pipeline)
- [Team](#team)
- [License](#license)



## Caratteristiche generali

In questa repository è presente un progetto di *continous delivery*. In particolare l'obiettivo principale è stato quello di sviluppare una semplice applicazione contenitorizzata in [Java](http://www.oracle.com/technetwork/java/javase/overview/index.html) e definire una pipeline con vari step per il rilascio su cloud dell'applicazione. 
Le principali tecnologie utilizzate nel progetto sono:
* [Gradle](https://gradle.org/) per l'assemblaggio e testing dell'applicazione
* [Docker](https://www.docker.com/) per costruire delle immagini, ognuna rappresentante un certo servizio dell'applicazione
* [Travis](https://travis-ci.org/), un servizio su cloud che permette di definire ed eseguire delle pipeline 
* [Amazon AWS](https://aws.amazon.com/it/) per ottenere una istanza del servizio EC2 su cui rilasciare l'applicazione

## Applicazione

L'applicazione consiste in un generatore di frasi casuali. Essa consta di più servizi distribuiti:
* Sentence, il servizio principale, applicazione Spring Boot che crea frasi sempre diverse, in esecuzione sulla porta 8080.
* Subject, che crea il soggetto, in esecuzione sulla porta 8081.
* Verb, che crea il verbo, in esecuzione sulla porta 8082.
* Object, che crea il complemento oggetto, in esecuzione sulla porta 8083.

Sentence sfrutta i 3 servizi di Subject, Verb e Object (i quali creano parole di tipo diverso) al fine di generare una frase di senso compiuto. Per semplicità, essi vengono trattati come profili di un servizio Spring Boot più generico, ovvero Word. In pratica, il soggetto, il verbo ed il complemento generati saranno istanze di oggetti Word, i quali verranno sfruttati da Sentence tramite REST nella formazione della frase finale.

Inoltre, abbiamo 2 ulteriori servizi:
* [Eureka](https://github.com/Netflix/eureka/), un servizio di Discovery 
* [Zuul](https://github.com/Netflix/zuul/), un servizio di gateway

Di seguito, uno schema concettuale dell'applicazione:

![Schema](https://github.com/NicholasNapolitano/Progetto_ASW_2018/blob/master/Schema%20Concettuale.png)

E' necessario creare immagini contenitorizzate per ogni servizio al fine di eseguire l'applicazione. Tale composizione di contenitori è stata resa possibile tramite lo strumento **Docker Compose**, che permette di eseguire e definire applicazioni Docker basate su più contenitori. 

Docker Compose è basato sull’utilizzo di un file di configurazione **docker-compose.yml** per specificare i diversi servizi che compongono un’applicazione. Dopo di che, è possibile avviare l'applicazione eseguendo semplici comandi:
* **docker-compose build**, per costruire le immagini per i contenitori dell’applicazione. 
* **docker-compose up**, per avviare l’applicazione (creando e avviando i suoi contenitori).

Per arrestare l'applicazione, si esegue il comando **docker-compose down**

## Step deployment pipeline

Come già accennato la pipeline è composta di vari step. Per sfruttare Travis è necessario semplicemente fare login sul sito web di Travis tramite il proprio account github e specificare su quali **repository** deve lavorare Travis. 

Le repository scelte devono contenere nella root un file **.travis.yml** che in un linguaggio proprietario di Travis specifica in maniera dichiarativa quali step devono essere eseguiti.

Travis offre la possibilità di eseguire degli script bash se gli step della pipeline sono particolarmente articolati. Per fare questo si usa nel .travis.yml la sintassi:

	script:
  	- bash <nome_script.sh>

In generale Travis definisce alcuni step predefiniti nella deployment pipeline, ognuno identificato da un nome simbolico (ad esempio fase di *install*, *before_install*, *deploy*). La sintassi generale è così definita:

	nome_fase: 
  		- azione 1
		- azione 2
        	.
		.
        	- azione n

La **pipeline** è così formata:
* alcune azioni preliminari, come la specifica del linguaggio di programmazione utilizzato, l'abilitazione di *sudo* e l'abilitazione di alcuni servizi aggiuntivi, nel nostro caso docker
* una fase **before_install** per decrittare la chiave per accedere alla macchina virtuale EC2
* una fase di **build** in cui viene eseguito lo script *build-and-runIntegrationTest.sh* che contiene dei comandi gradle per fare la build del codice ed eseguire solamente i test di integrazione. Infatti l'idea è che i test di unità vengano eseguiti in locale dagli sviluppatori
* l'esecuzione dello script *build-all-images.sh* che legge i **DockerFile** relativi ai quattro servizi dell'applicazione, costruisce le relative immagini e le carica su [DockerHub](https://hub.docker.com/)
* una fase di **deploy** in cui viene eseguito lo script *deploy.sh*. Questo script trasferisce a sua volta sulla istanza di EC2 alcuni script e il *docker.compose.yml* . Gli script scaricano le immagini relative all'applicazione da DockerHub, dalle 4 immagini istanziano 4 contenitori che poi sono fatti comunicare tramite docker-compose.
* l'esecuzione di test end-to-end per testare ulteriormente l'applicazione
## Team

- [Vincenzo Martello](https://github.com/vincenzomartello)
- [Jerin George Mathew](https://github.com/jgm25)
- [Nicholas Napolitano](https://github.com/nicholasnapolitano)
- [Marco Oliva](https://github.com/maroliva)
- [Simone Pellegrini](https://github.com/spellegrini1995)

## License

This project is licensed under the MIT License - see the LICENSE.md file for details
