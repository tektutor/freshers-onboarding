package org.tektutor;

public class AlgorithmFactory {
	
	public static IAlgorithm getAlgorithm(int algo) {
		
		IAlgorithm algorithm = null;
		
		if ( algo == 1 )
			algorithm = new QuickSort();
		else if ( algo == 2 )
			algorithm = new InsertionSort();
		else if ( algo == 3 )
			algorithm = new HeapSort();
		else
			algorithm = new NullAlgorithm();

		return algorithm;
	}

}