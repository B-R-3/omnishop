[omnishop_readme.md](https://github.com/user-attachments/files/24623928/omnishop_readme.md)
# OmniShop

Application e-commerce développée avec Java Spring Boot et PostgreSQL pour s'entraîner aux technologies backend modernes, le tout dockerisé.

---

## 📋 Prérequis

Avant de commencer, assurez-vous d'avoir installé :
- Docker Desktop
- Git

---

## Guide de démarrage - Étape par étape

### Étape 1 : Installation de l'IDE Cursor

Téléchargez et installez Cursor depuis le site officiel :
```
https://cursor.com/download
```

---

### Étape 2 : Installation du JDK 17

Téléchargez et installez le JDK 17 (Temurin) :
```
https://adoptium.net/fr/temurin/releases?version=17
```

Vérifiez l'installation avec la commande :
```bash
java -version
```

---

### Étape 3 : Installation des extensions Cursor

Dans Cursor, installez les extensions suivantes pour Java/Spring :
- **Spring Boot Extension Pack**
- **Java Extension Pack**
- **Lombok Annotations Support**

---

### Étape 4 : Génération du projet Spring Boot

Rendez-vous sur Spring Initializr :
```
https://start.spring.io/
```

**Configuration du projet :**
- **Project:** Maven
- **Language:** Java
- **Spring Boot:** 3.x.x (dernière version stable)
- **Group:** com.example
- **Artifact:** omnishop
- **Java:** 17

**Dépendances à ajouter :**
- `Spring Data JPA` (Le traducteur entre Java et SQL)
- `PostgreSQL Driver` (La connexion à ta BDD)
- `Spring Web` (Pour tes futures API)
- `Lombok` (Pour t'éviter d'écrire les Getters/Setters)

Cliquez sur **Generate** pour télécharger le projet, puis extrayez-le dans votre dossier de travail.

---

### Étape 5 : Dockerisation de la base de données PostgreSQL

Lancez un conteneur PostgreSQL avec Docker :

```bash
docker run --name omnishop-db -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=password123 -e POSTGRES_DB=omnishop -p 5432:5432 -d postgres
```

**Vérifiez que le conteneur tourne :**
```bash
docker ps
```

---

### Étape 6 : Initialisation de Git et liaison au dépôt distant

Naviguez vers le dossier de votre projet :
```bash
cd omnishop
```

Initialisez Git et poussez vers GitHub :
```bash
git init
```

```bash
git add .
```

```bash
git commit -m "Initial commit"
```

```bash
git remote add origin git@github.com:B-R-3/omnishop.git
```

```bash
git push -u origin main
```

---

### Étape 7 : Configuration de la connexion à la base de données

Éditez le fichier `src/main/resources/application.properties` :

```properties
spring.application.name=omnishop

# Configuration PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/omnishop
spring.datasource.username=admin
spring.datasource.password=password123

# Configuration JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true
```

---

### Étape 8 : Lancement de l'application

Lancez l'application Spring Boot :
```bash
./mvnw spring-boot:run
```

Ou sur Windows :
```bash
mvnw.cmd spring-boot:run
```

L'application devrait démarrer sur `http://localhost:8080`

---

## 📦 Commandes Docker utiles

**Arrêter le conteneur :**
```bash
docker stop omnishop-db
```

**Démarrer le conteneur :**
```bash
docker start omnishop-db
```

**Supprimer le conteneur :**
```bash
docker rm -f omnishop-db
```

**Accéder au conteneur PostgreSQL :**
```bash
docker exec -it omnishop-db psql -U admin -d omnishop
```

---

## 🛠️ Technologies utilisées

- **Java 17**
- **Spring Boot 3.x**
- **PostgreSQL**
- **Docker**
- **Maven**
- **Lombok**

---

## 📝 Prochaines étapes

- Créer les entités JPA (Product, User, Order...)
- Développer les repositories
- Créer les services métier
- Implémenter les contrôleurs REST
- Ajouter la validation des données
- Mettre en place la sécurité (Spring Security)

---

## 👤 Auteur

B-R-3

---

## 📄 Licence

Ce projet est à but éducatif.
