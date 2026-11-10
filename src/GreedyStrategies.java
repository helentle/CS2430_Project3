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
		List<Experiment> experimentCopy = new ArrayList<>();

		//sort experiments by rating (highest to lowest) TODO
		
		while ((totalWeight += ((Experiment) selected).getWeight())<= capacity) {
	        experimentCopy.add((Experiment) selected);
	        //Change order TODO:
	        //	1.  if selected = 2,3, or 7, if 2 && 3 or 2 && 7 or 3 && 7 are in experimentCopy,
	        //		skip and select next experiment
	        //	2.  if 6 and 12 are selected, subtract 7kg from totalWeight
	        //	3.  if 11 is not in experimentCopy, do not add 11a
	        
	        totalWeight = totalWeight + ((Experiment) selected).getWeight();
	        totalRating = totalRating + ((Experiment) selected).getRating();
		}
		//if totalWeight + experiment.weight <= capacity
		//add experiment to selected
		//totalWeight = totalWeight + experiment.weight
		//totalRating = totalRating + experiment.rating
		//TODO fix ugly casts
		
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