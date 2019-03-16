package personnes;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


public class Personnes {
	static final Comparator<IPersonne> ORDRE_PAR_AGE = new Comparator<IPersonne>() {
		public int compare( IPersonne p1, IPersonne p2) {
			return p1.getAge() - p2.getAge();
		}
	};
	static public int lePlusGrandAge(List<IPersonne> l, Date d) {
		return Collections.max(l,ORDRE_PAR_AGE).getAge(d);
	}
	static public int lePlusGrandAge(List<IPersonne> l) {
		return Collections.max(l,ORDRE_PAR_AGE).getAge();
	}
}