package fibonacci;

public class Fibonacci {
	static long fibonacci(long n) {
		if (n < 2) return n;
		return fibonacci(n-1) + fibonacci(n-2);
	}
	public static void main(String[] args){
		fibonacci(3);
	}
}