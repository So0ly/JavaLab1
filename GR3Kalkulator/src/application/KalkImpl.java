package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class KalkImpl implements KalkInterfejs {
	@FXML
	public TextField textField;
	public TextField textDzial;
	private Operacja operacja;
	private Double liczba1;
	private Double liczba2=Double.valueOf("0");
	private boolean czysc=false;
	private char znak;
	
	public void setOperacja(Operacja operacja) {
		this.operacja=operacja;
		czysc=true;
	}
	@Override
	public void setCyfra(String str) {
		if(czysc==true) {
			liczba1=getLiczba();
			textDzial.appendText(liczba1.toString());
			textField.setText("");
			czysc=false;
		}
		textField.appendText(str);
	}
	
	public double getLiczba() {
		String strValue = textField.getText();
			Double value = Double.parseDouble(strValue.replace(',','.'));
			return value;
	}
	public void wyn() {
		liczba2=getLiczba();
		textField.setText(oblicz(liczba1, liczba2,this.operacja).toString());
	}

	public Double oblicz(Double liczba1, Double liczba2, Operacja operacja) throws ArithmeticException {
		try {
		switch(this.operacja) {
		case DODAWANIE:
			znak='+';
			textDzial.setText((liczba1.toString()+znak+liczba2.toString()));
			liczba2+=liczba1;
			break;
		case ODEJMOWANIE:
			znak='-';
			textDzial.setText((liczba1.toString()+znak+liczba2.toString()));
			liczba2=liczba1-liczba2;
			break;
		case MNOZENIE:
			znak='*';
			textDzial.setText((liczba1.toString()+znak+liczba2.toString()));
			liczba2*=liczba1;
			break;
		case DZIELENIE:
			znak='/';
			textDzial.setText((liczba1.toString()+znak+liczba2.toString()));
			if(liczba2==Double.parseDouble("0")){
				throw new ArithmeticException();
				
			}else{
				liczba2=liczba1/liczba2;
			}
			break;
		case LOGARYTM:
			textDzial.setText("log("+liczba2.toString()+")");
			liczba2=Math.log10(liczba2);
			czysc=false;
			break;
		case ODWROTNOSC:
			textDzial.setText("1/"+liczba2.toString());
			liczba2=1/liczba2;
			czysc=false;
			break;
		case PROCENT:
			znak='%';
			textDzial.setText((liczba1.toString()+znak+liczba2.toString()));
			liczba2=(liczba2/liczba1)*100;
			czysc=false;
			break;
		case PIERWIASTEK:
			textDzial.setText("sqrt("+liczba2.toString()+")");
			liczba2=Math.sqrt(liczba2);
			czysc=false;
			break;
		case POTEGOWANIE:
			znak='^';
			textDzial.setText((liczba1.toString()+znak+liczba2.toString()));
			liczba2=Math.pow(liczba1, liczba2);
			break;
		case BRAK:
			break;
		}
		}catch (Exception e) {
			textField.setText("Nie mo¿na dzieliæ przez zero");
			liczba2=null;
		}
		return liczba2;
	}
}

