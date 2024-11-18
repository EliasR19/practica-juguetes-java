package practica_juguetes;


import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;

public class Juguetes {
	
	public static void main(String[] args) throws Exception {
		//TIPOS DE NIÑOS
		Tipo tipico = new Tipico();
		Tipo curioso = new Curioso();
		Tipo revoltoso = new Revoltoso();
		
		
		balde balde = new balde();
		cuerpoGeo cubo = new cuerpoGeo(4, "azul");
		cuerpoGeo cilindro = new cuerpoGeo(3, "rosa");
		
		
		pelota pelota = new pelota(4);
		
		tacho tachito = new tacho();
		cuerpoGeo tacho1 = new cuerpoGeo(6, "azul");
		cuerpoGeo tacho2 = new cuerpoGeo(5, "azul");
		cuerpoGeo tacho3 = new cuerpoGeo(4, "azul");
		
		nino valentin = new nino(tipico, 10);
		nino zoe = new nino(curioso, 20);
		nino milena = new nino(revoltoso, 15);
		
		

			//System.out.println("Inicia");
			//CVU JUGUETES
			balde.cvu(2);
			pelota.cvu(2);
			tachito.cvu(2);
			
			//PIEZAS BALDE
			balde.agregarPieza(cubo);
			balde.agregarPieza(cilindro);
			
			//PIEZAS TACHITO
			tachito.agregarPieza(tacho1);
			tachito.agregarPieza(tacho2);
			tachito.agregarPieza(tacho3);
			
		//PRUEBAS

		
	}
}



