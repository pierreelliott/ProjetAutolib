# Autolib' - Module client

J'ai importé le projet oeuvre pour faire l'appli cliente, donc c'est normal s'il 
reste du code mort. C'est soit pour garder des exemples directement sous la main, 
soit pour éviter les petites vagues rouges (et les erreurs de compilation qui 
vont avec).

## Notes

### Borne

La propriété `etatBorne` est un booléen précisant s'il y a un véhicule ou non. `True` 
si elle est vide, `False` s'il y a un véhicule.

## Architecture

### Java

* bo : les classes Entity (BO = Business Object)
* controllers : plutôt évident
* dto : les équivalents des classes Entity mais simplifiées, utilisées avec 
Hibernate (DTO = Data Transfer Object)
* repositories : les accès à la BD pour chaque Entity
* utilitaires : plutôt évident

Dans les classes Entity, si l'on souhaite ajouter une propriété qui n'a pas vocation 
à être insérée en BD, on peut rajouter `@Transient`.

Afin de ne pas avoir à réécrire le PATH des différentes vues, j'ai fait des 
constantes dans la classe utilitaire `Vues` (j'ai laissé des exemples).

Règle tacite : si un champ de la base est un `VARCHAR` avec des valeurs fixes, on 
crée un `Enum` pour éviter les erreurs.

### Vues

Les vues utilisent un principe de Layout (pour ne pas s'emmerder à tout réécrire
à chaque fois).  
Pour ce faire, on a un tag (**layout.tag**) qui comporte le code de base d'une page 
HTML, l'import des scripts/librairies/... et des navbar et footer.

On peut utiliser ce tag dans d'autres pages JSP grâce à :
```
<t:layout>
    <jsp:attribute name="title">Titre de ma page</jsp:attribute>
    <jsp:body>
        // Mon code HTML
    </jsp:body>
</t:layout>
```

Chaque vue est dispatchée dans un dossier en fonction de sa fonction : tout ce 
qui concerne l'affichage/gestion des stations se trouve dans le dossier `stations`.