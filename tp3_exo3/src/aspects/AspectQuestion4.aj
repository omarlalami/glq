package aspects;

import fibonacci.Fibonacci;

				// NE MARCHE PAS
/*
public aspect AspectFibonacci {

	pointcut callFibonacci(long n ,Fibonacci f):
		call(long fibonacci.Fibonacci.fibonacci(long))
				&& args(n)
				&& target(f);
	after(long n ,Fibonacci f) : callFibonacci(n,f){
		System.out.println(">"+n);
	}
	
	
 	pointcut appel() : call(* fibonacci.*.*(..));
	before() : appel(){ 
		System.out.println(">"
				+thisJoinPoint.getSignature().getName()
				+thisJoinPoint.getArgs());
		} 
	
}
*/
