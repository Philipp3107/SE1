# SE1

Software Engeneering 1

## Inhaltsverzeichis
* [Guidlines fürs Arbeiten](#guidlines-für-das-arbeiten)</br>
* [SL1](#sl-1)</br>
* [SL2](#sl-2)</br>
  * [SCM](#scm)</br>

# Studienleistungen
### Guidlines für das Arbeiten
### Step 1: Pull des aktuellen standes vom Repo

```shell
git pull origin main
```

---

### Step 2: Erstellen einer neuen feature Branch
**Branch name nicht vergessen!!!**
```shell
git checkout -b
```
---

### Step 3: Push der änderungen auf den feature Branch

```shell
git push origin "branchname"
```
---

### Step 4: Vor dem merge

Pull des aktuellen Standes von `main` und merge in dem `feature-branch` und löse alle Mergekonflikte auf

```shell
git pull origin main
```

---

### Step 5: Erstelle einen Pullrequest auf Github:

Gehe zu [diesem Repo](https://github.com/Philipp3107/SE1/pulls) und erstelle einen Pullrequest

### Step 6: Löschen der gemergten Branch

Auf Github gehe zu [alle branches](https://github.com/Philipp3107/SE1/branches) und lösche diesen 

Lass dir alle branches in deinem lokalen verzeichnis anzeigen:
```shell
git branch
```

Führe folgenden Befehl aus um den Branch bei dir lokal zu löschen:
```shell
git branch -d "branchname"
```

# SL 1
https://github.com/Philipp3107/SE1#studienleistungen

---

# SL 2

### Clone den aktuellen Stand vom Repo

```shell
git clone https://github.com/Philipp3107/SE1.git
```

### Erstellen eines Maven-Projekts in der Commandline
Sollte der Pull über das Repos nicht funktioieren, kann man in Intellij ein JavaFX Projekt mit Maven erstellen oder über die Commandline folgendes ausführen:
```shell
mvn archetype:generate 
-DgroupId=com.mycompany.app 
-DartifactId=my-app 
-DarchetypeArtifactId=maven-archetype-quickstart 
-DarchetypeVersion=1.4 
-DinteractiveMode=true
```

## SCM

