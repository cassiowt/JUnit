package br.com.cawt.trigonometria;

public class Baskara {

	private int a, b, c;
	

	public Baskara(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public int delta() {		
		return this.b*this.b -(4 * this.a * this.c);
	}

	public double raizUm() {
		return (-this.b + Math.sqrt(delta())) / 2 * this.a;
	}
	
	public double raizDois() {
		return (this.b + Math.sqrt(delta())) / 2 * this.a;
	}

}
