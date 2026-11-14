
/**
 * For small sets like this, brute force is feasible. For larger datasets, 
 * dynamic programming (DP) can provide optimal (or near-optimal) solutions 
 * efficiently.
 * 
 * If you choose not to implement DP, include pseudocode comments in your 
 * source code describing how a DP solution would work. (This is required 
 * even if you do not attempt extra credit.)
 * 
 * Extra Credit (+2 pts): Implement the DP solution in code. Include:
 *  - The DP table or final result (as appropriate)
 *  - The chosen subset
 *  - A short comparison of runtime and code complexity vs. brute force
 *  
 *  @author Helen Le, Santiago Valenzuela Alvarez, Ana Hurtado Rodriguez
 */
public class DynamicProgramming{
	//initialize array of size capacity + 1 with each index representing 
	//capacity and each value represents the highest possible rating at 
	//said capacity
	//List<Experiment> experiments = new ArrayList<>(experiment);
	
	//Run a loop iterating from first value to last
	//for (int i = 1; i <= experiments.size; i++){
	//	- Get current experiment's weight and rating
	//
	//	run a loop iterating from highest capacity to lowest capacity
	//	for (int j = maxCapacity; j >= current.weight; j--){
	//		- Calculate total rating if the experiment is added and compare
	//		  against the rating if it is not added
	//		- Keep it only if the rating is higher
	//		- Track selected experiments to construct final subset
	//	}
	//	Optimal rating is at dp[maxCapacity]
	//	return experiments;
	//}
	
}