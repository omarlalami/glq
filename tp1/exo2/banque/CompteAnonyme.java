package banque;

public class CompteAnonyme {
		private static int nombreDeComptesCrees = 0;
		public static int nombreDeComptesUtilises = 0;
		private final int numero;
		private float solde;
		private final String debutTexteErreur ;
		
		public CompteAnonyme( float montant) {
			nombreDeComptesCrees++;;
			numero=nombreDeComptesCrees;
			nombreDeComptesUtilises++;
			solde=montant;
			debutTexteErreur=new String("Opération sur le compte n°" + numero + " : ");
		}
		
		public CompteAnonyme( ) {
			this(0);
		}
		
		@Override public void finalize() throws Throwable {
			nombreDeComptesUtilises--;
			super.finalize();
		}
		
		public float getSolde() {
			return solde;
		}
		
		public int getNumero() {
			return numero;
		}
		
		protected String getTypeToString() {
			return "Compte anonyme" ;
		}
		
		protected String finToString() {
			return ", solde = " + getSolde() + " euros";
		}
		
		@Override public String toString() {
			return( getTypeToString() + " n°" + numero + finToString());
		}
		
		protected void afficheTexteErreur(String messageErreur) { 
			System.err.println( debutTexteErreur + messageErreur);
		}

		public boolean depot( float montant )  {
			if (montant<0)
				throw new java.lang.IllegalArgumentException("le montant du depot doit etre positif !");
			
			if (montant == 2587)
				throw new java.lang.RuntimeException("erreur de test pour question 3");
			
			boolean depotEffectue = false;
			if ( montant <= 0)  afficheTexteErreur("Montant invalide");
			else { solde += montant ; depotEffectue = true; }
			return depotEffectue;
		}

		public void retrait( float montant ) {
			if (montant<0)
				throw new java.lang.IllegalArgumentException("le montant du retrait doit etre positif !");
			
			if ( montant <= 0) afficheTexteErreur("Montant invalide");
			else solde -= montant ;
		}
		
		
		// je n'ai pas compris pourquoi rajouter throws Exception a la methode virement et pas a depot ...
		// si c'est une exception de type Exception mais si c'est une exception de IllegalArgumentException ca passe
		public static void virement( CompteAnonyme source, CompteAnonyme dest, float montant) {
			if (montant<0)
				throw new java.lang.IllegalArgumentException("le montant du virement doit etre positif !");
			if (montant > source.getSolde())
				throw new ExceptionSoldeInsuffisant("le compte source n'a pas le montant suffisant");
			
			if ( montant <= 0) source.afficheTexteErreur("Montant invalide");
			else if ( montant > source.getSolde() ) source.afficheTexteErreur("Solde insuffisant");
			else if (dest.depot( montant)) source.retrait( montant);
		}
}	