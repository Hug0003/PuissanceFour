# Puissance 4 (Connect Four)

Un jeu de Puissance 4 simple et efficace en Java, jouable dans la console.

## Fonctionnalités

*   **2 Joueurs** : Jouez en tour par tour (Player 1 "X" vs Player 2 "O").
*   **Affichage Console** : La grille de jeu est affichée à chaque tour.
*   **Détection de Victoire** : Vérifie automatiquement les alignements horizontaux, verticaux et diagonaux.
*   **Historique des Parties** : Les statistiques de chaque partie (nombre de jetons joués, vainqueur, date) sont sauvegardées automatiquement dans un fichier `data.json`.
*   **Gestion des égalités** : Détecte quand la grille est pleine sans vainqueur.

## Prérequis

*   Java Development Kit (JDK) 8 ou supérieur.
*   Bibliothèque Jackson (pour la gestion du JSON). Assurez-vous que les dépendances Jackson sont ajoutées à votre projet.

## Comment Lancer le Jeu

1.  Clonez ou téléchargez le projet.
2.  Ouvrez le projet dans votre IDE favori (IntelliJ IDEA, Eclipse, etc.).
3.  Exécutez la classe `PuissanceFour.src.Main`.

## Comment Jouer

1.  Le jeu vous demandera de choisir une colonne (de 1 à 7).
2.  Entrez le numéro de la colonne où vous souhaitez placer votre jeton.
3.  Le premier joueur à aligner 4 jetons gagne !

## Structure du Projet

*   `Main.java` : Point d'entrée du jeu et boucle principale.
*   `Game.java` : Logique du jeu (grille, mouvements, vérification de victoire).
*   `Player.java` : Représente un joueur.
*   `Stats.java` & `PlayerData.java` : Gestion des statistiques et de la sauvegarde JSON.