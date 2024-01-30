package vettore;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class vettoresommacombo extends Application{
	
	TextField tnum = new TextField();
	TextField tmax = new TextField();
	Button briempi = new Button("Riempi");
	Button bcalcola = new Button("Calcola");
	Label lstampa = new Label();
	Label lrisultato = new Label();
	Label lnum = new Label("Quanti Num: ");
	Label lmax = new Label("Num Max: ");
	ComboBox<String> comboperazioni= new ComboBox<>();
	int v[];
	
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		
		griglia.add(tnum, 1, 0);
		griglia.add(tmax, 1, 1);
		griglia.add(lstampa, 0, 4);
		griglia.add(briempi, 0, 3);
		griglia.add(bcalcola, 0, 2);
		griglia.add(lnum, 0, 0);
		griglia.add(lmax, 0, 1);
		griglia.add(lrisultato, 0, 5);
		griglia.add(comboperazioni, 1, 2);
		griglia.setAlignment(Pos.CENTER);
		griglia.setHgap(15);
		griglia.setVgap(10);
		
		comboperazioni.getItems().add("+");
		comboperazioni.getItems().add("-");
		comboperazioni.getItems().add("x");
		bcalcola.setOnAction(e -> calcola());
		briempi.setOnAction(e -> riempi());
		
		Scene scena = new Scene(griglia);
		finestra.setTitle("Esercizio2");
		finestra.setScene(scena);
		finestra.show();
	}
	private void riempi() {
		int n=0;
		n=Integer.parseInt(tnum.getText());
		v=new int[n];
		int max=0;
		max=Integer.parseInt(tmax.getText());
		for(int i=0;i<v.length;i++) {
			v[i]=(int)(Math.random()*max)+1;
		}
	}
	private void calcola() {
		String s="";
		for(int i=0;i<v.length;i++) {
			s=s+v[i]+"-";
		}
		String op="";
		op=comboperazioni.getValue();
		int somma=0;
		int prodotto=1;
		int differenza=0;
		if (op.equals("+")) {
			for(int i=0;i<v.length;i++) {
				somma=somma+v[i];
			}
			lrisultato.setText(somma+"");
		}
		if (op.equals("-")) {
			for(int i=0;i<v.length;i++) {
				differenza=differenza-v[i];
			}
			lrisultato.setText(differenza+"");
		}
		if (op.equals("x")) {
			for(int i=0;i<v.length;i++) {
				prodotto=prodotto*v[i];
			}
			lrisultato.setText(prodotto+"");
		}
		lstampa.setText(s);	
	}

	public static void main(String[] args) {
		launch(args);
	}
}
