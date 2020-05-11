**Nom/Prénom Etudiant : Janin Ewald**


# Rapport TP2b

## Question 2
Ajouter une nouvelle opération dans l'expression semble être assez bien faisable, il suffit de dupliquer et réfactorer une classe opération existante, sauf si elle nécéssite plus de deux noeuds, auquel cas il faudrait créer une classe `OperateurTernaire` (ou plus, mais avec tous les intermédiaires) sur le modèle des `OperateurUnaire` et `OperateurBinaire`. 

En revanche, ajouter un des types d'algorithmes de parcours de l'énoncé me paraît déjà plus lourd : il va falloir rajouter une méthode dans plusieurs classes (les classes _operateur_ et la `Constante`). Mais ajouter un parcours en profondeur ou en largeur sur ce graphe me paraît vraiment complexe et nécessitera de revoir l'architecture. De même pour pouvoir calculer la hauteur du graphe, ou alors il faudrait passer énormément d'arguments à des méthodes pour parcourir le graphe, voire utiliser _java.util.Optional_.

## Question 3
*Insérer un diagramme de classe du patron de conception mis en place appliqué au contexte de l'expression arithmétique*
*Expliquer le code ajouté*

## Question 8
*Discutez la facilité d’ajouter d'autres opérations sur l'expression arithmétique.*
*Discutez la facilité d’ajouter d'autres types de Noeud à l'expression arithmétique.*
