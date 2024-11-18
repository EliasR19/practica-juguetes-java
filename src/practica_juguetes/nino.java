package practica_juguetes;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

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
	
	public ArrayList<juguete> juguetes() {
		return juguetes;
	}
	
	public void comprar(juguete juguete) throws Exception {
		this.validarCompraSegunTipo(this, juguete);
		juguetes.add(juguete);
	}
	
	public void validarCompraSegunTipo(nino niño, juguete juguete) throws Exception {
			tipo.validarJuguete(niño, juguete);
	}
		
}	

abstract class Tipo {
	
	public double entretenimiento(nino niño, juguete jugueteMano) {
		BigDecimal roundEntret = BigDecimal.valueOf(jugueteMano.eficiencia() * niño.coeficiente())
				.setScale(1, RoundingMode.HALF_EVEN);
		return roundEntret.doubleValue();
	}
	
	public abstract void validarJuguete(nino niño, juguete juguete) throws Exception;

	
}

class Tipico extends Tipo {
	public void validarJuguete(nino niño, juguete juguete) {
		
	}
}

class Curioso extends Tipo {
	public double entretenimiento(nino niño, juguete jugueteMano) {
		return super.entretenimiento(niño, jugueteMano) * 1.5f;
	}
	
	public void validarJuguete(nino niño, juguete juguete) throws Exception{
		if(juguete.precio() > 150 ) {
			throw new  Exception("Curioso no puede comprar " + juguete);
	}
}
}

class Revoltoso extends Tipo {
	public double entretenimiento(nino niño, juguete jugueteMano) {
		return super.entretenimiento(niño, jugueteMano) / 2 ;
	}
	
	public void validarJuguete(nino niño,juguete juguete) throws Exception{
		if(niño.entretenimiento(juguete) <= 7) {
			throw new  Exception("Para Revoltoso el juguete es aburrido");
		}
	}
	}	

	

