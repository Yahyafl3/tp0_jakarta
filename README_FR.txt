PROJET TP0 JAKARTA EE — VERSION AVEC BONUS PERSONNEL

IMPORTANT SUR LA SOURCE
Cette archive est construite à partir du seul ZIP de projet disponible dans la conversation (dépôt de Yassine), puis adaptée : package renommé en ma.emsi.tp0 et traitement de GenerateurReponse remplacé. Le dépôt personnel de l'étudiant n'a pas été fourni.
Les fichiers de correction HTML officiels du professeur n'ont pas pu être récupérés. La structure correspond aux consignes disponibles, mais cette archive ne doit pas être présentée comme une copie certifiée ligne par ligne du code officiel.

CODE DE BASE DU TP
- Bb.java : backing bean JSF, portée ViewScoped, gestion de l'état de la conversation, validation d'une question vide et démarrage d'un nouveau chat.
- index.xhtml : interface JSF/PrimeFaces.
- WEB-INF/web.xml : configure index.xhtml comme page d'accueil.
- pom.xml, beans.xml, persistence.xml : configuration du projet disponible dans l'archive source.

BONUS PERSONNEL
Le fichier actif src/main/java/ma/emsi/tp0/service/GenerateurReponse.java implémente un traitement personnel différent de celui de Yassine :
1. détecter si la phrase ressemble à une question, une demande ou une affirmation ;
2. fournir une piste de réponse adaptée au type détecté.
Ce traitement est local et ne fait pas appel à une API d'IA.

COMPORTEMENT DE BASE DÉCRIT DANS LES CONSIGNES
Les consignes décrivent le service de base comme un traitement qui ajoute le rôle système en majuscules au début (s'il est fourni), puis renvoie la question en minuscules entourée par ||. Le fichier actif est remplacé par le bonus, conformément à l'exercice. La copie exacte du fichier officiel n'a pas été vérifiée.

POUR LANCER
1. Ouvrir le dossier dans IntelliJ IDEA comme projet Maven.
2. Vérifier que la version de Java et le serveur Payara correspondent aux dépendances du pom.xml.
3. Recharger les dépendances Maven.
4. Déployer l'application sur un serveur compatible Jakarta EE et ouvrir index.xhtml.
5. Tester une question avec ?, une demande commençant par « Peux-tu », puis une affirmation.

À NOTER
Le projet source utilisait Java 25, Jakarta EE Web API 11 et PrimeFaces 16. Il faut donc vérifier que l'installation locale de Payara prend en charge ces versions. Aucun déploiement réel n'a été exécuté dans cet environnement.
