package practica_juguetes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;


class juguetesTest {
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
	
	
	@BeforeEach
	public void init() {
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
		
	}
	
	@Test
	void costoDeJuguetes() {
		assertEquals(21, balde.costo());
		assertEquals(39, tachito.costo());
		assertEquals(24, pelota.costo());
	}
	
	@Test
	void eficienciaJugteres() {
		assertEquals(12, pelota.eficiencia());
		assertEquals(6, balde.eficiencia());
		assertEquals(15, tachito.eficiencia());
	}
	
	@Test
	void precioJueguetes() {
		assertEquals(144, pelota.precio());
		assertEquals(101, balde.precio());
		assertEquals(189, tachito.precio());
		
	}
	
	@Test 
	void entretenimientoNiños() {
		assertEquals(13.2, valentin.entretenimiento(pelota));
		assertEquals(21.6, zoe.entretenimiento(pelota));	
		assertEquals(6.9, milena.entretenimiento(pelota));
	}
	
	@Test
	void comprarJuguetes_Tipico() {
		try {
			valentin.comprar(pelota);
			valentin.comprar(tachito);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		ArrayList<juguete> juguetes = new ArrayList<juguete>();
		juguetes.add(pelota);
		juguetes.add(tachito);
		
		
		assertTrue(juguetes.equals(valentin.juguetes()));
	}
	
	
	@Test
	void comprarJuguetes_Curioso() throws Exception {

			zoe.comprar(pelota);
			assertThrows(Exception.class, () -> zoe.comprar(tachito));
		
		ArrayList<juguete> juguetes = new ArrayList<juguete>();
		juguetes.add(pelota);
		
		assertTrue(juguetes.equals(zoe.juguetes()));
	}
	
	@Test
	void comprarJuguetes_Revoltoso() throws Exception {

		assertThrows(Exception.class, () -> milena.comprar(pelota));
		milena.comprar(tachito);
		
		ArrayList<juguete> juguetes = new ArrayList<juguete>();
		juguetes.add(tachito);
		
		assertTrue(juguetes.equals(milena.juguetes()));
	}
	
	@Test
	void puedeDonar() throws Exception {
		valentin.agregarJuguete(balde);
		valentin.agregarJuguete(pelota);
		valentin.agregarJuguete(tachito);
		
		valentin.donar(milena);
		
		ArrayList<juguete> juguetesM = new ArrayList<juguete>();
		juguetesM.add(tachito);
		
		assertTrue(juguetesM.equals(milena.juguetes()));
		
		ArrayList<juguete> juguetesV = new ArrayList<juguete>();
		juguetesV.add(balde);
		juguetesV.add(pelota);
		
		assertTrue(juguetesV.equals(valentin.juguetes()));
	}
	
	@Test
	void noPuedeDonar() throws Exception {
		zoe.agregarJuguete(balde);
		zoe.agregarJuguete(pelota);

		assertThrows(Exception.class, () -> zoe.donar(milena));

		
		ArrayList<juguete> juguetes = new ArrayList<juguete>();
		juguetes.add(balde);
		juguetes.add(pelota);
		
		
		ArrayList<juguete> juguetesM = new ArrayList<juguete>();

		
		assertTrue(juguetes.equals(zoe.juguetes()));
		assertTrue(juguetesM.equals(milena.juguetes()));
	}
		
		
		
		


}

