import java.util.ArrayList;
import java.util.List;

/**
 * Main implementation
 * 
 * @author Helen Le, Santiago Valenzuela Alvarez, Ana Hurtado Rodriguez
 */
public class Main {

	
	//creates a list of experiments
	public static List<Experiment> loadExperiments() {
        List<Experiment> experiments = new ArrayList<>();

        experiments.add(new Experiment("Cloud Patterns", 36, 5));
        experiments.add(new Experiment("Solar Flares", 264, 9));
        experiments.add(new Experiment("Solar Power", 188, 6));
        experiments.add(new Experiment("Binary Stars", 203, 8));
        experiments.add(new Experiment("Relativity", 104, 8));
        experiments.add(new Experiment("Seed Viability", 7, 4));
        experiments.add(new Experiment("Sun Spots", 90, 2));
        experiments.add(new Experiment("Mice Tumors", 65, 8));
        experiments.add(new Experiment("Microgravity Plant Growth", 75, 5));
        experiments.add(new Experiment("Micrometeorites", 170, 9));
        experiments.add(new Experiment("Cosmic Rays (Primary Band)", 80, 7));
        experiments.add(new Experiment("Cosmic Rays (Secondary Band)", 10, 5));
        experiments.add(new Experiment("Yeast Fermentation", 27, 4));

        return experiments;
    }
	
	public static void main(String[] args) {
		int capacity = 700;
		
		List<Experiment> experiments = loadExperiments();
		
		//greedy strategies
		Results highestRating = GreedyStrategies.highestRatingFirst(experiments,capacity);
		Results lightest = GreedyStrategies.lightestRatingFirst(experiments,capacity);
		Results bestRatio = GreedyStrategies.ratingToWeightRatio(experiments,capacity);

		//brute force
		List<Results> bruteForceResults = BruteForce.topThree(experiments,capacity);
		
		//compare output
		Comparison.printSummary(highestRating, lightest, bestRatio, bruteForceResults);
	}

}
