package practica_juguetes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

abstract class juguete {

	public abstract int costo() ;
	public int precio() {
		return (this.eficiencia() * 10 ) + this.costo();
	}
	public abstract int eficiencia() ;
	
	int cvu;
	
	
	public void cvu(int valor) {
		cvu = valor;
	}
	
}

class pelota extends juguete {
		
		public int radio;
		
		public pelota(int radio) {
			this.radio = radio;
		}
	
		
		public int costo() {
			return (radio * 3) * cvu; 
		}
		
		
		public int eficiencia() {
			return 12;
		}
	
	
}

class balde extends juguete {
	
	ArrayList<cuerpoGeo> partes = new ArrayList<cuerpoGeo>();
	
	public void agregarPieza(cuerpoGeo pieza) {
		partes.add(pieza);
	}
	
	public int costo() {
		return this.costoFijo() + (this.cantidadPartes() * this.precioPiezaMayorVolumen() );
	}
	
	public int costoFijo() {
		return 5;
	}
	
	
	public int precioPiezaMayorVolumen() {
		return this.piezaMayorVolumen().volumen() * cvu;
	}
	
	
	public cuerpoGeo piezaMayorVolumen() {
		return Collections.max(partes , Comparator.comparing ( pieza -> pieza.volumen() ));
	}
	
	public int cantidadPartes() {
		return partes.size();
	}
	

	public int precio() {
		return super.precio() + this.sumaSiHayRosa();
	}
	
	public int sumaSiHayRosa() {
		if(this.hayAlgunaParteRosa()) {
			return 20;
		} else
			return 0;
	}
	
	public boolean hayAlgunaParteRosa() {
		return partes.stream().anyMatch(parte -> parte.color() == "rosa");
	}
	
	public int eficiencia() {
		return 3 * this.cantidadPartes();
	}

}

class tacho extends balde {
	
	public int costoFijo() {
		return 3;
	}
	
	public int eficiencia() {
		return partes.stream().mapToInt(p -> p.volumen()).sum();
	}
}


class cuerpoGeo {
	public int volumen;
	public String color;
	
	public cuerpoGeo(int volumen, String color) {
		this.volumen = volumen;
		this.color = color;
	}
	
	public int volumen() {
		return volumen;
	}
	
	public String color() {
		return color;
	}
}
	

