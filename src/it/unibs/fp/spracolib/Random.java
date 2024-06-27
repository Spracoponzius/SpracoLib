package it.unibs.fp.spracolib;

public class Random
{	
	private static final java.util.Random RAND = new java.util.Random();


	/**
	 * Given two int parameters, it returns a random int value between the given ones.
	 * @param min lower bound
	 * @param max upper bound
	 * @return a random int
	 */
	public static int extractInteger(int min, int max)
	{
	 int range = max + 1 - min;
	 int casual = RAND.nextInt(range);
	 return casual + min;
	}

	/**
	 * Given two double parameters, it returns a random double value between the given ones.
	 * @param min lower bound
	 * @param max upper bound
	 * @return a random double
	 */
	public static double extractDouble(double min, double max){
		double range = max - min;
		double casual = RAND.nextDouble()*range;
		return casual + min;
	}

	/**
	 * Returns either true or false based on semi-randomness. Take it like a coin toss.
	 * @return T/F in boolean value
	 */
	public static boolean extractBoolean(){
		return RAND.nextBoolean();
	}
	
}
