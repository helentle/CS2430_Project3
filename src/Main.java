import java.util.ArrayList;
import java.util.List;

/**
 * Main implementation
 * 
 * @author Helen Le, Santiago Valenzuela Alvarez, Ana Hurtado Rodriguez
 */
public class Main {

	public static int capacity = 700;
	
	public static List<Experiment> loadExperiments() {
        List<Experiment> experiments = new ArrayList<>();

        // TODO

        return experiments;
    }
	
	public static void main(String[] args) {
		List<Experiment> experiments = loadExperiments();
		
		//greedy strategies
		Results highestRating = GreedyStrategies.highestRatingFirst(experiments,capacity);
		Results lightest = GreedyStrategies.lightestRatingFirst(experiments,capacity);
		Results bestRatio = GreedyStrategies.ratingToWeightRatio(experiments,capacity);

		//brute force
		List<Experiment> bruteForceResults = BruteForce.topThree(experiments,capacity);
		
		// TODO

	}

}
