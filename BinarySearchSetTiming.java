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

		XYChart.Series series = new XYChart.Series();
		series.setName("BinarySearchSet timing data");

		BinarySearchSet<Double> binaryD = new BinarySearchSet<Double>();
		double x = 0;
		Double[] ar = new Double[1000];
		while (x < 1000) {
			ar[(int) x] = x;
			binaryD.add(x);
			x++;
		}
		int count = 0;
		while (count < 100) {
			double num = 0 + (int) (Math.random() * binaryD.size);
			long start;
			start = System.nanoTime();
			binaryD.contains(num);
			long end = System.nanoTime() - start;
			double time = end / (double) BILLION;
			series.getData().add(new XYChart.Data(count+1, time));
			// System.out.println("BinarySearchSet.contains() took " + time +
			// "seconds to look through " + binaryD.size()
			// + " items for " + num);
			count++;
		}
		Scene scene = new Scene(lineChart, 800, 600);
		lineChart.getData().add(series);

		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
