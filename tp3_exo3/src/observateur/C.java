package observateur;

import observateur.Observable;
import observateur.Observe;

@Observable 
public class C {
    @Observe 
    private int att1;
    private String att2;
    
    public C() {
    	att1 = 0;
    	att2 = null;
     }
    
	public int getAtt1() {
		return att1;
	}
	public void setAtt1(int att1) {
		this.att1 = att1;
	}
	public String getAtt2() {
		return att2;
	}
	public void setAtt2(String att2) {
		this.att2 = att2;
	}
	public String toString() {
		return "["+ att1 + " " + att2 + "]";
	}
	public static void main(String[] args) {
		C c = new C();
		c.setAtt1(1);
		c.setAtt1(2);
		c.setAtt2("Toto");
	}
}