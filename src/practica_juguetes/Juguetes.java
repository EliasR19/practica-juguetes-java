package practica_juguetes;

public class Juguetes {

	public static void main(String[] args) {
		
		
		balde balde = new balde();
		cuerpoGeo cubo = new cuerpoGeo(4, "azul");
		cuerpoGeo cilindro = new cuerpoGeo(3, "rosa");
		
		balde.agregarPieza(cubo);
		balde.agregarPieza(cilindro);
		balde.cvu(2);
		
		System.out.println("costo balde = " + balde.costo());
		System.out.println("Eficiencia de balde = " + balde.eficiencia());
		System.out.println("precio balde = " + balde.precio());
		
		
		pelota pelota = new pelota(4);
		pelota.cvu(2);
		
		System.out.println("costo pelota = " + pelota.costo());
		System.out.println("Eficiencia de pelota = " + pelota.eficiencia());
		System.out.println("precio pelota = " + pelota.precio());
		
		
		tacho tachito = new tacho();
		tachito.cvu(2);
		cuerpoGeo tacho1 = new cuerpoGeo(6, "azul");
		cuerpoGeo tacho2 = new cuerpoGeo(5, "azul");
		cuerpoGeo tacho3 = new cuerpoGeo(4, "azul");
		
		tachito.agregarPieza(tacho1);
		tachito.agregarPieza(tacho2);
		tachito.agregarPieza(tacho3);
		
		
		System.out.println("tachito costo = " + tachito.costo());
		System.out.println("Eficiencia de tachito = " + tachito.eficiencia());
		System.out.println("precio tachito = " + tachito.precio());
		

	}
	

}


