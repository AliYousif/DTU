package algorithms_and_datastructures.data_structures_i;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import ks_algorithms_and_datastructures.data_structures_i.Datastructures;

public class InsertionSort extends Application {

	static int[] listOfRandomIntForJavaSort;
	int[] listOfRandomIntForInsertionSort;
	int prevLength = 0;
	static ArrayList<Integer> results = new ArrayList<Integer>();

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException {

		InsertionSort insertionSort = new InsertionSort();
		
		insertionSort.createArrayWithIntegers();
		System.out.println("Length of random array with ints 1 TIME for Arrays.Sort ----------------------------------: " + insertionSort.listOfRandomIntForJavaSort.length);
		System.out.println("Length of random array with ints 1 TIME for InsertionSort --------------------------------: " + insertionSort.listOfRandomIntForInsertionSort.length);
		insertionSort.createArrayWithIntegers();
		System.out.println("Length of random array with ints 2 TIME for Arrays.Sort ----------------------------------: " + insertionSort.listOfRandomIntForJavaSort.length);
		System.out.println("Length of random array with ints 2 TIME for InsertionSort --------------------------------: " + insertionSort.listOfRandomIntForInsertionSort.length);
		insertionSort.createArrayWithIntegers();
		System.out.println("Length of random array with ints 3 TIME for Arrays.Sort ----------------------------------: " + insertionSort.listOfRandomIntForJavaSort.length);
		System.out.println("Length of random array with ints 3 TIME for InsertionSort --------------------------------: " + insertionSort.listOfRandomIntForInsertionSort.length);
		
//		System.out.println("The unsorted array with random numbers and random size: ----------------------------------------- ");
//		for (int i : insertionSort.listOfRandomInt) {
//			System.out.println(i);
//		}
		
		insertionSort.CalculateRunTime(insertionSort, "sortJavaImpl");
		
		insertionSort.CalculateRunTime(insertionSort, "myInsertionSort");
//		
//		System.out.println("The SORTED array: -------------------------------------------------------------------");
//		for (int i : insertionSort.listOfRandomInt) {
//			System.out.println(i);
//		}

	
		launch(args);

	}
		
	// M1 - My implementation of InsertionSort
	private int[] insertionSort(int[] array) {
		for (int i = 1; i <= array.length-1; i++) {
			int j = i;
			while (j > 0 && array[j - 1] > array[j]) {
				int temp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = temp;
				j--;
			}
		}
		return array;	
	}
	
	// Calls my insertion sort with random created array with integers
	public void myInsertionSort() {
		insertionSort(listOfRandomIntForInsertionSort);
	}

	// Calls Java's Array.Sort so I can measure time taken
	public void sortJavaImpl() {
		Arrays.sort(listOfRandomIntForJavaSort);
	}
	
	// M2 - Creates a random size if called multiple times its always increases the size - and adds random positive integers to the array
	public void createArrayWithIntegers() {

		Random random = new Random();
		int length = random.nextInt(100000);

		while (prevLength > length) {
			length = random.nextInt(100000);
		}

		prevLength = length;

		listOfRandomIntForJavaSort = new int[length];
		listOfRandomIntForInsertionSort = new int[length];
		for (int i = 0; i < length; i++) {
			//Only positive numbers
			listOfRandomIntForJavaSort[i] = Math.abs(random.nextInt());
		}
		System.arraycopy(listOfRandomIntForJavaSort, 0, listOfRandomIntForInsertionSort, 0, listOfRandomIntForJavaSort.length);
	}

	
	// M3 - 
	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Drawing graphs for algorithms");
		
		prevLength = listOfRandomIntForJavaSort.length;
		int tempPrev = listOfRandomIntForJavaSort.length;
		// defining the axes
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Time (milliseconds)");
		yAxis.setLabel("Size");
		// creating the chart
		final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);

		lineChart.setTitle("Compare algorithms runtime: Arrays.Sort vs Insertion-Sort");
		// defining a series

		for (int i = 0; i < results.size(); i++) {
			XYChart.Series series = new XYChart.Series();
			int substract = prevLength / results.get(i);
			for (int j = 0; j < results.get(i) + 1; j++) {
				// populating the series with data
				series.setName("" + j);
				if (j == 0) {
					series.getData().add(new XYChart.Data(j, prevLength));
				} else {
					prevLength = prevLength - substract;
					series.getData().add(new XYChart.Data(j, prevLength));
				}

			}
			lineChart.getData().add(series);
			prevLength = tempPrev;
		}

		Scene scene = new Scene(lineChart, 800, 600);

		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public void CalculateRunTime(InsertionSort insertionSort, String methodName)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException,
			NoSuchMethodException, SecurityException {
		Class<?> c = insertionSort.getClass();
		Method method = c.getDeclaredMethod(methodName);

		long startTime = System.currentTimeMillis();
		method.invoke(insertionSort);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		results.add((int) totalTime);
		System.out.println("Total time for " + methodName + "()" + ": " + totalTime + " milliseconds");
	}
	

}
