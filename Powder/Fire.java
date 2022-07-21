/*
 * Written by Jamel Chouarfia
 */

import java.awt.Color;
import java.util.Random;

public class Fire {
	private static double ThermalConductivity = 80;
	private static double Temp = 600;
	private static Color Color = new Color(255, 165, 0);
	private static char Symbol = 'F';
	
	public static int[] move(int[] Pos, Random random) {
		switch(random.nextInt(5)) {
			case 0:
				Pos[1] = Pos[1] - 1; 
				break;
			case 1:
				Pos[1] = Pos[1] - 1;
				Pos[0] = Pos[0] - 1;
				break;
			case 2:
				Pos[1] = Pos[1] - 1;
				Pos[0] = Pos[0] + 1;
				break;
			case 3:
				Pos[0] = Pos[0] - 1;
				break;
			case 4:
				Pos[0] = Pos[0] + 1;
				break;
		}
		
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
