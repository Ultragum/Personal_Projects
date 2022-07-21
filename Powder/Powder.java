/*
 * Written by Jamel Chouarfia
 */

import java.awt.Color;
import java.util.Random;

public class Powder {
	String Name;
	Color Color;
	double ThermalConductivity;
	double Temp;
	char Symbol;
	int X;
	int Y;
	
	Powder(String Name, int X, int Y) {
		ThermalConductivity = Lookup.ThermalConductivityOf(Name);
		Color = Lookup.ColorOf(Name);
		Temp = Lookup.TempOf(Name);
		Symbol = Lookup.SymbolOf(Name);
		this.Name = Name;
		this.X = X;
		this.Y = Y;
	}
	
	public void move(Random random, char[][] Occupied) {
		int[] moveTo = new int[2];
		moveTo[0] = X;
		moveTo[1] = Y;
		moveTo = Lookup.Move(Name, moveTo, random);
		
		if (Occupied[moveTo[0]][moveTo[1]] == 'N') {
			Occupied[moveTo[0]][moveTo[1]] = getSymbol();
			Occupied[X][Y] = 'N';
			this.setX(moveTo[0]);
			this.setY(moveTo[1]);
		}
	}
	
	public void UpdateTemp() {
		
	}
	
	public void setX(int X) {
		this.X = X;
	}
	
	public void setY(int Y) {
		this.Y = Y;
	}
	
	public String getName() {
		return Name;
	}
	
	public Color getColor() {
		return Color;
	}
	
	public char getSymbol() {
		return Symbol;
	}
}
