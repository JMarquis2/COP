public class Analyzer{

	//this main function displays all tests of the cases, by calling on methods that test the cases.
	private static String[] dataArray = StringData.getData();
	public static void main(String [] args){
		long startTime;
		long endTime;
		int index;

		//testing linear search for not_here
		linearSearchProcess("not_here");
		//testing binary search for not_here
		binarySearchProcess("not_here");
		//testing linear search for mzzzz
		linearSearchProcess("mzzzz");
		//testing binary search for mzzzz
		binarySearchProcess("mzzzz");
		//testing linear search for aaaaa
		linearSearchProcess("aaaaa");
		//testing binary search for aaaaa
		binarySearchProcess("aaaaa");
	}

	//this method runs linearSearch method and prints information about it, including run time.
	public static void linearSearchProcess(String element){
		long startTime;
		long endTime;
		int index;

		System.out.println("Beginning linear search for " + element);
		startTime = System.nanoTime();
		index = linearSearch(dataArray, element);
		endTime = System.nanoTime();
		System.out.println("index: " + index);
		System.out.println("time taken: " + (endTime - startTime));
	}

	//this method runs binarySearch and prints information about it, including run time.
	public static void binarySearchProcess(String element){
		long startTime;
		long endTime;
		int index;

		System.out.println("Beginning binary search for " + element);
		startTime = System.nanoTime();
		index = binarySearch(dataArray, element);
		endTime = System.nanoTime();
		System.out.println("index: " + index);
		System.out.println("time taken: " + (endTime - startTime));
	}

	//this method performs a linear search using a for loop.
	public static int linearSearch(String[] dataSet, String element){
		for(int i = 0; i < dataSet.length; i++){
			if(dataSet[i].equals(element)){
				return i;
			}
		}
		return (-1);
	}

	//this method performs a binary search by setting an initial range of possible values, and the current checked value being
	//the average of the limits of the range. Then, determines whether the current value is equal to, greater than, or less than
	//the desired value. Finding nothing is accounted for by checking if the range has been narrowed below 1.
	public static int binarySearch(String[] dataSet, String element){
		int index = (dataSet.length / 2);
		int upperLimit = (dataSet.length - 1);
		int lowerLimit = 0;
		while(upperLimit >= lowerLimit){
			if(dataSet[index].equals(element)){
				return index;
			}
			if(dataSet[index].compareTo(element) < 0){
				lowerLimit = index + 1;
			}
			if(dataSet[index].compareTo(element) > 0){
				upperLimit = index - 1;
			}
			index = ((upperLimit + lowerLimit) / 2);
		}
	return -1;
	}
}
