/**
 * Creates an experiment that can be accessed by other classes
 * 
 * @author Helen Le, Santiago Valenzuela Alvarez, Ana Hurtado Rodriguez
 */
public class Experiment {

	public String name;
	public int weight;
	public int rating;
	/**
	 * @param name
	 * @param weight
	 * @param rating
	 */
	public Experiment(String name, int weight, int rating) {
		this.name = name;
		this.weight = weight;
		this.rating = rating;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	
}
