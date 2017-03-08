package ks_algorithms_and_datastructures.data_structures_i;

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

public class Datastructures extends Application {
	
	static int[] listOfRandInt;
	int prevLength = 0;
	public static ArrayList<RunInfo> results = new ArrayList<RunInfo>();
	

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException {
		
		Datastructures ds = new Datastructures();
		//ds.createSequence();
		
		
		listOfRandInt = new int[]{3,2,5,7,9,1,4,6,8};
		
		int[] dest = new int[listOfRandInt.length];

		System.arraycopy( listOfRandInt, 0, dest, 0, listOfRandInt.length);
		
		ds.CalculateRunTime(ds, "sortJavaImpl", dest);
		System.arraycopy( listOfRandInt, 0, dest, 0, listOfRandInt.length);
		ds.CalculateRunTime(ds, "insertionSort", dest);
		System.arraycopy( listOfRandInt, 0, dest, 0, listOfRandInt.length);
		ds.CalculateRunTime(ds, "sort", dest);
		
		launch(args);
		
	}
	
	public class RunInfo{
		int runtime;
		String name;
		int lenghtOfArray;
	}
	
	public void CalculateRunTime(Datastructures datastructures, String methodName, int[] a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException {
		Class<?> c = datastructures.getClass();
		Method  method = c.getDeclaredMethod (methodName, int[].class);
		
		this.print(a, methodName, "before");
		long startTime = System.currentTimeMillis();
		method.invoke (datastructures, a);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		
		RunInfo runInfoTemp = new RunInfo();
		runInfoTemp.runtime = (int) totalTime;
		runInfoTemp.name = methodName;
		runInfoTemp.lenghtOfArray =  a.length;
		
		results.add(runInfoTemp);
		System.out.println("total time for " + methodName+"()"+": " + totalTime + " milliseconds" + " on a array of lenght: " + a.length);
		this.print(a, methodName, "after");
	}
	
	public void sortJavaImpl(int[] arr){
		Arrays.sort(arr);
	}
	
	public int[] insertionSort(int[] arr){
        int temp;
        for (int i = 1; i < arr.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;
    }
	
	public int[] sort(int[] arr){
	    for (int i = 1; i <= arr.length-1; i++) {
	        int element = arr[i];
	        int j = i;
	        while (j>0 && (arr[j-1] > element)) {
	        	arr[j] = arr[j-1];
	            j--;
	        }
	        arr[j] = element;
	    }
	    return arr;
	}
	
	public void createSequence(){

		Random rand = new Random();
		int length = rand.nextInt(10000);
		
		while(prevLength > length){
			length = rand.nextInt(10000);
		}
		
		prevLength = length;
		
		listOfRandInt = new int[length] ;
		for(int i = 0; i<length;i++){
			listOfRandInt[i] = rand.nextInt();
		}
		
		System.out.println("lenght of array: "+listOfRandInt.length); 
		
	}

	public void print(int[] A, String methodname, String beforeOrAfter){
		String res = "("+beforeOrAfter+")" +" " + methodname +": ";
	    for (int i = 0; i < A.length; i++) {
	        res = res + A[i] + " ";
	    }
	    System.out.print(res);
	}
	
	public void start(Stage stage) {
        stage.setTitle("Runtime");
       
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Time");
        yAxis.setLabel("Size");
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("GIV VARIABILE FOR SORT");
        //defining a series
        for(int i = 0; i < results.size(); i++){
        	XYChart.Series series = new XYChart.Series();
        	if(results.get(i).runtime > 0){
	        	int substract = results.get(i).lenghtOfArray/results.get(i).runtime;
	        	for(int j = 0; j < results.get(i).runtime+1; j++){
			        //populating the series with data
			        series.setName(results.get(i).name+": "+j);
			        if(j == 0){
			        	series.getData().add(new XYChart.Data(j, results.get(i).lenghtOfArray));
			        	prevLength = results.get(i).lenghtOfArray;
			        } else {
			        	prevLength= prevLength - substract;
			        	series.getData().add(new XYChart.Data(j, prevLength));
			        }
			        
	        	}
	        	lineChart.getData().add(series);
	        }
        }
        
        Scene scene  = new Scene(lineChart,800,600);
        
        stage.setScene(scene);
        stage.show();
    }

}
