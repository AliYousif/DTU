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
	
	int[] listOfRandInt;
	int prevLength = 0;
	ArrayList<Integer> results = new ArrayList<Integer>();

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException {
		
		Datastructures ds = new Datastructures();
		ds.createSequence();
		ds.CalculateRunTime(ds, "createSequence");
		ds.createSequence();
		ds.CalculateRunTime(ds, "createSequence");
		ds.createSequence();
		ds.CalculateRunTime(ds, "createSequence");
		
		ds.CalculateRunTime(ds, "sortJavaImpl");
		
		launch(args);
		
	}
	
	public void CalculateRunTime(Datastructures datastructures, String methodName) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException {
		Class<?> c = datastructures.getClass();
		Method  method = c.getDeclaredMethod (methodName);
		
		long startTime = System.currentTimeMillis();
		method.invoke (datastructures);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		results.add((int) totalTime);
		System.out.println("total time for " + methodName+"()"+": " + totalTime + " milliseconds");
	}
	
	public void sortJavaImpl(){
		Arrays.sort(listOfRandInt);
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
	
		for (int i : listOfRandInt) {
			System.out.println(i);
		}
		
		System.out.println(listOfRandInt.length); 
		
	}

	@Override public void start(Stage stage) {
        stage.setTitle("Runtime");
        
        results.add(23);
        results.add(3);
        prevLength = 1000;
        int tempPrev = 1000;
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
        	int substract = prevLength/results.get(i);
        	for(int j = 0; j < results.get(i)+1; j++){
		        //populating the series with data
		        series.setName(""+j);
		        if(j == 0){
		        	series.getData().add(new XYChart.Data(j, prevLength));
		        } else {
		        	prevLength= prevLength - substract;
		        	series.getData().add(new XYChart.Data(j, prevLength));
		        }
		        
        	}
        	lineChart.getData().add(series);
        	prevLength = tempPrev;
        }
        
        Scene scene  = new Scene(lineChart,800,600);
        
        stage.setScene(scene);
        stage.show();
    }

}
