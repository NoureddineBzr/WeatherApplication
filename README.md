Application de Prévisions Météorologiques
Bienvenue dans l'application de prévisions météorologiques ! Cette application Java console vous permet de consulter les prévisions météorologiques actuelles et passées pour différentes villes. L'application utilise JDBC pour se connecter à une base de données MySQL afin de stocker et récupérer les données météorologiques.

Fonctionnalités
L'application comprend trois principales classes :

City (Ville) : Cette classe stocke les informations actuelles de la météo pour une ville donnée.
CityHistory (Historique de Ville) : Cette classe stocke l'historique des données météorologiques pour une ville donnée.
Menu : Cette classe offre une interface utilisateur conviviale pour rechercher et sélectionner une ville spécifique, afficher les prévisions météorologiques actuelles et accéder à l'historique météorologique pour la ville sélectionnée.
Utilisation de JDBC avec MySQL
Les données météorologiques actuelles et historiques sont stockées dans une base de données MySQL. L'application utilise JDBC (Java Database Connectivity) pour établir la connexion entre l'application et la base de données.

Configuration Requise
Avant d'exécuter l'application, assurez-vous d'avoir les éléments suivants :

Java JDK installé sur votre système.
Une base de données MySQL accessible.
Les pilotes MySQL JDBC pour Java.
Configuration de la Base de Données
Assurez-vous de configurer correctement la base de données MySQL en créant les tables nécessaires pour stocker les données météorologiques actuelles et historiques. Vous pouvez trouver les scripts SQL de création de tables dans le dossier database_scripts.

Instructions d'Exécution
Clonez ce dépôt GitHub sur votre machine locale.
Configurez votre base de données MySQL en utilisant les scripts fournis dans le dossier database_scripts.
Assurez-vous d'avoir les pilotes MySQL JDBC dans votre projet.
Compilez les fichiers source Java en utilisant votre IDE ou en ligne de commande.
Exécutez le fichier principal Main.java pour lancer l'application.
Contributions
Les contributions à ce projet sont les bienvenues ! Si vous souhaitez contribuer, veuillez ouvrir une pull request avec vos modifications.
