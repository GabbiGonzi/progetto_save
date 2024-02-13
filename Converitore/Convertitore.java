package Convertitore;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Convertitore extends Application {

	TextField tnumero = new TextField();
	TextField tbase = new TextField();
	Label lnumero = new Label("N° da convertire: ");
	Label lbase = new Label("Inserire la base di conversione: ");
	Label lnumerocreato = new Label("Numero Convertito:");
	Label lris = new Label();
	Button bconverti = new Button("Converti");

	public void start(Stage finestra) {
		GridPane griglia = new GridPane();

		griglia.add(tnumero, 1, 0);
		griglia.add(tbase, 1, 1);
		griglia.add(lnumero, 0, 0);
		griglia.add(lbase, 0, 1);
		griglia.add(lnumerocreato, 0, 2);
		griglia.add(lris, 1, 2);
		griglia.add(bconverti, 1, 3);
		griglia.setVgap(10);
		griglia.setHgap(10);
		griglia.setAlignment(Pos.CENTER);
		bconverti.setOnAction(e -> converti());

		Scene scene = new Scene(griglia, 300, 300);
		finestra.setScene(scene);
		finestra.setTitle("Convertitore");
		finestra.show();
	}

	public void converti() {
		int valore = Integer.parseInt(tnumero.getText());
		int base = Integer.parseInt(tbase.getText());
		int Resto = 0;
		int i = 0;
		String s = "";
		for (i = 1; valore > 0; i++) {
			Resto = valore;
			valore = valore / base;
			Resto = Resto - (valore * base);
			s = Resto + s;
		}
		lris.setText(s);
	}
	public static void main(String[] args) {
		launch(args);
	}
}
