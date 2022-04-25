# mvcpatients1

<h1> Activité pratique N°3 JEE : Spring MVC, Thymeleaf, Spring Data et Spring Security
</h1>
<h2 style="text-decoration: underline;">1- objectif:</h2>
<div>
<p>Développer une application web baseé sur Sprint MVC, ThymeLeaf et Spring Data qui permet de gérer des patients.</p>
<p>L' Application doit permettre de : </p>
<ul>
<li> Chercher des Patients avec Pagination  </li>
<li> Supprimer un Pateint </li>
<li> Ajouter un Payient avec validation du formulaire </li>
<li> Editer et Mettre A jour un Patient </li>
<li>cree une page Template basée sur Thymeleaf Layout</li>
</ul>
</div>
<h2 style="text-decoration: underline;">2- Architectur :</h2>
<p><img src="README_imaged/archn3.png"></p>
<div>
<h2 style="text-decoration: underline;">3- Travail a faire</h2>

<ol type="1">

<dt><li> Cree un projet Spring Boot avec les dépendances </li></dt>
<dd>Spring DATA JPA , H2, Web ,themeleaf st Lombok </dd>
<dt><li>Créer La couche DAO</li></dt>
<dd>
<ul>
<li>Cree l'entite jpa Patient</li>
<li> cree L'interface Patient Repository basée sur Spring DAta </li>
<li>Tester la couche Dao</li>
</ul> 
</dd>
<dt><li>Créer la couche web </li></dt>
<ul>
<dd><li> Creer le controleur Spring MVC</li>
<li>Cree les vue basee sur le moteur de Templates Thymeleafe </li>
</dd>
</ul>
</ol>
</div>
<div>
<h2 style="text-decoration: underline;">4-Créer La couche DAO</h2>
<img src="README_imaged/Prespo.png">

</div>
<div>
<h2 style="text-decoration: underline;">5- Créer la couche web</h2>
<h3> le controller </h3>
<div><img src="README_imaged/img_4.png">
<p>  se controller contient le pagination </p> </div>

<h3> patients html </h3>
<img src="README_imaged/img_5.png">
<p>Remarque tous les attributs que vous avez ajoter dans le model thymlef peut lacceder </p>
<hr>
<p>la pagination dnas template </p>
<img src="README_imaged/img_6.png">
</div>
<div>
<h2 style="text-decoration: underline;">6- Validation </h2>

<p> pour valider les attributes de donnee </p>
<img src="README_imaged/img_7.png">
<p>au niveau de controller ajouter "bindingressult" et @valide pour Patient </p>



</div>


<hr> 
<h1>  Spring Security : Activité pratique N°4 ; Spring Boot Spring MVC Thymeleaf Spring Securiry User Details Service: </h1>
<div>
<div>
            <h2 style="text-decoration: underline;">1- objectif:</h2>
        <p>
            Sécuriser L'accés a l'Application 
            qui permet de géer les Patients en utilisant Spring Security . L'accées à L'aplication nécessite une Authentification avec
            un Username et mot de passe .un utilisateur peut avoir plusieurs Role ;
        </p>
        <dl>
          <dt>ROLE_USER:</dt>
          <dd >-permettant de chercher des patients</dd>
          <dt>Role_ADMIN</dt>
          <dd>- permettant d'ajouter, mettre àajour et supprimer les patients</dd>
        </dl>


</div>
<div>
 <h2 style="text-decoration: underline;">2- Architectur :</h2>
    <img src="./README_imaged/architecteur.png"/>


</div>
<div>
<h2 style="text-decoration: underline;">2- Travail a faire :</h2>
<p> </p>
<ol type="1">
  <li>Ajouter la dépendance maven de Spring Security  </li>
  <li>Personnaliser la configuration de Spring Security Suivantes avec la Startégie InMemoryAuthentication  
<dl>
  <dt>-Auhtentification avec le Role USER pour pouvoir Consulter Les Patients</dt>
  <dt>-Authentification Avec le role ADMIN pour pouvoir Ajouter ,Editer,mettre à  jour et supprimer des Patients </dt>
    <dt> -permettre l'accés aux ressources statique (/webJars/**) sans aucune authentification </dt> 
</dl>
</li>

<li> Basculer de La Statégie InMemory Authentification Vers JDBCD Authentification </li>
<li>Basculer Vers La Stratégie UserDetailsService </li>


</ol>

</div>

<div>
 <h2 style="text-decoration: underline;">3- Ajouter la dépendance maven de Spring Security:</h2>
