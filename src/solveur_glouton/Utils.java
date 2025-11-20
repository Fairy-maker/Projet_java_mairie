package solveur_glouton;

public class Utils {

	public static int[] addCoordinates(int[] a, int[] b) throws Exception {
		if (a.length != b.length) {
			throw new IllegalArgumentException("Arrays of different sizes");
		}
		int[] result = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			result[i] = a[i] + b[i];
		}
		return result;
	}
	
	public static boolean allSmaller(int[] a, int[] bounds) throws Exception {
		if (a.length != bounds.length) {
			throw new IllegalArgumentException("Arrays of different sizes");
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] > bounds[i]) {
				return false;
			}
		}
		return true;
	}

}
