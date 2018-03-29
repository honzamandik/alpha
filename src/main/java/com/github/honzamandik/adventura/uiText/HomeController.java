package com.github.honzamandik.adventura.uiText;

import com.github.honzamandik.adventura.logika.IHra;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Kontroler, kterÃ½ zprostÅ™edkovÃ¡vÃ¡ komunikaci mezi grafikou
 * a logikou adventury
 * 
 * @author Filip Vencovsky
 *
 */
public class HomeController extends GridPane {
	
	@FXML private TextField vstupniText;
	@FXML private TextArea vystup;
	
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
	}

}
