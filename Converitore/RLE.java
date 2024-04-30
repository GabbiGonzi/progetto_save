package convertitore;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RLE extends Application {

	Button bcomprimi = new Button("COMPRIMI");
	Label lPesoImmagineCompresso = new Label();
	Label lPesoImmagineCompresso2 = new Label();
	Label lPesoImmagineCompresso3 = new Label();
	Label lPesoImmagine = new Label();
	Label lCompressionRate = new Label("COMPRESSION RATE");

	String m[][];

	public void start(Stage finestra) {

		GridPane griglia = new GridPane();

		griglia.add(bcomprimi, 0, 0);
		griglia.add(lPesoImmagineCompresso, 0, 1);
		griglia.add(lPesoImmagineCompresso2, 0, 2);
		griglia.add(lPesoImmagineCompresso3, 0, 3);
		griglia.add(lPesoImmagine, 0, 5);
		griglia.add(lCompressionRate, 0, 4);

		Scene scena = new Scene(griglia);

		finestra.setTitle("Convertitore RLE");
		finestra.setScene(scena);
		finestra.show();

		bcomprimi.setOnAction(e -> comprimi());

	}

	public void comprimi() {

		int riga = 3;
		int colonna = 3;
		int conta = 1;
		int peso = 0;
		String colore = "";
		m = new String[riga][colonna];

		m[0][0] = "V";
		m[0][1] = "V";
		m[0][2] = "V";
		m[1][0] = "G";
		m[1][1] = "G";
		m[1][2] = "V";
		m[2][0] = "R";
		m[2][1] = "V";
		m[2][2] = "N";

		peso = (riga * colonna) * 24;

		for (int i = 0; i < riga; i++) {
			colore = m[i][0];
			for (int i2 = 1; i2 < colonna; i2++) {
				conta++;
			}
		}

		String riga2 = m[0][0];
		riga2 += m[0][1];
		riga2 += m[0][2];
		String riga3 = m[1][0];
		riga3 += m[1][1];
		riga3 += m[1][2];
		String riga4 = m[2][0];
		riga4 += m[2][1];
		riga4 += m[2][2];

		lPesoImmagine.setText(peso + "");
		lPesoImmagineCompresso.setText(riga2);
		lPesoImmagineCompresso2.setText(riga3);
		lPesoImmagineCompresso3.setText(riga4);
		lCompressionRate.setText("");

	}

	public static void main(String[] args) {
		launch(args);
	}

}