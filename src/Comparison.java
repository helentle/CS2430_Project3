import java.util.List;

/**
 * output summarizing:
 * - Results of all 3 greedy strategies (Part 1)
 * - Result of the brute-force optimal (Part 2)
 * - A brief printed summary identifying which strategies matched the 
 * optimal and which did not
 * 
 * Make the output easy to read and copy into your report.
 * 
 * @author Helen Le, Santiago Valenzuela Alvarez, Ana Hurtado Rodriguez
 */
public class Comparison{
	
	public static void printSummary(
			Results highestRating,
			Results lightest,
			Results bestRatio,
			List<Results> bruteForceResults) {
		
		Results best = bruteForceResults.get(0);
		
		System.out.println("\n\n================Comparison Summary Output================");
		
		//Greedy results
		printResult("---------Highest Rating First---------", highestRating, best);
        printResult("---------Lightest First---------", lightest, best);
        printResult("---------Rating-to-Weight Ratio---------", bestRatio, best);

        //Bruteforce
        System.out.println("\n---------Best Solution---------");
        System.out.println("Experiments: \n");
		for (Experiment el : best.getSelected()) {
			System.out.println(el);
		}
        System.out.println("Total Weight: " + best.getTotalWeight());
        System.out.println("Total Rating: " + best.getTotalRating());

        System.out.println("\n---------Summary---------");
        compareStrategy("Highest Rating First", highestRating, best);
        compareStrategy("Lightest First", lightest, best);
        compareStrategy("Rating-to-Weight Ratio", bestRatio, best);
	}
	private static void printResult(
            String strategy, Results result, Results optimal) {

        System.out.println("\n" + strategy);
        System.out.println("Experiments: \n");
		for (Experiment el : result.getSelected()) {
			System.out.println(el);
		}
        System.out.println("Total Weight: " + result.getTotalWeight());
        System.out.println("Total Rating: " + result.getTotalRating());
    }
	private static void compareStrategy(
            String strategy, Results result, Results best) {

        if (result.getTotalRating() == best.getTotalRating()) {
            System.out.println(strategy + ": Matched best result");
        } else {
            System.out.println(strategy + ": Did not match best result");
            System.out.println("Rating difference: "
                    + (best.getTotalRating() - result.getTotalRating()));
        }
    }
}