<img src="./README_imaged/mavenSEC.png"/>
</div>
<div>
 <h2 style="text-decoration: underline;">4 -Personnaliser la configuration de Spring Security Suivantes avec la Startégie InMemoryAuthentication</h2>
<img src="./README_imaged/secConfigure.png"/>
<p>
<span> deux condition : </span>
        
<dl>
        <dt> @Configuration;</dt>
        <dd>c'est une class de configuration le sprint sera instancier le 1er </dd>
        <dt> @EnableWebSecurity </dt>
        <dd>Activer la security Web </dd>
        
</dl>
    
<img src="./README_imaged/vonfigurs.png"/>
    <dl>
        <dt>AuthenticationManagerBuilder</dt>
        <dd>comment spring security chercher les users est les roles "ldap/database/mimory"
        <ol type="1">
      <li>InMemoryAuthentication</li>
    <img src="README_imaged/inmemory.png"/>
    </ol>
    </dd>
        <dt> HttpSecurity </dt>
        <dd>
    securiser les urls
    <img src="README_imaged/configurhttp.png"/>
<span> meme l'utilisateur essaies par les urls il n'avait pas les droit </span>
<span> pour sela i l faut de chenger tous les urls (frompatient,editPatients..)</span>


    
</dd>
    
</dl>



<h3 style="text-decoration: underline;"> La contextuality :  </h3>
<p></p>
<ol>


<dl>

<dt> Template :</dt>
<dd>   <p>   xmlns:sec="http://www.thymeleaf.org/extras/spring-security"></p>
 <span> isauthenticated =si seulement si  l user est authentifier </span>
<img src="README_imaged/templat.png">

</dd>

<dt> suprimmer et Editer   </dt>

<dd> <img src="README_imaged/addsup.png"></dd>

<dt> show  unanutherized Action 403 </dt>

<dd> <img src="/README_imaged/403.png"> </dd>

</dl>



</ol>



</div>

<div>
<h3 style="text-decoration: underline;">5- Basculer de La Statégie InMemory Authentification Vers JDBCD Authentification
</h3>
<h4> 1- Add dans la base  de donnée des usesr and Roles  </h4>
<img src="README_imaged/user_rol.png">
<img src="README_imaged/users.png" >
<img src="README_imaged/Role.png">
<img src="README_imaged/uses_roles.png">
<h4>2-SecurityConfig </h4>
<img src="README_imaged/jdbcSecConf.png">
<ol  type="i">

<dl>
<li>
<dt>database source </dt>
</li>
<li>
<dt>1er requet Sql </dt>
<dd> - chercher l utilisateur </dd>
</li>
<li>
<dt>2eme requet SQL </dt>
<dd> -charger les roles de cet utlisateur </dd>
</li>
<li>
<dt>donne les droites d'accès a les resource statique</dt>
<dd> <img src="README_imaged/webjars.png"> </dd>
</li>
</dl>


</ol>


<div>
<h3 style="text-decoration: underline;">5-Basculer Vers La Stratégie UserDetailsService</h3>

<ol type="1">

<dl>

<li><dt>gérer les utilisateurs et les Roles</dt>
<dd>
<ul>
<li>
cree les class APPUser et APPRole <img src="README_imaged/APPUR.png">

</li>
<li>la class AppUser : EAGER(charger les role tous les role de l utilistaeur au memoire "
lazy = getApproles() )
<img src="README_imaged/APPUser.png">
</li>
<li>Class AppRole <img src="README_imaged/AppRole.png"></li>
<li>--------<img src="README_imaged/img_1.png"></li>
</ul>
 
</dd>
</li>
<li><dt>Service</dt></li>
<dd>
<ul>
<li>SecurityService : une interface pour declarer les methode
<img src="README_imaged/SecService.png"></li>
<li>une implementation : pour implementer les methodes <img src="README_imaged/SSimpl.png"> </li>
<li>implement UserDetailsService ;<img src="README_imaged/UDS.png"></li>
<li>security  configure : <img src="README_imaged/img.png"> </li>
<li> Remarque !! pour la dependance circulair soit :
<dl><dt> 1er method :</dt>
<dd><img src="README_imaged/img_2.png"> </dd>
<dt> 2eme methode : lorigine de probleme dans securityConfigue il sefait de sortire password incouder dans le main :</dt>
<dd><img src="README_imaged/img_3.png"></dd>

</dl>

</li>
</ul>
</dd>

</dl>
</ol>


</div>

</div>
</div>





