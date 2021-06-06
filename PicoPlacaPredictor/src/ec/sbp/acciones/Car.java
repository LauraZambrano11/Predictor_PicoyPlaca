package ec.sbp.acciones;
import ec.sbp.acciones.Hour;

public class Car {
	//Valida la Placa 
	public boolean ValidaPlaca(String placa) {
		char []a = placa.toString().toCharArray();
		if ((a[0]==' ') || (a[1]==' ') || (a[2]==' ') || (a[3]==' ') || (a[4]==' ') || (a[5]==' ') || (a[6]==' ')) {
			return false;
		} else {
			return true;
		}	
	}
	//Devuelve el último dígito
	public int UltimoNumero(String placa) {
		char []a = placa.toString().toCharArray();
		String []c = placa.split("-");
		int n = Integer.parseInt(c[1]);		
		int n2 = n%10;
		return n2;
	}
	
	//Calcula si puede circular o no
	public boolean Circula(int ultimoDigito, int dia, String h) {
		//int ultimoDigito = placa%10; 
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
