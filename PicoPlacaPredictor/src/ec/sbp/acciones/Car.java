package ec.sbp.acciones;
import ec.sbp.acciones.Hour;

public class Car {
	//Atributos
	private String placaLetras;
	private int placaNumeros;
	 
	//Metodo para calcular si puede circular o no
	public boolean Circula(int placa, int dia, String h) {
		int ultimoDigito = placa%10; 
		Hour hora = new Hour();
		boolean puede = hora.HoraCirculacion(h);
		
		switch (ultimoDigito) {
			case 0: case 1: //0 y 1 no circulan lunes 
				if (dia==2 && puede==false) {
					return false;
				}else {
					
				}return true;
				
			case 2: case 3: //2 y 3 no circulan martes 
				if (dia==3 && puede==false) {
					return false;
				}else return true;
			
			case 4: case 5: //4 y 5 no circulan miércoles
				if (dia==4 && puede==false) {
					return false;
				}else return true;
				
			case 6: case 7: //6 y 7 no circulan jueves
				if (dia==5 && puede==false) {
					return false;
				}else return true;
				
			case 8: case 9: //8 y 9 no circulan viernes
				if (dia==6 && puede==false) {
					return false;
				}else return true;
			
			default: return false; 
		}
		
		
	}
}
