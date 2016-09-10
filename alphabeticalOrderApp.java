package Puzzle;

public class alphabeticalOrderApp {
	public static void main (String args[]){
		String str = "We came, we saw, we conquered...then we ate Bill's (Mille-Feuille) cake";
		System.out.println(str);
		
		alphabeticalOrder alph = new alphabeticalOrder();
		
		alph.alphabetical(str);
		alph.printMap();
		
	}
}
