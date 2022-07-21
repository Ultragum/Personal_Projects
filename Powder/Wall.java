/*
 * Written by Jamel Chouarfia
 */

import java.awt.Color;
import java.util.Random;

public class Wall {
	private static double ThermalConductivity = 0;
	private static double Temp = 20;
	private static Color Color = new Color(100, 100, 100);
	private static char Symbol = 'W';
	
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
