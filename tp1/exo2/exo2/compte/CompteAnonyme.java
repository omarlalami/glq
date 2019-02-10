package exo2.compte;

import exo2.personne.Personne;

public class CompteAnonyme {
		private static int nombreDeComptesCrees = 0;
		public static int nombreDeComptesUtilises = 0;
		private final int numero;
		private float solde;
		protected final String debutTexteErreur ;
		
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
		
		public String getTypeToString() {
			return "Compte anonyme";
		}
		
		@Override public String toString() {
			return( getTypeToString() + " n°" + numero + ", solde = " + solde + " euros");
		}
		
		public void depot( float montant ) {
			if ( montant <= 0)	
				throw new IllegalArgumentException( debutTexteErreur + "Montant invalide");
			else 
				solde += montant ;
		}

		public void retrait( float montant ) {
			if ( montant <= 0) 
				throw new IllegalArgumentException( debutTexteErreur + "Montant invalide");
			else 
				solde -= montant ;
		}
		
		public static void virement( CompteAnonyme source, CompteAnonyme dest, float montant) 
		                   throws ExceptionSoldeInsuffisant {
			if ( source.getSolde() >= montant ) { 
					dest.depot( montant);
					source.retrait( montant);
			}
			else
				throw new ExceptionSoldeInsuffisant( source.debutTexteErreur + "Solde insuffisant"); 
			
		}
}	