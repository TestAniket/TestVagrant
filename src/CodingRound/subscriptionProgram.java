package CodingRound;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Scanner;

public class subscriptionProgram 
{
	public static HashMap<String, Double> allPossibleCombinations;
	public static Optional<Entry<String, Double>> minValue;
	public static Scanner sc;
	public static void combinations(int budget)
	{
		allPossibleCombinations = new HashMap<String, Double>();
		allPossibleCombinations.put("TOI&Hindu", 46.5);
		allPossibleCombinations.put("TOI&ET", 60.00);
		allPossibleCombinations.put("TOI&BM", 36.5);
		allPossibleCombinations.put("TOI&HT", 44.00);
		allPossibleCombinations.put("Hindu&ET", 54.5);
		allPossibleCombinations.put("Hindu&BM", 31.00);
		allPossibleCombinations.put("Hindu&HT", 38.5);
		allPossibleCombinations.put("ET&BM", 44.5);
		allPossibleCombinations.put("ET&HT", 52.00);
		allPossibleCombinations.put("BM&HT", 28.5);
		minValue = allPossibleCombinations.entrySet().stream().min(Map.Entry.comparingByValue());
		Double minBorderValue=minValue.get().getValue();

		System.out.print("combinations which fits into your budget: ");
		for (Entry<String, Double> e : allPossibleCombinations.entrySet()) {
			if (budget>=e.getValue()) {
				String value=e.getKey();
				System.out.print( " "+value+",");
				}
		}
		if(budget<minBorderValue){
			System.out.println("no combination fits into the given budget");
		}
	}
	
	public static int userInput()
	{
		sc = new Scanner(System.in);
		System.out.print("enter your budget for subscription: ");
		int input=sc.nextInt();
		return input;
	}
	public static void main(String[] args) {
		 
		combinations(userInput());
	}
}
/*
 * By looking into the problem statement I understood that there has to be one dedicated method 
 * for logic and handling combinations data because of which I started with combinations method 
 * 
 * combinations method: 
 * 	1)this methods holds the data of all the possbile combinations. Here I have used hashmap beacuse of its ability to store
 * 	 data in key value format.
 *  2)First for loop is where I actually compaired the budget with the available combinatons and whichever fits into the budget
 *   I just derived the  key of it and print it 
 *  3)Second for loop is to handle the negative scenario where if the user has given budget which is lees than the min value available 
 *   then to throw a message 
 * 
 * userInput:
 * 1) Here I have used scanner to get user input and then pass on that input as budget to combinations class
 * 
 * Main Method:
 * 1) Here I have called combinations() method and passed the value taken from user via UserInput() method 
 *  
 */

