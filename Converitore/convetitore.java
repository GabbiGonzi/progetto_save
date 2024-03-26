package convertitore;

import java.util.Hashtable;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
public class convetitore extends Application {

	TextField tNum = new TextField();
	TextField tBaseDiPartenza = new TextField();
	TextField tBaseDiArrivo = new TextField();
	Label lRis = new Label("Risultato");
	Button pConverti = new Button("converti");
	Label lbasearrivo = new Label("Base Di Arrivo");
	Label lnumerodaconvertire = new Label("Numero da convertire");
	Label lbasepartenza = new Label("Base Di Partenza");

	public void start(Stage finestra) {

		GridPane griglia = new GridPane();

		griglia.add(lnumerodaconvertire, 0, 0);
		griglia.add(tNum, 0, 1);
		griglia.add(lbasepartenza, 0, 2);
		griglia.add(tBaseDiPartenza, 0, 3);
		griglia.add(lbasearrivo, 0, 4);
		griglia.add(tBaseDiArrivo, 0, 5);
		griglia.add(lRis, 0, 6);
		griglia.add(pConverti, 0, 7);
		griglia.setHgap(15);
		griglia.setVgap(15);
		griglia.setAlignment(Pos.CENTER);
		
		pConverti.setOnAction(e -> converti());

		Scene scene = new Scene(griglia,350,350);
		finestra.setScene(scene);
		finestra.setTitle("convertitore");
		finestra.show();

	}

	public void converti() {

		String num = tNum.getText();
	    int numeroDecimale = 0;
		int basearrivo = Integer.parseInt(tBaseDiPartenza.getText());
		int basepartenza = Integer.parseInt(tBaseDiArrivo.getText());
		Hashtable<Character, Integer> Base16 = new Hashtable<>();
		for (int i = 0; i < 10; i++) {
			Base16.put((char) ('0' + i), i);
		}
		for (int i = 10; i < 16; i++) {
			Base16.put((char) ('A' + i - 10), i);
		}

		for (int i = 0; i < num.length(); i++) {
			char cifra = num.charAt(i);
			int valoreCifra = Base16.get(cifra);
			numeroDecimale = numeroDecimale * basearrivo + valoreCifra;

		}

		StringBuilder risultato = new StringBuilder();

		while (numeroDecimale > 0) {
			int resto = numeroDecimale % basepartenza;
			char cifra = (resto < 10) ? (char) ('0' + resto) : (char) ('A' + resto - 10);
			risultato.insert(0, cifra);
			numeroDecimale /= basepartenza;
		}

		lRis.setText(risultato.toString());

	}

	public static void main(String[] args) {

		launch(args);

	}

}