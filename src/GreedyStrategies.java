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
		int totalRating = 0;
		List<Experiment> selected = new ArrayList<>();
		List<Experiment> experimentCopy = new ArrayList<>(experiment);

		//sort experiments by rating (highest to lowest)
		experimentCopy.sort(
			    (a, b) -> Integer.compare(b.getRating(), a.getRating())
			);		
		
		for (Experiment current : experimentCopy) {
			
			//Temp list with all selected experiments and 
			//the current experiment being checked
			List<Experiment> testSelection = new ArrayList<>(selected);
	        testSelection.add(current);
	        
			if ((getFinalWeight(testSelection) <= capacity) && passesChangeOrder(current, selected)) {
				
		        selected.add(current);
		        totalRating += current.getRating();
			}
		}
		return new Results(selected, getFinalWeight(selected), totalRating);	
	}
	
	
	public static Results lightestRatingFirst(List<Experiment> experiment,int capacity) {
		int totalRating = 0;
		List<Experiment> selected = new ArrayList<>();
		List<Experiment> experimentCopy = new ArrayList<>(experiment);

		//sort experiments by weight (lowest to highest)
				experimentCopy.sort(
					    (a, b) -> Integer.compare(a.getWeight(), b.getWeight())
					);		
				
				for (Experiment current : experimentCopy) {
					
					//Temp list with all selected experiments and 
					//the current experiment being checked
					List<Experiment> testSelection = new ArrayList<>(selected);
			        testSelection.add(current);
			        
					if ((getFinalWeight(testSelection) <= capacity) && passesChangeOrder(current, selected)) {
						
				        selected.add(current);
				        totalRating += current.getRating();
					}
				}
		return new Results(selected, getFinalWeight(selected), totalRating);
	}
	
	public static Results ratingToWeightRatio(List<Experiment> experiment,int capacity) {
		int totalWeight = 0;
		int totalRating = 0;
		List<Experiment> selected = new ArrayList<>();
		
		//TODO
		
		return new Results(selected, totalWeight, totalRating);
	}
	
	//method that checks for change order requirements
	private static boolean passesChangeOrder(Experiment candidate, List<Experiment> selected) {
		
		//Initializing variables for checking for experiments already chosen
		boolean has2 = false;
		boolean has3 = false;
		boolean has7 = false;
		boolean has11 = false;
		
		//Check to see if 2, 3, 7, and 11 are present
		for (Experiment experiment : selected) {
			if (experiment.getName() == "2") has2 = true;
			if (experiment.getName() == "3") has3 = true;
			if (experiment.getName() == "7") has7 = true;
			if (experiment.getName() == "11") has11 = true;
		}
		
		//if selected = 2,3, or 7, if 2 && 3 or 2 && 7 or 3 && 7 are in experimentCopy,
        //do not select experiment
		if (candidate.getName() == "2" && (has3 && has7))
			return false;
		if (candidate.getName() == "3" && (has2 && has7))
			return false;
		if (candidate.getName() == "7" && (has3 && has2))
			return false;
		
		//if selected = 11a and 11 is not included, do not select 11a
		if(candidate.getName() == "11a" && !has11)
			return false;
		
		return true;
	}
	
	private static int getFinalWeight(List<Experiment> selected) {
		int totalWeight = 0;
		boolean has6 = false;
		boolean has12 = false;
		
		for(Experiment experiment : selected) {
			if (experiment.getName() == "6") has6 = true;
			if (experiment.getName() == "12") has12 = true;
			
	        totalWeight += experiment.getWeight();
		}
		
		if (has6 && has12) {
			totalWeight -= 7;
		}
		return totalWeight;
	}
}