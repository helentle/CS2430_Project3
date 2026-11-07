import java.util.ArrayList;
import java.util.List;

/**
 * Write code to load/store the 12 experiments (you may hard-code them 
 * in a list/array/struct or comparable structure). 
 * 
 * Implement three separate functions/methods/subroutines, each of which 
 * builds a payload without exceeding 700 kg:
 * 
 * Highest Rating First
 * ---------------------
 * Select experiments based on highest rating without exceeding 700 kg.
 * Output: list of chosen experiments, total weight, and total rating.
 * 
 * Lightest First
 * ---------------
 * Select experiments based on lightest weight without exceeding 700 kg.
 * Output: list of chosen experiments, total weight, and total rating.
 * 
 * Best Rating-to-Weight Ratio First
 * ----------------------------------
 * Compute score = rating / weight for each experiment.
 * Select experiments based on highest ratio while total weight ≤ 700 kg.
 * Output: list of chosen experiments, total weight, and total rating.
 * 
 * Clearly display results for all three strategies.
 * @author Helen Le, Santiago Valenzuela Alvarez, Ana Hurtado Rodriguez
 */

public class GreedyStrategies{
	public static Results highestRatingFirst(List<Experiment> experiment,int capacity) {
		int totalWeight = 0;
		int totalRating = 0;
		List<Experiment> selected = new ArrayList<>();
		
		//TODO
		
		return new Results(selected, totalWeight, totalRating);
		
	}
	
	public static Results lightestRatingFirst(List<Experiment> experiment,int capacity) {
		int totalWeight = 0;
		int totalRating = 0;
		List<Experiment> selected = new ArrayList<>();

		//TODO
		
		return new Results(selected, totalWeight, totalRating);
	}
	
	public static Results ratingToWeightRatio(List<Experiment> experiment,int capacity) {
		int totalWeight = 0;
		int totalRating = 0;
		List<Experiment> selected = new ArrayList<>();
		
		//TODO
		
		return new Results(selected, totalWeight, totalRating);
	}
}