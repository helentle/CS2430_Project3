import java.util.ArrayList;
import java.util.List;

/**
 * With 12 items, there are 212 = 4096 possible subsets.
 * 
 * Write code that:
 *  - Generates all 4096 possible subsets of experiments.
 *  - For each subset, computes total weight and total rating.
 *  - Identifies and displays the three highest-rated valid subsets 
 *    (total weight ≤ 700 kg), clearly indicating which one is optimal.
 *  - Outputs: chosen experiments, total weight, and total rating for each.
 *  
 *  This gives the true best solution for comparison against the greedy strategies.
 *  
 *  @author Helen Le, Santiago Valenzuela Alvarez, Ana Hurtado Rodriguez
 */
public class BruteForce{
	public static List<Results> topThree(List<Experiment> experiment,int capacity) {
		
		List<Results> validResults = new ArrayList<>();
		
		List<Experiment> selected = new ArrayList<>();
		
		//generate all possible experiment subsets while tracking weight & rating
		generateSubsets(experiment, 0, selected, validResults, capacity);
		
		//sort by highest rating
		validResults.sort((a, b) -> Integer.compare(b.getTotalRating(),a.getTotalRating()));
		
		//get top 3
		int highest3 = Math.min(3, validResults.size());
		List<Results> topThree = new ArrayList<>(validResults.subList(0, highest3));
		
		//Output experiment, totalWeight and totalRating
		System.out.println("================Top 3 Brute Force Combinations================");
		for (int i = 0; i < topThree.size(); i++) {
			Results result = topThree.get(i);
			
			System.out.println("\n---------Rank " + (i+1) + "---------");
			
			System.out.println("Experiments: \n");
			for (Experiment el : result.getSelected()) {
				System.out.println(el);
			}
	        System.out.println("Total Weight: " + result.getTotalWeight());
	        System.out.println("Total Rating: " + result.getTotalRating());
	     }		
		
		return topThree;
	}
	
	private static void generateSubsets(List<Experiment> experiment, int index, List<Experiment> selected, 
			List<Results> validResults, int capacity) {
		if (index == experiment.size()) {
			
			boolean valid = true;
			
			for (Experiment current : selected) {
				List<Experiment> otherExperiments = new ArrayList<>(selected);
				otherExperiments.remove(current);
				
				//does not include subsets that do not pass change order requirements
				if(!GreedyStrategies.passesChangeOrder(current, otherExperiments)) {
					valid = false;
					break;
				}
			}
			
			if (!valid) {
				return;
			}
			
			//calculates total weight based on change order requirements
			int totalWeight = GreedyStrategies.getFinalWeight(selected);
			
			int totalRating = 0;
			
			for(Experiment current : selected) {
				totalRating += current.getRating();
			}
			
			//save subsets within capacity
			if (totalWeight <= capacity) {
				validResults.add(new Results(new ArrayList<>(selected),totalWeight,totalRating));
			}
			return;
		}
		//save current experiment that passes all requirements
		selected.add(experiment.get(index));
		generateSubsets(experiment,index + 1, selected, validResults,capacity);
		
		//remove experiment
		selected.remove(selected.size()-1);
		
		//skip current
		generateSubsets(experiment,index+1,selected,validResults,capacity);
		
	}
}