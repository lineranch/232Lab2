package BinPacker;

import java.util.Arrays;

public class BinPackerDemo {

	static 	BST<String, Integer> bestFitBin = new BST();
	static int capacity, numberOfBins, maxBSTBins;
	
	public static void main(String[] args) {
		int[] items;
		int maxBins;
		capacity = Integer.parseInt(args[0]);
		

		// This chunk reads in the inputs and places them into an array
		In in = new In(args[1]);
		items = in.readAllInts();
		maxBins = items.length;

		
		// THIS CHUNK WILL BE USED IN THE FINAL CODE ********************************
		System.out.println("Item sizes: " + Arrays.toString(items) + "\n");
		firstFit(items, maxBins);
		numberOfBins = 0;
		

		
		// IN PROGRESS
		// This chunk is the BestFitDecreasing block
		System.out.println("Best Fit Decreasing...");
		bestFitDecreasing(items, maxBins);
		// End of BestFitDecreasing
		
		
		// IN PROGRESS
		worstFitDecreasing();
	}

	private static void bestFitDecreasing(int[] items, int maxBins) {
		maxBSTBins = 1;
		maxBins = 1;
		
		bestFitBin.put("Bin 1", items[0]);
		
		
		
		for (int i = 1; i < items.length; i++) {
			bestfit(items[i]);
		}
		
		
		
	}

	private static String bestfit(int x) {
		String bins[] = new String[maxBSTBins];
		Arrays.fill(bins, "");
		
		
		for (int i = 0; i < maxBSTBins; i++) {
			bins[i] += "Bins " + (i + 1); 
			
		}
		
		System.out.println(Arrays.toString(bins));
		
		return null;
	}

	private static void worstFitDecreasing() {
		// TODO Auto-generated method stub

	}

	
	



	private static void firstFit(int[] items, int maxBins) {
		int bins[] = new int[maxBins];
		String binTracker[] = new String[maxBins];
		int index = 0;
		int numberOfBins = 0;
		
		Arrays.fill(binTracker, "");
		
		System.out.println("First Fit...");
		
		for (int i = 0; i < items.length; i++) {
			if (bins[index] + items[i] <= capacity) {
				if (bins[index] == 0) {
					System.out.println("Can't fit " + items[i] +". Making a new bin!");
					
					numberOfBins++;
				}
				bins[index] += items[i];
				binTracker[index] += items[i] + " ";
				index = 0;

			} else {
				i--;
				index++;
			}

		}
		
		System.out.println("\nTotal Sizes: " + Arrays.toString(bins));
		System.out.println("Number of Bins = " + numberOfBins);
		System.out.println("\nWhat item is in each bin: ");
		for (int i = 0; i < numberOfBins; i++) {
			System.out.println("Bin " + (i+1) + ": " + binTracker[i] + "\n");
		}
	}

}
