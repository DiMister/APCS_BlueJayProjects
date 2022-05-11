/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {
    
    
    public static void main(String[] args) {
        String[] ranks = {"jack","queen","king"};
        String[] suits = {"blue","red"};
        int[] point = {11,12,13};
        Deck bruh = new Deck(ranks,suits,point);
        
        bruh.deal();
        System.out.println(bruh);
        
    }
}
