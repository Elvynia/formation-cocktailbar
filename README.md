# Application CocktailBar
Démontration d'utilisation de Git au travers d'un projet J2EE permettant la gestion de cocktails.

## Sujet
Le PDG d'une chaîne de bar réputée pour ses cocktails uniques souhaite pouvoir gérer les stocks de ses différents bars informatiquement, de manière à ce que des alertes permettent aux gérants de chaque bar d'être prévenus avant une rupture de stock. Il vous impose de créer une application Web car il a besoin des choses suivantes :
- La liste des cocktails et leurs ingrédients doit être visible par le public. Les quantités et certains ingrédients doivent rester secrets
- Un compte de barman doit permettre de créer et gérer les cocktails avec les ingrédients et quantités associées
- Un compte de gérant doit permettre de surveiller et mettre à jour le stock des ingrédients
- Seul le directeur peut faire les choses suivantes :
  - Créer, gérer et archiver des comptes utilisateurs
  - Créer et supprimer des ingrédients, ainsi que donner la limite de stock qui lance l'alerte
  - Créer et gérer des cocktails qui devront être présents dans chaque bar

Tous les soirs, chaque gérant doit mettre à jour le stock des ingrédients. Une page doit proposer de facilement rechercher les cocktails et les ajouter à un panier avec une quantité associée. Lorsque le gérant valide le panier, une page doit afficher le stock restant des ingrédients utilisés dans la journée. Si la limite est dépassée, l'ingrédient doit être distingué par une couleur rouge. Le gérant doit alors immédiatement passer commande au fournisseurs correspondants, et confirmer par un bouton qu'il a bien géré chaque alerte. Lorsqu'une alerte est gérée, elle doit apparaître en orange.


## Outils et frameworks utilisés
- Java 8
  - Servlet & HTTP
  - JSP et l'Expression Language (EL)
- Eclipse Neon
- Maven 3
- Spring 4
  - context : core, beans, aop
  - webmvc : web, expression
  - data-jpa : data-commons, orm, jdbc, tx
- Hibernate 5 (avec validator)
- Webjars
  - Bootstrap 3
  - JQuery & JQuery-UI
  - Datatables (plugin de JQuery)

## Architecture de l'application
<img src="https://docs.google.com/drawings/d/1UbdNEGL67yeau8a8nxw76QSDRa_D8l9ryGS1ctQoxy4/pub?w=784&h=394">

## Explication sur les annotations utilisées
- Annotations J2EE : [https://github.com/Elvynia/formation-test/wiki#annotations-j2ee]
- Annotations Spring : [https://github.com/Elvynia/formation-test/wiki#annotations-spring]