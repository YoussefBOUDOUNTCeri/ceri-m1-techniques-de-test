# Projet Pokedex API

## Badges
[![CircleCI](https://dl.circleci.com/status-badge/img/gh/YoussefBOUDOUNTCeri/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/YoussefBOUDOUNTCeri/ceri-m1-techniques-de-test/tree/master)
[![codecov](https://codecov.io/github/YoussefBOUDOUNTCeri/ceri-m1-techniques-de-test/graph/badge.svg?token=88FT42MOIW)](https://codecov.io/github/YoussefBOUDOUNTCeri/ceri-m1-techniques-de-test)

## Auteurs

**Nom :** Youssef Boudount
**Groupe :** M1 ILSEN G1 ALT

## Description du projet

Ce projet consiste en une implémentation d'une API Pokedex qui permet de gérer et de stocker des informations sur les Pokémon de la première génération. L'API expose plusieurs fonctionnalités telles que :

- Création et gestion de Pokémon.
- Fourniture des métadonnées des espèces de Pokémon (nom, attaque, défense, endurance).
- Gestion des dresseurs et de leurs équipes.
- Comparaison de Pokémon selon différents critères (nom, index, CP).

L'API est conçue pour être extensible, testable, et simple à maintenir.

## Structure du projet

Le projet est organisé de manière modulaire, en utilisant des interfaces pour les principales entités :

- **IPokedex** : Interface principale du Pokedex, permettant de stocker et de manipuler des Pokémon.
- **IPokemonFactory** : Interface pour la création d'instances de Pokémon.
- **IPokemonMetadataProvider** : Fournit les métadonnées d'une espèce de Pokémon.
- **IPokemonTrainerFactory** : Permet de créer des instances de dresseurs de Pokémon.

Chaque interface est testée via des mocks et des tests unitaires créés avec **Mockito**.

## Installation

### Prérequis

- **Java 8** ou version supérieure.
- **Maven** pour la gestion des dépendances.
- Accès à **CircleCI** et **Codecov** pour l'intégration continue et les rapports de couverture de test.

### Étapes d'installation

1. Clonez le repository :

```bash
git clone https://github.com/YoussefBOUDOUNTCeri/ceri-m1-techniques-de-test
cd ceri-m1-techniques-de-test
```

2. Installez les dépendances Maven :

```bash
mvn clean install
```

3. Lancez les tests unitaires :

```bash
mvn test
```

4. Générez le rapport de couverture de test avec JaCoCo :

```bash
mvn jacoco:report
```
