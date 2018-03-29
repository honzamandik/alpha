package com.github.honzamandik.adventura.uiText;

import java.util.Observable;
import java.util.Observer;

import com.github.honzamandik.adventura.logika.IHra;
import com.github.honzamandik.adventura.logika.Prostor;
import com.github.honzamandik.adventura.logika.Vec;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * Kontroler, kterÃ½ zprostÅ™edkovÃ¡vÃ¡ komunikaci mezi grafikou
 * a logikou adventury
 * 
 * @author Filip Vencovsky
 *
 */
public class HomeController extends GridPane implements Observer {
	
	@FXML private TextField vstupniText;
	@FXML private TextArea vystup;
	@FXML private ListView<Vec> seznamVeciMistnost;
	@FXML private ListView<Prostor> seznamVychodu;
	@FXML private ImageView uzivatel;
	
	private IHra hra;
	
	/**
	 * metoda Ä�te pÅ™Ã­kaz ze vstupnÃ­ho textovÃ©ho pole
	 * a zpracuje ho
	 */
	@FXML public void odesliPrikaz() {
		String vystupPrikazu = hra.zpracujPrikaz(vstupniText.getText());
		vystup.appendText("\n----------\n"+vstupniText.getText()+"\n----------\n");
		vystup.appendText(vystupPrikazu);
		vstupniText.setText("");
		if(hra.konecHry()) {
			vystup.appendText("\n----------\nKonec hry\n----------\n");
			vstupniText.setDisable(true);
		}
	}
	
	/**
	 * Metoda bude souÅ¾it pro pÅ™edÃ¡nÃ­ objektu se spuÅ¡tÄ›nou hrou
	 * kontroleru a zobrazÃ­ stav hry v grafice.
	 * @param objekt spuÅ¡tÄ›nÃ© hry
	 */
	public void inicializuj(IHra hra) {
		vystup.setText(hra.vratUvitani());
		vystup.setEditable(false);
		this.hra = hra;
		seznamVeciMistnost.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVeci());
		seznamVychodu.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVychody());
		uzivatel.setX(hra.getHerniPlan().getAktualniProstor().getX());
		uzivatel.setY(hra.getHerniPlan().getAktualniProstor().getY());
		hra.getHerniPlan().addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		seznamVeciMistnost.getItems().clear();
		seznamVychodu.getItems().clear();
		seznamVeciMistnost.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVeci());
		seznamVychodu.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVychody());
		uzivatel.setX(hra.getHerniPlan().getAktualniProstor().getX());
		uzivatel.setY(hra.getHerniPlan().getAktualniProstor().getY());
		
	}

}
