♠️ Blackjack - Simulation en Java
Une simulation complète du jeu de Blackjack développée en Java avec une interface graphique Swing. Ce projet a été réalisé dans le cadre de l'unité d'enseignement "Méthodes de conception" (L3 Informatique) à l'Université Caen Normandie.

L'objectif principal était de concevoir une application robuste, évolutive et maintenable en appliquant les principes du génie logiciel et divers Design Patterns.

📋 Fonctionnalités

Partie classique : Le joueur affronte le croupier avec pour objectif d'atteindre 21 sans le dépasser.


Interface Graphique (GUI) : Une interface utilisateur développée avec Java Swing pour une expérience visuelle claire.


Intelligence Artificielle : Un système de décision pour le croupier et les joueurs automatisés.


Système de Mises : Gestion de la banque, des paris et vérification des conditions de victoire/défaite.


Architecture Modulaire : Séparation stricte entre la gestion générique des cartes et la logique spécifique du Blackjack.

🏗️ Architecture et Design Patterns
Le projet est divisé en deux modules indépendants pour garantir la réutilisabilité du code:


Module cartes : Bibliothèque générique de gestion de cartes (Paquet, Main, Carte).


Module blackjack : Implémentation de la logique métier (Croupier, Joueur, Règles).

Patrons de conception (Design Patterns) utilisés :
Pour assurer la modularité et l'extensibilité, les patrons suivants ont été implémentés:

🏭 Factory : Utilisé pour la construction et l'instanciation des paquets de cartes.

🧠 Strategy : Gestion des décisions de l'IA (comportement du croupier et du joueur).

🔗 Chain of Responsibility : Système de vérification et validation des mises.

🛡️ Proxy : Gestion de l'accès aux cartes (cartes visibles/cachées du croupier).

👀 Observer + MVC : Mise à jour automatique de l'interface graphique (Vue) en fonction des changements de données (Modèle).

🚀 Installation et Exécution
Le projet utilise Apache Ant pour l'automatisation de la compilation et de l'exécution.

Prérequis
Java JDK installé.

Apache Ant installé.

Commandes
Ouvrez un terminal à la racine du projet et lancez les commandes suivantes :

Compiler le projet :

Bash
ant compile


Lancer le jeu :

Bash
ant run


Une pause automatique est intégrée entre les manches pour permettre au joueur de visualiser les résultats.

👥 Auteurs
Projet réalisé par:

Belaid Azil
