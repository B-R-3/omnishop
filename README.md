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

### Étape 5 : Initialisation de Git et liaison au dépôt distant

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

### Étape 6 : Dockerisation de la base de données PostgreSQL

Lancez un conteneur PostgreSQL avec Docker dans le chemin du projet :

```bash
docker run --name omnishop-db -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=password123 -e POSTGRES_DB=omnishop -p 5432:5432 -d postgres
```

**Vérifiez que le conteneur tourne :**
```bash
docker ps
```

---

### Étape 7 : Dockerisation du Backend

Initialisez la configuration du conteneur avec Docker toujours dans le chemin du projet :

```bash
docker init
```

**Choisissez vos versions et options avec 'enter':**

La commande `docker init` a créé trois fichiers essentiels à la racine de ton projet :

- **`Dockerfile`** : C'est le manuel d'instruction pour construire l'image de ton application. Il contient les étapes pour compiler ton code Java (Maven) et l'empaqueter dans un environnement léger (JRE).
- **`compose.yaml`** : C'est le fichier d'orchestration. Il définit comment ton serveur et ta base de données doivent coexister.
- **`.dockerignore`** : Il indique à Docker de ne pas copier les fichiers inutiles (comme le dossier `target` ou les logs) pour gagner du temps et de l'espace.

## Étape 8 : Configuration du lien entre les services

C'est l'étape où tu as "câblé" le Backend à la BDD.

1. **Dans `application.properties`** : Tu as remplacé `localhost` par `db` dans l'URL JDBC (`jdbc:postgresql://db:5432/omnishop`).
2. **Pourquoi ?** Parce que dans le réseau Docker créé par le fichier Compose, les conteneurs se reconnaissent par leur nom de service.

## Étape 9 : Nettoyage et Premier Lancement

Tu as utilisé une commande puissante pour t'assurer de partir sur des bases saines, surtout après avoir modifié les utilisateurs ou les versions de Postgres :

```bash
docker compose down -v
```

- Le `down` arrête les services.
- Le `-v` supprime les volumes (les anciennes données) pour forcer PostgreSQL à se réinitialiser avec tes nouveaux réglages.

## Étape 10 : Construction et Exécution (Build & Run)

Tu as lancé la commande finale qui fait tout le travail :

```bash
docker compose up --build
```

1. **Build** : Docker lit ton `Dockerfile`, télécharge Maven, compile ton code Java, et crée une image de ton application.
2. **Up** : Docker lance le conteneur `db` (Postgres), attend qu'il soit "Healthy", puis lance ton conteneur `server` (Spring Boot).

## Étape 11 : Persistance et Vérification

Une fois l'application lancée :

- **Les DATA** : Tu as vérifié qu'un volume était créé. Tes données vont maintenant dans un dossier persistant sur ton disque dur géré par Docker. Elles survivent aux redémarrages mais pas au `down -v`.
- **Le Test** : Tu as utilisé Postman sur le port 8000 pour confirmer que le flux complet fonctionnait : `Requête HTTP -> Controller -> Service -> Repository -> Hibernate -> Postgres (dans Docker)`.

## En résumé, ce que tu as accompli

Tu as transformé une application qui ne marchait que "sur ta machine" en un système standardisé. Désormais, peu importe l'ordinateur, si Docker est présent, l'application fonctionnera exactement de la même manière.

---
## Étape 12 : Tester l'API avec Postman
Une fois que ton application tourne, il est temps de vérifier que tout fonctionne correctement !

Installation de Postman
Télécharge et installe Postman depuis le site officiel :

https://www.postman.com/downloads/

Test de santé de l'application
Crée une nouvelle requête dans Postman : GET OU POST

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
- **PostgreSQL:17**
- **Docker**
- **Maven**
- **Lombok**

---


## 👤 Auteur

B-R-3

---

## 📄 Licence

Ce projet est à but éducatif.
