package convertitore;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Convertitore extends Application {

	TextField tValore = new TextField();
	TextField tBaseP = new TextField();
	TextField tBaseA = new TextField();
	Label lRisultato = new Label();
	Label lConversione = new Label("N. da convertire: ");
	Label lBaseP = new Label("Base di partenza: ");
	Label lBaseA = new Label("Base di arrivo: ");
	Label lConverito = new Label("N° convertito: ");
	Button pCalcola = new Button("Converti");

	public void start(Stage finestra) throws Exception {

		GridPane griglia = new GridPane();

		griglia.add(lConversione, 0, 0);
		griglia.add(tValore, 0, 1);
		griglia.add(tBaseP, 0, 3);
		griglia.add(lBaseP, 0, 2);
		griglia.add(tBaseA, 0, 5);
		griglia.add(lBaseA, 0, 4);
		griglia.add(pCalcola, 0, 7);
		griglia.add(lConverito, 0, 8);
		griglia.add(lRisultato, 0, 9, 2, 1);

		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10));

		Scene scena = new Scene(griglia, 350, 350);
		finestra.setScene(scena);
		finestra.setTitle("Converitore");
		finestra.show();

		pCalcola.setOnAction(e -> Converti());

	}

	private void Converti() {

		int Valore = Integer.parseInt(tValore.getText());
		int baseP = Integer.parseInt(tBaseP.getText());
		int baseA = Integer.parseInt(tBaseA.getText());
		int Resto = 0;
		String s = "";
		int Somma = 0;
		int Potenza = 0;
		String n[] = tValore.getText().split("");
		int v[] = new int[n.length];
		
		for (int i = 0; i < v.length; i++) {
			v[i] = Integer.parseInt(n[i]);
		}

		if (baseP == 10) {
			
			while (Valore > 0) {
				Resto = Valore;
				Valore = Valore / baseA;
				Resto = Resto - (Valore * baseA);
				s = Resto + s;
			}
			
		} else {
			
			if (baseA == 10) {
				Potenza = v.length;
				
				for (int i = 0; i < v.length; i++) {
					Somma += v[i] * Math.pow(baseP, Potenza - 1);
					Potenza--;
					s = "" + Somma;
				}
			}
		}

		lRisultato.setText(s);

	}

	public static void main(String[] args) {
		launch(args);
	}
}
