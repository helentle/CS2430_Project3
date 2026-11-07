import java.util.List;

/**
 * Stores the output of an algorithm in a list
 * 
 * @author Helen Le, Santiago Valenzuela Alvarez, Ana Hurtado Rodriguez
 */
public class Results {

	public List<Experiment> selected;
	private int totalWeight;
	private int totalRating;
	/**
	 * @param selected
	 * @param totalWeight
	 * @param totalRating
	 */
	public Results(List<Experiment> selected, int totalWeight, int totalRating) {
		this.selected = selected;
		this.totalWeight = totalWeight;
		this.totalRating = totalRating;
	}
	/**
	 * @return the selected
	 */
	public List<Experiment> getSelected() {
		return selected;
	}
	/**
	 * @return the totalWeight
	 */
	public int getTotalWeight() {
		return totalWeight;
	}
	/**
	 * @return the totalRating
	 */
	public int getTotalRating() {
		return totalRating;
	}
	
	
}
