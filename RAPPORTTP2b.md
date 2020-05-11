**Nom/Prénom Etudiant : Janin Ewald**


# Rapport TP2b

## Question 2
Ajouter une nouvelle opération dans l'expression semble être assez bien faisable, il suffit de dupliquer et réfactorer une classe opération existante, sauf si elle nécéssite plus de deux noeuds, auquel cas il faudrait créer une classe `OperateurTernaire` (ou plus, mais avec tous les intermédiaires) sur le modèle des `OperateurUnaire` et `OperateurBinaire`. 

En revanche, ajouter un des types d'algorithmes de parcours de l'énoncé me paraît déjà plus lourd : il va falloir rajouter une méthode dans plusieurs classes (les classes _operateur_ et la `Constante`). Mais ajouter un parcours en profondeur ou en largeur sur ce graphe me paraît vraiment complexe et nécessitera de revoir l'architecture, ou alors de rajouter une méthode dans de nombreuses classes.

## Question 3
Les ajouts que j'ai fait pour cette question sont la classe abstraite `Visitor` ainsi que les méthodes `accept(v : Visitor)` dans l'interface `Noeud` ainsi que dans toutes les classes concrètes implémentant cette interface. J'ai également ajouté le getter de _valeur_ dans `Constante`.

Conformément au _design pattern Visitor_, j'ai dans la classe _abstraite_ `Visitor` une méthode par classe concrète pouvant être visitée par une instance d'une classe héritant de `Visitor`. C'est grâce au principe du **double dispatch** que je vais appeler les bonnes méthodes.

Le diagramme UML ci-dessous ne comporte pas de classes visiteurs concrètes, car je n'avais pas encore fait la suite lors de ma réponse à cette question, mais c'est bien l'`ExpressionArithmetique` qui instancie et utilise le `Visitor`, dans ses méthodes de calcul et d'affichage de l'expression.

![isi3-tp2-b-3](images/isi3-tp2-b-3.png)

## Question 8
Pour ajouter de nouvelles opérations (`Visitors`) sur l'expression, j'ai identifié deux cas possibles : soit la structure de l'arbre n'a pas besoin d'être touchée, auquel cas les modifications seront mineures (simple copy-refactor d'un `Visitor` existant et adaptation de ses méthodes existantes, par exemple pour un affichage prefixe), soit il faut modifier les `Noeuds`. J'ai identifié deux situations dans lesquelles ce deuxième cas peut arriver : soit si au départ du projet l'architecture n'a pas été assez bien étudiée (par exemple, si je m'étais mieux penché sur le sujet, j'aurai ajouté directement les booléens pour la priorité plutôt qu'après coup), soit dans le cas d'une grosse évolution du projet, pour un cas de figure qui n'était pas envisagé au départ.

Si la structure existante des `Noeuds` doit changer, c'est un cas assez complexe, puisque ça va à l'encontre des principes SOLID, et il faut s'assurer que l'on ne modifie pas le comportement de l'existant, ça pourrait induire des modifications en cascade et le volume de travail pourrait vite exploser. Néanmoins, s'il 'suffit' de faire des ajouts dans les `Noeuds`, le travail va être fastidieux (dépendemment du nombre de noeuds, puisqu'il va falloir tous les modifier un à un), mais assez facile, puisqu'une fois la modification faite dans l'interface `Noeud`, nous sommes obligés de la répercuter dans tous les **noeuds concrets** et ne pouvons pas en oublier un, puisque le programme ne pourrait pas être compilé.



Ajouter de nouveaux types de noeuds est devenu très simple avec ce _design pattern Visitor_. En effet, il suffit de faire un copy-refactor d'un type de `Noeud` existant, de modifier son symbôle, et d'ajouter une méthode pour explorer ce noeud dans chacun des `Visitor` existants, et l'ont peut grandement s'inspirer des méthodes qui sont déjà faites. Par exemple, ajouter l'opération _'Division'_ ne prendrait certainement pas plus de 3 minutes en l'état actuel des choses.

De plus, comme on va ajouter la méthode visit(Division) directement dans la classe _abstraite_ `Visitor`, on ne peut pas oublier de l'ajouter dans une des classes filles, puisque le programme ne compilerait pas.

Comme c'est plutôt le nombre de `Noeuds` qui est voué à augmenter fortement plutôt que le nombre de `Visitors`, il est intéressant que le plus gros de l'ajout d'un nouveau `Noeud` se passe du côté des `Visitors`, diminuant ainsi le nombre d'opérations à faire. Si ce n'est pas le cas, c'est qu'il faut inverser le visitant et le visité !


En conclusion, avec une conception robuste et souple dès le départ, ce _design pattern Visitor_ nous permet de nous faciliter des possibilités d'évolution de notre projet dans plusieurs directions, et ce de manière assez facile à mettre en oeuvre (j'entends par là avec peu d'oublis possibles) grâce aux héritages et aux dépendances inhérents à la structure de ce pattern.