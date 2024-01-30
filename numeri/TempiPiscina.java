package vettore;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TempiPiscina extends Application {
	TextField tnum = new TextField();
	TextField tquanti = new TextField();
	Button bstampa = new Button("Stampa");
	Label lelenco = new Label("Elenco");
	Label linseriti = new Label("Conta Volte");
	Label lmaggiore = new Label("Maggiore");
	Label lminore = new Label("Minore");
	Label lmedia = new Label("Media");
	Label lnum = new Label("Numero:");
	Label lquantinum = new Label("Quanti Num:");
	Button binserisci = new Button("Inserisci");
	Button balloca = new Button("Alloca");
	Button bcalcola = new Button("Calcola");
	int V[];
	int numTempi;
	int pos;
	int c;
	double media = 0;

	public void start(Stage finestra) {
		GridPane griglia = new GridPane();

		griglia.add(tnum, 1, 0);
		griglia.add(tquanti, 1, 1);
		griglia.add(balloca, 0, 2);
		griglia.add(bcalcola, 0, 5);
		griglia.add(lmedia, 0, 7);
		griglia.add(linseriti, 1, 2);
		griglia.add(lnum, 0, 0);
		griglia.add(lquantinum, 0, 1);
		griglia.add(lelenco, 0, 6);
		griglia.add(binserisci, 0, 3);
		griglia.add(bstampa, 0, 4);
		griglia.add(lmaggiore, 0, 8);
		griglia.add(lminore, 0, 9);
		griglia.setAlignment(Pos.CENTER);
		griglia.setHgap(15);
		griglia.setVgap(10);
		balloca.setOnAction(e -> alloca());
		binserisci.setOnAction(e -> inserisci());
		bstampa.setOnAction(e -> stampa());
		bcalcola.setOnAction(e -> calcola());

		Scene scena = new Scene(griglia);
		finestra.setTitle("Media | Reset");
		finestra.setScene(scena);
		finestra.show();

	}

	private void alloca() {
		c=Integer.parseInt(tquanti.getText());
		numTempi = Integer.parseInt(tquanti.getText());
		V = new int[numTempi];
		pos = 0;
		linseriti.setText(""+c);
	}

	private void inserisci() {
		if (pos < numTempi) {
			V[pos++] = Integer.parseInt(tnum.getText());
			tnum.setText("");
			c--;
			linseriti.setText(""+c);
		}
	}

	private void stampa() {
		int i;
		int somma = 0;
		String s = "";
		for (i = 0; i < V.length; i++) {
			s = s + V[i] + "|";
			somma = somma + V[i];
		}
		media = somma / V.length;
			lmedia.setText(media + "");
			lelenco.setText(s);
	}
	private void calcola() {
		int i;
		String l = "" ;
		String d = "" ;
		
		for (i = 0; i < numTempi; i++) {
			if (V[i] > media) {
				l=l+V[i]+"-";
				lmaggiore.setText("Maggiori:" + l);
			} else {
					d=d+V[i]+"-";
					lminore.setText("Minori:" + d);
				
			}
		}

	}
	public static void main(String[] args) {
		launch(args);
	}
}
