package aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TraceFibonacci {

	@Pointcut ("execution(long fibonacci.Fibonacci.fibonacci(long)) && args(n)")
    public void pcAppelFibonacci(long n) { }
	
	@Pointcut ("pcAppelFibonacci(n) && !cflowbelow(pcAppelFibonacci(long))")
    public void pcAppelFibonacciNonRecursif(long n) { }

	@Before ("pcAppelFibonacci(n)") 
    public void debut(long n) {		
		System.out.println(">fibonacci("+ n +")");
	}

	@AfterReturning(pointcut="pcAppelFibonacci(n)", returning="val") 
	public void fin(long n, Object val) {
		System.out.println(val +" = fibonacci("+n+")");
	}
/*
	@Before ("pcAppelFibonacciNonRecursif(n)") 
    public void debut(long n) {		
		System.out.println(">fibonacci("+ n +")");
	}

	@AfterReturning(pointcut="pcAppelFibonacciNonRecursif(n)", returning="val") 
	public void fin(long n, Object val) {
		System.out.println(val +" = fibonacci("+n+")");
	}		
*/
}