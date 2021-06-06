package ec.sbp.acciones;

public class Hour {
	//valida el campo hora
	public Boolean ValidarHora(String hora) {
		boolean b;
		char []a = hora.toString().toCharArray();
		String []c = hora.split(":");
		if ((a[0]==' ') || (a[1]==' ') || (a[2]==' ') || (a[3]==' ') || (getInt(c[0])>24) || (getInt(c[1])>59)) {
			b = false;
		} else {b = true;}
		return b;
	}

	private int getInt(String valor) {
		int n = Integer.parseInt(valor);
		return n;
	}
	
	//validar la circulación por horario
	public Boolean HoraCirculacion(String hora) {
		boolean b;
		char []a = hora.toString().toCharArray();
		String []c = hora.split(":");
		String d = c[0]+c[1];
		int nh = getInt(d);
		if (nh>700 && nh<930) {	
			b = false;
		}else if (nh>1600 && nh<1930) {	
			b = false;
		}else b = true;
			
		return b;
		
	}
}
