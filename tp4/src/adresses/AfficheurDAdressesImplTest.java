package adresses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AfficheurDAdressesImplTest {

	private AfficheurDAdresses afficheur;
	private ChercheurDAdresses chercheur;
	
	
	@BeforeEach
	void setUp() {
		chercheur = mock( ChercheurDAdresses.class);
		when(chercheur.chercher("Laurent Jamaire")).thenReturn(
				new Adresse("Laurent Jamaire", 10, "Rue des sourires", 61290, "Bizou"));
		when(chercheur.chercher("Nordine Hatteur")).thenReturn(
				new Adresse("Nordine Hatteur", "Rue du Bas du Tiers du Milieu", 58170, "Poil"));
		when(chercheur.chercher("Charles Attan")).thenReturn( null);
		when(chercheur.chercher("Deborah Daigou")).thenReturn(
				new Adresse("Deborah Daigou", 0, "Rue du chat qui danse", 22240, "Plurien"));
		afficheur = new AfficheurDAdressesImpl( chercheur);
	}

	@Test
	public void test1() {
		assertThrows(IllegalArgumentException.class, () -> afficheur.afficher("Charles Attan"));
	}
	
	@Test
	public void test2() {
		assertEquals( "Laurent Jamaire\n10 Rue des sourires\n61290 Bizou", 
				afficheur.afficher("Laurent Jamaire"));
		assertEquals( "Nordine Hatteur\nRue du Bas du Tiers du Milieu\n58170 Poil", 
				afficheur.afficher("Nordine Hatteur"));
		assertEquals( "Deborah Daigou\nRue du chat qui danse\n22240 Plurien", 
				afficheur.afficher("Deborah Daigou"));
	}

}
