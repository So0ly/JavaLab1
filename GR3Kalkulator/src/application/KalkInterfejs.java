package application;

public interface KalkInterfejs {
	void setOperacja(Operacja operacja);
	void setCyfra(String str);
	double getLiczba();
	Double oblicz(Double liczba1, Double liczba2, Operacja operacja);
	enum Operacja{
		BRAK,DODAWANIE,ODEJMOWANIE,MNOZENIE,DZIELENIE,PIERWIASTEK,ODWROTNOSC,LOGARYTM,PROCENT,POTEGOWANIE
	}
}
