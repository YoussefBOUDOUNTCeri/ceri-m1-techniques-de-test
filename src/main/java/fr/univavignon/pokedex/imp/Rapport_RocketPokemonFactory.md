# Rapport d'audit : RocketPokemonFactory

---

## **Défauts trouvés dans RocketPokemonFactory**

### 1. Inefficacité dans la méthode `generateRandomStat`

- **Problème** : La méthode utilisait une boucle de 1 000 000 d'itérations pour calculer une statistique pseudo-aléatoire.

### 2. Variables locales non déclarées comme `final`

- **Problème** : Les variables telles que `name`, `attack`, `defense`, `stamina`, et `iv` n'étaient pas en "final".

### 3. Typage explicite redondant dans `HashMap`

- **Problème** : Le typage explicite `<Integer, String>` était répété lors de l'initialisation de la `HashMap`. Cela n’est pas nécessaire avec les versions modernes de Java (7+).

### 4. Complexité inutile dans la déclaration de `index2name`

- **Problème** : La structure n’était pas définie comme `final`, bien qu’elle soit immuable après son initialisation.

---

## **Améliorations apportées**

### 1. Optimisation de `generateRandomStat`

- **Solution** : La boucle de 1 000 000 d’itérations a été remplacée par une méthode simple et efficace utilisant `new Random().nextInt(16)`.

### 2. Ajout du mot-clé `final` aux variables 

- **Solution** : Toutes les variables immuables (ex. `name`, `attack`, `defense`, etc.) ont été déclarées avec `final`.

### 3. Utilisation de l’opérateur (`<>`) pour `HashMap`

- **Solution** : Le typage explicite a été remplacé par l'opérateur `<>`) lors de l’instanciation.

### 4. Définition de `index2name` comme `final`

- **Solution** : La variable `index2name` a été marquée comme `final`, indiquant clairement son caractère immuable.
