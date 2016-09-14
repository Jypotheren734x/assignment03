package assignment03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BinarySearchSetTiming extends Application {

	public static final int BILLION = 1000_000_000;
	public static final int MILLION = 1_000_000;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		stage.setTitle("Line Chart Sample");
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Test Number");
		yAxis.setLabel("Time");

		final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);

		lineChart.setTitle("BinarySearchSet timing");

		XYChart.Series series1 = new XYChart.Series();
		XYChart.Series series2 = new XYChart.Series();
		series1.setName("BinarySearchSet timing data: contains()");
		series2.setName("BinarySearchSet timing data: add()");

		BinarySearchSet<Double> binaryD = new BinarySearchSet<Double>();
		double x = 0;
		Double[] ar = new Double[1000];
		while (x < 1000) {
			ar[(int) x] = x;
			binaryD.add(x);
			x++;
		}
		int count = 0;
		while (count < 10000) {
			double num = 0 + (int) (Math.random() * binaryD.size);
			long start;
			start = System.nanoTime();
			binaryD.contains(num);
			long end = System.nanoTime() - start;
			double time = end / (double) BILLION;
			series1.getData().add(new XYChart.Data(count+1, time));
			// System.out.println("BinarySearchSet.contains() took " + time +
			// "seconds to look through " + binaryD.size()
			// + " items for " + num);
			count++;
		}
		count = 0;
		while(count < 10000){
			double num = 51.5;//0 + (int) (Math.random() * binaryD.size);
			long start;
			start = System.nanoTime();
			binaryD.add(num);
			long end = System.nanoTime() - start;
			double time = end / (double) BILLION;
			binaryD.remove(num);
			series2.getData().add(new XYChart.Data(count+1, time));
			count++;
		}
		Scene scene = new Scene(lineChart, 800, 600);
		lineChart.getData().add(series1);
//		lineChart.getData().add(series2);
		lineChart.setCreateSymbols(false);

		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
