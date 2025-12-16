package solveurGlouton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    /**
     * @param a
     * @param b
     * @return
     * @throws Exception
     */
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

    public static int[] substractCoordinates(int[] a, int[] b) throws Exception {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Arrays of different sizes");
        }
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] - b[i];
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

    public static int maxValue(int[] a) throws Exception {
        if(a.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        int currentMax = a[0];
        for(int val: a) {
            if(currentMax < val) {
                currentMax = val;
            }
        }
        return currentMax;
    }

    public static ArrayList<Integer> indicesOfValue(int valueToFind, int[] a) {
        ArrayList<Integer> indices = new ArrayList<Integer>();
        for(int i = 0; i < a.length; i++) {
            if(valueToFind == a[i]) {
                    indices.add(i);
            }
        }
        return indices;
    }

    public static ArrayList<Integer> indicesOfMaxValue(int[] a) throws Exception {
        int maxValue = maxValue(a);
        return indicesOfValue(maxValue, a);
    }

    public static int[] sommeDesCouts(List<ObjetInterface> objets) throws Exception {
    	
        int[] somme = new int[objets.getFirst().getCouts().length];
        Arrays.fill(somme, 0);
        for (ObjetInterface obj: objets) {
            somme = Utils.addCoordinates(somme, obj.getCouts());
        }
        return somme;
    }

    public static int utilite(List<ObjetInterface> objets) {
        int utilite = 0;
        for (ObjetInterface obj: objets) {
            utilite += obj.getUtilite();
        }
        return utilite;
    }

}
