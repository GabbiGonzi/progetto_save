package convertitore;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class errori extends Application {
	TextField tbit = new TextField();
	RadioButton b1 = new RadioButton("Bit di parita");
	RadioButton b2 = new RadioButton("Hamming");
	RadioButton b3 = new RadioButton();
	Label lris = new Label();

	public void start(Stage finestra) {
		GridPane griglia = new GridPane();

		ToggleGroup grupp = new ToggleGroup();
		b1.setToggleGroup(grupp);
		b2.setToggleGroup(grupp);
		b3.setToggleGroup(grupp);

		Button bcalcola = new Button();
		bcalcola.setText("Calcola");
		bcalcola.setOnAction(e -> calcola());
		Label ltesto = new Label("Messaggio: ");
		Label ltesto1 = new Label("Numeri separati ");

		griglia.add(ltesto, 0, 0);
		griglia.add(ltesto1, 2, 0);
		griglia.add(tbit, 1, 0);
		griglia.add(b1, 0, 1);
		griglia.add(b2, 0, 2);
		griglia.add(b3, 0, 3);
		griglia.add(lris, 0, 6, 2, 6);
		griglia.add(bcalcola, 1, 5);
		griglia.setAlignment(Pos.CENTER);
		griglia.setHgap(10);
		griglia.setVgap(10);

		Scene scena = new Scene(griglia, 350, 350);
		finestra.setTitle("errori");
		finestra.setScene(scena);
		finestra.show();
	}

	private void calcola() {
		int conta = 0;
		String s = "";
		String vett = tbit.getText();
		String tempi[] = vett.split(" ");
		int v[] = new int[tempi.length];
		for (int i = 0; i < v.length; i++) {
			v[i] = Integer.parseInt(tempi[i]);
		}
		for (int i = 0; i < v.length - 1; i++) {
			s = s + "" + v[i];
		}
		if (b1.isSelected()) {
			for (int i = 0; i < v.length; i++) {
				if (v[i] == 1) {
					conta = conta + 1;
				}
			}
			if (conta % 2 == 0) {
				lris.setText("I bit sono pari " + s);
			} else {
				lris.setText("I bit  non sono pari ");
			}
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

}