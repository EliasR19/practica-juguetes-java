package practica_juguetes;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class nino {
	double edad; //en meses
	Tipo tipo;
	ArrayList<juguete> juguetes = new ArrayList<juguete>();
	
	public nino(Tipo _tipo, float edad) {
		this.edad =  edad;
		this.tipo = _tipo;
	}
	
	public double entretenimiento(juguete jugueteMano) {
		
		return tipo.entretenimiento(this, jugueteMano);
	}
	
	public double coeficiente() {
		return 1 + (edad / 100.0);
	}
	
	public double edad() {
		return edad;
	}
	
	public Tipo tipo() {
		return tipo;
	}
	
	public ArrayList<juguete> juguetes() {
		return juguetes;
	}
	
	public void comprar(juguete juguete) throws Exception {
		this.validarComprar(juguete);
		this.agregarJuguete(juguete);
	}
	
	public void validarComprar(juguete juguete) throws Exception {
		if(!tipo.puedeComprar(this, juguete)){
			throw new  Exception("No se puede comprar juguete");
		}
	}
	
	
	
	
	public void donar(nino niño) throws Exception{
		this.validarDonar(niño);
		juguetesQuePuedeDonarA(niño).forEach(j -> niño.agregarJuguete(j));
		juguetesQuePuedeDonarA(niño).forEach(j -> juguetes.remove(j));

	}
	
	public ArrayList<juguete> juguetesQuePuedeDonarA(nino niño) {
				List<juguete> copy = juguetes.stream()
				.filter(j -> niño.tipo().puedeComprar(niño, j))
				.collect(Collectors.toList());
				ArrayList<juguete> juguetes2 = new ArrayList<juguete>(copy);
			return juguetes2;
				
	}
	
	public void validarDonar(nino niño) throws Exception {
		if(!juguetes.stream().anyMatch(j -> niño.tipo().puedeComprar(niño, j))) {
			throw new  Exception("No se puede donar a "+ niño);
		}
	}
	
	//TEST AGREGAR JUGUETES
	public void agregarJuguete(juguete j ) {
		juguetes.add(j);
	}
		
}	

abstract class Tipo {
	
	public double entretenimiento(nino niño, juguete jugueteMano) {
		BigDecimal roundEntret = BigDecimal.valueOf(jugueteMano.eficiencia() * niño.coeficiente())
				.setScale(1, RoundingMode.HALF_EVEN);
		return roundEntret.doubleValue();
	}
	
	public abstract boolean puedeComprar(nino niño, juguete juguete);

	
}

class Tipico extends Tipo {
	public boolean puedeComprar(nino niño, juguete juguete) {
		return true;
	}
}

class Curioso extends Tipo {
	public double entretenimiento(nino niño, juguete jugueteMano) {
		return super.entretenimiento(niño, jugueteMano) * 1.5f;
	}
	
	public boolean puedeComprar(nino niño, juguete juguete){
		return juguete.precio() < 150 ;
	}

}

class Revoltoso extends Tipo {
	public double entretenimiento(nino niño, juguete jugueteMano) {
		return super.entretenimiento(niño, jugueteMano) / 2 ;
	}
	
	public boolean puedeComprar(nino niño,juguete juguete){
		return niño.entretenimiento(juguete) > 7;
		
	}
}	

	

