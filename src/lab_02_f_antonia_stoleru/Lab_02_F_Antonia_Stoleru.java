/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_02_f_antonia_stoleru;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author 2484936
 */
public class Lab_02_F_Antonia_Stoleru extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        
        Label days = new Label("Number of days on the trip:");
        grid.add(days, 0, 0);
        TextField d = new TextField();
        grid.add(d, 1, 0);
        
        Label airfare = new Label("Amount of airfare:");
        grid.add(airfare, 0, 1);
        TextField a = new TextField();
        grid.add(a, 1, 1);
        
        Label carRental = new Label("Amount of car rental fees:");
        grid.add(carRental, 0, 2);
        TextField cr = new TextField();
        grid.add(cr, 1, 2);
        
        Label miles = new Label("Number of miles driven with private vehicle:");
        grid.add(miles, 0, 3);
        TextField m = new TextField();
        grid.add(m, 1, 3);
        
        Label parking = new Label("Amount of parking fees:");
        grid.add(parking, 0, 4);
        TextField p = new TextField();
        grid.add(p, 1, 4);
        
        Label taxi = new Label("Amount of taxi charges:");
        grid.add(taxi, 0, 5);
        TextField t = new TextField();
        grid.add(t, 1, 5);
        
        Label conference = new Label("Conference/Seminar fees:");
        grid.add(conference, 0, 6);
        TextField c = new TextField();
        grid.add(c, 1, 6);
        
        
        Label lodging = new Label("Lodging charges, per night:");
        grid.add(lodging, 0, 7);
        TextField l = new TextField();
        grid.add(l, 1, 7);
        
        Label result = new Label();
        result.setVisible(false);
        grid.add(result, 0, 9, 2, 1);
        
        Button calculate = new Button("Calculate total travel expenses");
        grid.add(calculate, 0, 8, 2, 1);
        
        Scene scene = new Scene(grid, 300, 375);
        stage.setScene(scene);
        stage.show();
        
        calculate.setOnAction(e -> {
            try {
                int daysTrip = Integer.parseInt(d.getText());
                double airF = Double.parseDouble(a.getText());
                double carRen = Double.parseDouble(cr.getText());
                double milesDri = Double.parseDouble(m.getText());
                double taxiChar = Double.parseDouble(t.getText());
                double con = Double.parseDouble(c.getText());
                double lodgingChar = Double.parseDouble(l.getText());
                
                double totalIncurred = daysTrip + airF + carRen + milesDri + 
                               taxiChar + con + (lodgingChar * daysTrip);
                
                
                double allowMeal = daysTrip * 37;
                double allowPark = daysTrip * 10;
                double allowTaxi = daysTrip * 20;
                double allowLodge = daysTrip * 95;
                double allowMiles = milesDri * 0.27;
                
                double totalAllowable = allowMeal + allowPark + allowTaxi + allowLodge + allowMiles;
                
                double excess = Math.max(0, totalIncurred - totalAllowable); 
                double saved = Math.max(0, totalAllowable - totalIncurred);
                
                result.setText(
                        "Total incurred: " + String.format("%.2f", totalIncurred) + "$\n" +
                        "Total allowable: " + String.format("%.2f", totalAllowable) + "$\n" +
                        "Excess to pay: " + String.format("%.2f", excess) + "$\n" +
                        "Amount saved: " + String.format("%.2f", saved) + "$"
                );
                result.setVisible(true);
            } catch (NumberFormatException ex) {
            result.setText("Please enter valid numeric values in all fields.");
            }
        });
    }
}
