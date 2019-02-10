package banque;

public class ExceptionSoldeInsuffisant extends IllegalArgumentException{
	public ExceptionSoldeInsuffisant(String message) { super(message); }
}
