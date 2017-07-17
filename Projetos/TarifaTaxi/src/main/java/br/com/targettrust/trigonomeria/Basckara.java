package br.com.targettrust.trigonomeria;

public class Basckara {

	private double a, b, c, delta;
	
	public Basckara() {
		
	}
    
	public Basckara(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double calculaDelta() {
		this.delta = b*b - (4*a*c);
		return delta;
	}

	public double calculaRaizUm() throws Exception {
		double xUm = 0;
		if(delta < 0 ) {
			throw new Exception("Não existe delta");
		} else {
			xUm =  ((-this.b + Math.sqrt(this.calculaDelta())) / 2*this.a);
		}
		
		return xUm;
	}
	public double calculaRaizDois() throws Exception {
		double xDois = 0;
		if(delta < 0 ) {
			throw new Exception("Não existe delta");
		} else {
			xDois =  ((-this.b - Math.sqrt(this.calculaDelta())) / 2*this.a);
		}
		
		return xDois;
	}

	

}
