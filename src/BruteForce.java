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
	public static List<Experiment> topThree(List<Experiment> experiment,int capacity) {
		int totalWeight = 0;
		int totalRating = 0;
		List<Experiment> selected = new ArrayList<>();
		//generate all possible experiment subsets while tracking weight & rating TODO
		
		//Change order TODO:
        //	1.  if selected = 2,3, or 7, if 2 && 3 or 2 && 7 or 3 && 7 are in experimentCopy,
        //		skip and select next experiment
        //	2.  if 6 and 12 are selected, subtract 7kg from totalWeight
        //	3.  if 11 is not in experimentCopy, do not add 11a
        
		//Choose and display 3 highest rated valid subsets TODO
		
		//Output experiment, totalWeight and totalRating TODO
		
		return selected;
		
	}
}