package outils;

import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;

import exo1.AFaire;

@SupportedAnnotationTypes(value = { "*" })
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class ProcesseurAFaire extends AbstractProcessor {
	@Override
	public boolean process ( Set<? extends TypeElement> annotations
							, RoundEnvironment env) {
				Messager messager = processingEnv.getMessager();
				for (TypeElement te : annotations) {
					messager.printMessage(Kind.NOTE, "*** Traitement annotation "
							+ te.getQualifiedName()+ " ***");
					for (Element element : env.getElementsAnnotatedWith(te)) {
						messager.printMessage(Kind.NOTE, "    element "
								+ element.getSimpleName());
						AFaire a = element.getAnnotation(AFaire.class);
						if (a != null) {
							messager.printMessage(Kind.NOTE, "    "+ a.descrption_tache() + " ["+a.niveau() 
									+ "]  affecte a "+a.nom_developpeur() + " le " + a.d());
						}
					}
				}
	 return true;
	}
}
/*Commande : javac -d ../bin -processorpath ../bin -processor outils.ProcesseurAFaire test/TestAFaire.java
  Resultat :
Note: *** Traitement annotation outils.AFaire ***
Note:     element TestAFaire
Note:      [NORMAL]  affecte a  le 
Note:     element m1
Note:     Algorithme de parcours √  optimiser [NORMAL]  affecte a  le 
Note:     element m2
Note:     Ajouter le traitement des erreurs [NORMAL]  affecte a  le 
Note:     element m3
Note:     m√©thode √  √©crire [MAJEUR]  affecte a  le 
Note:     element a4
Note:     A remplacer par une liste [MINEUR]  affecte a Marc Assin le 08/01/2012
Note: *** Traitement annotation java.lang.Deprecated ***
Note:     element main
*/