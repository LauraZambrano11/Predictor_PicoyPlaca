package ec.sbp.acciones;

public class Car {
	//Atributtes
	private String placaLetras;
	private int placaNumeros;
	
	//Method to know if the car can be on the road
	public boolean Circula(int placa, int dia) {
		
		int ultimoDigito = placa%10; 
		
		switch (ultimoDigito) {
			case 0: case 1: //0 y 1 no circulan lunes 
				if (dia==2) {
					return false;
				}else return true;
				
			case 2: case 3: //2 y 3 no circulan martes 
				if (dia==3) {
					return false;
				}else return true;
			
			case 4: case 5: //4 y 5 no circulan miércoles
				if (dia==4) {
					return false;
				}else return true;
				
			case 6: case 7: //6 y 7 no circulan jueves
				if (dia==5) {
					return false;
				}else return true;
				
			case 8: case 9: //8 y 9 no circulan viernes
				if (dia==6) {
					return false;
				}else return true;
			
			default: return false; 
		}
		
		
	}
}
