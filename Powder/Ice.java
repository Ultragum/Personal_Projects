/*
 * Written by Jamel Chouarfia
 */

import java.awt.Color;
import java.util.Random;

public class Ice {
	private static double ThermalConductivity = 2.541;
	private static double Temp = -20;
	private static Color Color = new Color(173, 216, 230);
	private static char Symbol = 'I';
			
	public static int[] move(int[] Pos, Random random) {
		return Pos;
	}
	
	public static double getThermalConductivity() {
		return ThermalConductivity;
	}
	
	public static double getTemp() {
		return Temp;
	}
	
	public static Color getColor() {
		return Color;
	}
	
	public static char getSymbol() {
		return Symbol;
	}
}
