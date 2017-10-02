# Plein d'Amis

> Master 2 MIAGE - Architectures et Application Réparties

----------
> Le développement c'est effectué sur l'IDE IntelliJ. Certaine explication sont donc faite en conséquence.

##Wildfly & H2 Console
Configuration du serveur local [Wildfly](http://wildfly.org).

 1. Ajouter un nouveau serveur local JBoss
 2. Pour la première installation, **Application server** sera vide. Indiquer le répertoire d'installation de Wildfly.
 3. Côté **Deployment** choisissez `war`
 4. On peut appliquer et run

Il faut que Wildfly déploie également la base de données H2. Pour cela il faut placer le [`h2console.war`](https://developers.redhat.com/quickstarts/eap/h2-console/) dans le répertoir `wildfly/standalone/deployments/`
On pourra alors avoir accès a la base de donnée via l'url `http://localhost:8080/h2console`


> **_Paramètre de H2_**
> Driver Class: _org.h2.Driver_
> JDBC URL: _jdbc:h2:mem:test_
> User Name: _sa_
> Password: _sa_