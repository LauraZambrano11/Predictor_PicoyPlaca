package ec.sbp.acciones;

public class Car {
	//Atributtes
	private String placaLetras;
	private int placaNumeros;
	
	//Method to know if the car can be on the road
	public boolean Circula(int placa, String fecha, String hora) {
		
		if(placa==1) {
			return true;
		}
		else {
			return false;
		}
		
	}
}
