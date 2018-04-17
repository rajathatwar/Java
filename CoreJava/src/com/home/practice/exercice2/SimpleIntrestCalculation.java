package com.home.practice.exercice2;

public class SimpleIntrestCalculation {

	private double p;
	private int nOM;
	private double rOI;

	public SimpleIntrestCalculation(int p, int nOM, double rOI) {
		this.p = p;
		this.nOM = nOM;
		this.rOI = rOI;
	}

	public static void main(String[] args) {
		SimpleIntrestCalculation s1 = new SimpleIntrestCalculation(1200, 12, 12.5);
		s1.calculteSimpleIntrest(s1.p, s1.nOM, s1.rOI);

	}

	private void calculteSimpleIntrest(double p, int nOM, double rOI) {
		double result = ((p * nOM * rOI) / 100);
		System.out.println("Calculated Simple Intrest : " + result);
	}
}
