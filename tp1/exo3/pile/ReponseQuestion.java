package pile;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReponseQuestion {

	
	// question 1
	// annotation @overeride :
	/*Le mot-clé @override est utilisé pour définir une méthode qui est héritée de la classe parente.
	 *  On ne l'utilise donc que dans le cas de l'héritage. 
	 *  En plaçant ce mot-clé dans le commentaire de la méthode réécrite,
	 *   le compilateur vérifiera que la méthode est correctement utilisée (mêmes arguments, même type de valeur de retour)
	 *   et affichera un message d'avertissement si ce n'est pas le cas.
	
	*/
	
	
	// question 2
	// je ne voi pas vraiment de chose a corrigé intéréssante
	
	
	
	
	// questio 3
	// non aucun bug détécter
	
	
	// question 4 : voir pilebornee.java
	// ca depend des tests, mais concernant celle ou ya des assertions il ne pourra pas
	// par exemple d�piler si la pile est vide ...

	public static void main(String[] args) {

		// question 5:
	
		
		// les trucs qui provoque erreur :
		
		
		try {new PileBornee(-2); throw new Error("bug"); } catch( IllegalArgumentException e ) {}
		// les asserts on les mets quand on est sure qu'un cas ne va pas arriv� !
		// si on est sur que pilebornnee ne va jamais recevoir un nombre negatif on met assert
		// sinon on met if max < 0 throw new exception et ici on test dans throw !
		// c'est deux principe un peu different
		
		/*
		PileBornee p1 = new PileBornee(1);
		p1.empile(5);
		p1.empile(null);
		*/
	
		/*
		PileBornee p1 = new PileBornee(10);
		p1.depile();
		*/
		
		/*
		PileBornee p1 = new PileBornee(10);
		p1.sommet();
		*/
		
		/*
		PileBornee p1 = new PileBornee(10);
		p1.empile(5);
		p1.depile();
		*/

		
		// les trucs qui passent
	
		PileBornee p10 = new PileBornee(20);
		p10.empile(5);
		p10.empile(2);
		p10.empile(3);
		
		assert ((Integer)p10.sommet()) == 3;
		assert p10.estVide() ==false;
		assert p10.estPleine() ==false;
		assert ((Integer)p10.depile()) == 3;
		assert ((Integer)p10.sommet()) == 2;

		assert false : "sa passe";

		// question 6 : on doit la finir
		
		//voir les photo pour savoir comment on fait
		// la classe a generer : PileBorneeTest
		// bouton droit sur PileBornee->new JUnit test case
		// on coche les bouton setUp setupbeforeclass teardown teardownafterclass generatecomment
		// next -> on choisi les fonctions a tester -> finish-> on a notre squellette
		// reste qu'a completer les fonction
		
		// on a un taux de couverture qui touche toutes les methodes
		
		
		
		// question 7
		// remarque : j'ai générer la doc, c'est intéréssant, a l'aide des commentaire on a tous qui est fait

		
		
		// question 8 :
		// j'ai pas compris
		
		
		// prof a demander :
		// remarque : pourquoi etre obligé denlever static dans PieBorneeTest pour BeforeALL
		// pourquoi dans testDepile() assertThrows ne fonctionne pas comme dans testPileBornee()

		
		// c'est comme la 7 mais faut utiliser : export javadoc et mettre la doclet madocclass
		
		
	}


}
