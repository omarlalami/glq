package tp2.fibonacci;

public class Fibonnaci {
	
	
	static int fibonacci(int n, int f0, int f1) throws Exception {
		
		// Assertion demandés q2 : les assertations detectente bien le probleme !
		
	/*	
	    assert f0>=0 : "probleme f0 neg"+f0;
		assert f1>=0 : "probleme f1 neg"+f1;
		assert f1>=f0: "probleme f1<f0"+f1+" "+f0;
	*/
		// exception demandés q5
		
		if(f0<0 || f1<0 || f1<f0)
			throw new Exception();
		
	    return n<=0 ? f0 : fibonacci(n-1, f1, f1+f0);
	}
	

}