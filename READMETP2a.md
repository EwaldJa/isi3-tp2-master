# ISI3 Apprentis TP 2a: Design Pattern Decorateur
Laëtitia Matignon

> Le rapport est à saisir dans le ficher [RAPPORTTP2a.md](RAPPORTTP2a.md) en utilisant le [formalisme MarkDown](https://guides.github.com/features/mastering-markdown/).

## Enoncé/contexte

A un distributeur de Cafés, les clients ont le choix entre 3 types de Café: Colombia (0.5€), Expresso (0.6€), et Deca (0.4€). 

### Itération 1

On souhaite pouvoir afficher le nom et le prix du Café choisi.

- proposez une solution que vous implémenterez dans le [package exerciceCafe1](../src/exerciceCafe1/). 


### Itération 2

On souhaite maintenant pouvoir ajouter des suppléments aux boissons : Lait, Sucre, Caramel, Chantilly. L'ajout de sucre ou de lait est facturé 0.1€, de caramel 0.2€ et de chantilly 0.4€. 

- modifiez la solution précédente ; vous mettrez votre code dans le [package exerciceCafe2](../src/exerciceCafe2/). 
- testez en affichant le prix d’un *Expresso avec sucre*, et d’un *Colombia Chantilly Caramel*.
- présentez votre solution en donnant le diagramme de classes
- discutez la facilité d’ajouter de nouveaux éléments (boissons et suppléments) 
- conclusion(s) ?

### Itération 3: Pattern Décorateur

Refactorer en utilisant le design pattern Décorateur. Vous mettrez votre code dans le [package exerciceCafe3](../src/exerciceCafe3/). 

- testez en affichant le prix d’un Expresso avec sucre, et d’un Colombia Chantilly Caramel.
- présentez votre solution en donnant le diagramme de classes et en expliquant comment vous avez appliqué de design pattern Decorateur
- discutez la facilité d’ajouter de nouveaux éléments (boissons et suppléments) 
- conclusion(s) ?

