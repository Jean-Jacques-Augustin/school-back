## Gestion des étudiants

### Présentation du projet
La conception de la base de donnée se trouve dans le fichier [database.sql](database.sql)

### Installation
Pour installer le projet, il faut d'abord créer un db mariadb avec le nom `gestion_etudiants` comme suit:
```bash
$ mysql -u root 
$ CREATE DATABASE gestion_etudiants;
```
Ensuite, lancer itellij et importer le projet.
Il faut lancer le fichier [Main.java](src/main/java/Main.java) qui se trouve dans le dossier `src/main/java/`

Pour assurer le bon fonctionnement du projet, il faut installer les librairies dans le fichier [pom.xml](pom.xml) en faisant un clic droit sur le fichier puis `Maven` et `Reload project`

#### Pour tester la l'efficacité de requêtes:
- Aller dans le dossier http et lancer les requêtes avec le fichier [test.http](http/test.http) en faisant un clic droit sur le fichier puis `Run 'test.http'`

## Swagger est disponible sur le lien suivant:
http://localhost:8080/swagger-ui.html

## Pour accéder à la base de donnée:
- Aller dans le dossier `src/main/resources/`
- Ouvrir le fichier [application.properties](src/main/resources/application.properties)
- Modifier les champs `spring.datasource.username` et `spring.datasource.password` avec votre nom d'utilisateur et mot de passe de votre base de donnée.


By [Jean-Jacques-Augustin]()
