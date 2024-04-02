#Génie Logiciel Avancé

#Travaux pratiques - Tests unitaires avec JUnit

1-	Creation de la classe Money

2-	Creation de la classe MoneyTest avec la methode testSimpleAdd


3-	Lors de l’execution du code, une erreur s’affiche, affirmant l’echec du test. Cela est du a une erreur dans la classe MoneyTest(), notamment  au niveau de la methode equals() dans la classe Money.

4-	la methode TestEquals()

5-	Malgré les mêmes valeurs attribuées (12 pour Amount et "CHF" pour Currency), le test échoue à nouveau. La méthode equals() ne compare pas correctement ces attributs et considère donc que ce sont deux objets distincts.

6-	En surchargeant la méthode equals(), le test réussit et la barre de progression change de couleur pour devenir verte.

7-	annotation de @before dans Money.java

8-	Creation de la classe MoneyBag et la methode equals()

9-	Creation de la classe MoneyBagTest

10-	Les tests sont positifs, ce qui confirme que la classe MoneyBag() fonctionne correctement.

11-	La suite de tests, AllTests.

12-	Des méthodes telles que testMixedSimpleAdd, testBagSimpleAdd, testSimpleBagAdd et testBagBagAdd ont été écrites dans MoneyBagTest.java.

13-	Des modifications ont été apportées et le code a été compilé pour assurer le bon fonctionnement des méthodes précédemment mentionnées.

14-	Si nécessaire, les objets MoneyBag ont été simplifiés en objets Money pour faciliter les opérations et les tests.

15-	Tous les tests ont été vérifiés avec succès et le projet s'exécute désormais sans erreur.
