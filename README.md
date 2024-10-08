# TP1

Ce projet a pour objectif de gérer et suivre les performances des développeurs au sein d'une équipe en enregistrant quotidiennement le nombre de scripts réalisés. L'application se connecte à une base de données MySQL via JDBC, permettant la création et la gestion des enregistrements dans une table dédiée.

## Objectif du Projet

L'objectif principal est de :

- Créer et gérer une base de données MySQL pour stocker les informations des développeurs et les scripts qu'ils produisent.
- Offrir une interface pour insérer et consulter ces données à l'aide de requêtes SQL.
- Générer des statistiques sur les performances des développeurs au fil du temps.

## Fonctionnalités Clés

- **Création d'une table de base de données :**  
  La table `DevData` stocke les noms des développeurs, les jours de la semaine et le nombre de scripts réalisés.

- **Insertion de données :**  
  Enregistrement des résultats journaliers des développeurs dans la base de données.

- **Requêtes SQL :**  
  Permet d'exécuter des requêtes telles que :  
  - Identifier le développeur ayant produit le plus de scripts en une journée.
  - Classer les développeurs selon leur production hebdomadaire.
  - Calculer le total de scripts réalisés par un développeur spécifique.

- **Requête libre avec métadonnées :**  
  Possibilité d'exécuter des requêtes personnalisées et de récupérer des informations sur les colonnes et les types de données des résultats.

## Technologies Utilisées

- **Java :** Pour la logique de programmation et l'interaction avec la base de données.
- **JDBC (Java Database Connectivity) :** Pour l'accès et la manipulation des données MySQL.
- **MySQL :** Système de gestion de base de données utilisé pour stocker les informations des développeurs et leurs scripts.
- **NetBeans :** IDE recommandé pour le développement et les tests.

## Prérequis

Avant d'exécuter ce projet, il est nécessaire d'avoir :

- **Java JDK 8+ :** Pour l'exécution du code Java.
- **MySQL :** Pour le stockage des données des développeurs.
- **Pilote JDBC MySQL :** Pour établir la connexion entre Java et MySQL.
- **NetBeans ou un autre IDE compatible avec Java.**

https://github.com/user-attachments/assets/29c82baa-04a0-4a41-890b-2eee9f2e616c

https://github.com/user-attachments/assets/fe7c6002-e13e-4c55-ba91-5bfe6708da03
