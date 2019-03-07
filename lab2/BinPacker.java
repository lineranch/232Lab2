package lab2;

import java.util.Arrays;

public class BinPacker {
	private int capacity;
	private int num;
	private String[] bins;
	private int[] vals;
	private BST<Integer, Integer> tree = new BST<>();

	public BinPacker(int cap, int size) {
		this.capacity = cap;
		this.num = size;
		this.bins = new String[size];
		this.vals = new int[size];
		Arrays.fill(bins, "");
	}
	
	public void bestFitDecreasing(int[] items) {
		int bin = 1;
		int suggest = 0;
		System.out.println(Arrays.toString(items));
		
		tree.put(bin, items[0]);
		bins[bin-1] += (Integer.toString(items[0]) + " ");
		
		for (int i = 1; i < num; i++) {
			suggest = bestFit(items, i, bin);
			
			if (suggest > bin) {
				bin = suggest;
				tree.put(suggest, items[i]);
				bins[suggest-1] += (Integer.toString(items[i]) + " ");
			} else {
				tree.put(suggest, tree.get(suggest) + items[i]);
				bins[suggest-1] += (Integer.toString(items[i]) + " ");
			}
		}
		printTree(bins);
	}
	
	private int bestFit(int[] items, int index, int bin) {
		int weight = items[index];
		int tempVal = this.capacity - tree.get(1);
		int tempKey = 0;
		
		for (int j = 1; j <= bin; j++) {
			if ((this.capacity - tree.get(j)) <= tempVal && (this.capacity - tree.get(j)) >= weight) {
				tempVal = this.capacity - tree.get(j);
				tempKey = j;
				//System.out.println(tempVal);
				//System.out.println(weight);
			}
		}
		
		if (tempKey != 0) {			
			return tempKey;
		} else {
			return bin + 1;
		}
	}
	private void printTree(String[] bins) {
		for (int i = 1; i <= capacity; i++) {
			if (bins[i-1] != "") {
				System.out.printf("Bin %d: %s\n", i, bins[i-1]);
			} else {
				return;
			}
		}
	}

	/*
	public void firstFit(int[] items) {
		for (int i = 0; i < items.length; i++) {
			if (i == 0) {
				bins[0] = Integer.toString(items[0]);
				vals[0] = items[0];
			} else {
				for (int j = 0; j < i; j++) {
					if (bins[j] == null) {
						bins[j] = Integer.toString(items[i]);
						vals[j] = items[i];
						break;
					} else if ((items[i] + vals[j]) <= this.capacity) {
						bins[j] += (" " + Integer.toString(items[i]));
						vals[j] += items[i];
						break;
					}
				}
			}
		}
		System.out.println(Arrays.toString(bins));
		System.out.println(Arrays.toString(vals));
		
	}
	*/
}
