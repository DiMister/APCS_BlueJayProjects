/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card we = new Card("bruh","hearts",13);
		Card wee = new Card("bruh","hearts",13);
		Card weee = new Card("bruh","hearts",13);
		
		System.out.println(we.matches(wee));
		System.out.println(wee);
	}
}
