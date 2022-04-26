package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class KalkKontroler extends KalkImpl{
	@FXML
	public void onActionBtnDigit(ActionEvent event) {
		Button btn = (Button)event.getSource();
		setCyfra(btn.getText());
	}
	
	@FXML
	public void onActionBtnPow(ActionEvent event) {
		setOperacja(Operacja.POTEGOWANIE);
	}
	@FXML
	public void onActionBtnMul(ActionEvent event) {
		setOperacja(Operacja.MNOZENIE);
	}
	@FXML
	public void onActionBtnDiv(ActionEvent event) {
		setOperacja(Operacja.DZIELENIE);
	}
	@FXML
	public void onActionBtnAdd(ActionEvent event) {
		setOperacja(Operacja.DODAWANIE);
	}
	@FXML
	public void onActionBtnSub(ActionEvent event) {
		setOperacja(Operacja.ODEJMOWANIE);
	}
	@FXML
	public void onActionBtnPnt(ActionEvent event) {
		textField.appendText(",");
	}
	@FXML
	public void onActionBtnSqrt(ActionEvent event) {
		setOperacja(Operacja.PIERWIASTEK);
		wyn();
	}
	@FXML
	public void onActionBtnInv(ActionEvent event) {
		setOperacja(Operacja.ODWROTNOSC);
		wyn();
	}
	@FXML
	public void onActionBtnMod(ActionEvent event) {
		setOperacja(Operacja.PROCENT);
	}
	@FXML
	public void onActionBtnLog(ActionEvent event) {
		setOperacja(Operacja.LOGARYTM);
		wyn();
	}
	@FXML
	public void onActionBtnEq(ActionEvent event) {
		wyn();
	}
	@FXML
	public void onActionBtnCE(ActionEvent event) {
		textField.setText("");
		textDzial.setText("");
	}
	@FXML
	public void onActionBtnC(ActionEvent event) {
		textField.setText("");
	}
	@FXML
	public void onActionBtnRemove(ActionEvent event) {
		textField.setText(textField.getText().substring(0, textField.getLength()-1));
	}

}
