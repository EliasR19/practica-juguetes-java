package practica_juguetes;

import java.math.BigDecimal;

public class nino {
	double edad; //en meses
	Tipo tipo;
	
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
	
	//tests
	public double edad() {
		return edad;
	}
	
}

abstract class Tipo {
	
	public double entretenimiento(nino niño, juguete jugueteMano) {
		BigDecimal roundEntret = BigDecimal.valueOf(jugueteMano.eficiencia() * niño.coeficiente())
				.setScale(1, BigDecimal.ROUND_HALF_UP);
		return roundEntret.doubleValue();
	}

	
}

class Tipico extends Tipo {

}

class Curioso extends Tipo {
	public double entretenimiento(nino niño, juguete jugueteMano) {
		return super.entretenimiento(niño, jugueteMano) * 1.5f;
	}
}

class Revoltoso extends Tipo {
	public double entretenimiento(nino niño, juguete jugueteMano) {
		return super.entretenimiento(niño, jugueteMano) / 2 ;
	}
	
}
