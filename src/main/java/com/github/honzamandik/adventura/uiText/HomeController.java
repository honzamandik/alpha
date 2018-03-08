package com.github.honzamandik.adventura.uiText;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class HomeController extends GridPane {
@FXML private TextField vstupniText;
public void odesliPrikaz () {
	System.out.println(vstupniText.getText());
	vstupniText.setText("");
}
}
