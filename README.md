# Application CocktailBar
Démontration d'utilisation de Git au travers d'un projet J2EE permettant la gestion de cocktails.

## Sujet
Le patron d'un bar souhaite avoir une application Web qui répond au besoin suivant :
- Une page accessible par tout le monde permet de lister et rechercher des cocktails
- Une page reservée au patron permet de gérer tous les ingrédients disponibles dans le bar
  - Chaque ingrédient a un nom et un état (solide, liquide, gazeux)
- Une page réservée au barman permet de gérer tous les cocktails que peut proposer le bar
  - Chaque cocktail a un nom et une liste d'ingrédient avec leurs quantités associées

## Outils et frameworks utilisés
- Java 8
  - Servlet & HTTP
  - JSP et l'Expression Language (EL)
- Eclipse
- Maven
- Spring
  - context : core, beans, aop
  - webmvc : web, expression
  - data-jpa : data-commons, orm, jdbc, tx
- Hibernate (avec validator)
- Webjars
  - Bootstrap
  - JQuery & JQuery-UI
  - Datatables (plugin de JQuery)

## Architecture de l'application
<img src="https://docs.google.com/drawings/d/1UbdNEGL67yeau8a8nxw76QSDRa_D8l9ryGS1ctQoxy4/pub?w=784&h=394">

## Explication sur les annotations utilisées
- Annotations J2EE : [https://github.com/Elvynia/formation-test/wiki#annotations-j2ee]
- Annotations Spring : [https://github.com/Elvynia/formation-test/wiki#annotations-spring]
