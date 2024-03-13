---
titre: Java
sous-titre: Miniprojet 3 - Pendu avec Swing
auteur: Vincent Faure
date: 3iL 1A 2023
---

**Date de rendu du projet : 13/03/2024 - 17h05**

# Les réalisations
- Lecture aléatoire d'un mot à deviner à partir d'un fichier texte donné à la racine du projet.
- Affichage graphique de l'interface du jeu à l'aide de Swing.
- Affichage graphique des lettres déjà proposées par le joueur.
- Affichage (ou non) de la définition (niveau de difficulté). (En partie)
- Gestion des entrées utilisateur pour proposer des lettres.
- Vérification de la validité des entrées utilisateur (lettre de l'alphabet uniquement).
- Gestion du décompte des tentatives restantes.
- Gestion de la victoire ou de la défaite du joueur.
- Possibilité de rejouer une partie après la fin d'une partie.

# Retour personnel
J'ai trouvé ce sujet très intéressant. Il m'a permis d'essayer de mettre en application les notions vues en cours.
Le plus dur a été de me familiariser avec Swing (je ne connais pas grand-chose en Swing).
J'aurais aimé avoir plus de temps pour faire l'affichage de l'évolution du pendu.

# Conception

Je suis donc parti sur une architecture MVC avec la vue qui devrait gérer seulement l'évolution du pendu,
le contrôleur gère toute la partie entre la proposition d'une lettre et la mise à jour des informations additionnelles.

Dans mon modèle, j'ai un objet Mot.

**Mot**
- String mot
- String definition

J'ai aussi une classe LectureFichier qui permet de récupérer les données de mots.txt
et de les ranger dans une Map<Integer, Mot> afin de faciliter par la suite la récupération d'un mot à partir d'un entier aléatoire.
Cette classe contient aussi la taille de la map qui correspond au nombre de mots présents (aussi pour la recherche aléatoire).

**LectureFichier**
- Map<Integer, Mot> mots
- int taille

Enfin, j'ai mon modèle qui contient un attribut LectureFichier afin de récupérer la liste des mots ainsi que le nombre de mots.
Il est composé du mot tiré aléatoirement grâce à deux fonctions.
Il y a aussi une liste des lettres trouvées par le joueur,
ainsi qu'une liste de lettres qui ont été proposées par le joueur mais qui ne sont pas dans le mot.
Et pour finir un booléen etat, qui me permet de gérer l'état de la partie.

**JeuDuPenduEtat**
- Boolean etat
- LectureFichier lecture fichier
- Mot mot
- List<String> trouvee
- List<String> erreur

Ce modèle est donc utilisé par le contrôleur et l'application est lancée grâce à JeuDuPenduMain.
