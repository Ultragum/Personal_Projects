/*
 * Written by Jamel Chouarfia
 */

import java.awt.Color;
import java.util.Random;

public class Steam {
	private static double ThermalConductivity = 0.016;
	private static double Temp = 120;
	private static Color Color = new Color(192, 192, 192);
	private static char Symbol = 'S';
	
	public static int[] move(int[] Pos, Random random) {
		switch(random.nextInt(9)) {
			case 0:
				Pos[1] = Pos[1] + 1; 
				break;
			case 1:
				Pos[1] = Pos[1] + 1;
				Pos[0] = Pos[0] - 1;
				break;
			case 2:
				Pos[1] = Pos[1] + 1;
				Pos[0] = Pos[0] + 1;
				break;
			case 3:
				Pos[0] = Pos[0] + 1;
				break;
			case 4:
				Pos[0] = Pos[0] - 1;
				break;
			case 5:
				Pos[1] = Pos[1] - 1;
				break;
			case 6:
				Pos[1] = Pos[1] - 1;
				Pos[0] = Pos[0] + 1;
				break;
			case 7:
				Pos[1] = Pos[1] - 1;
				Pos[0] = Pos[0] - 1;
				break;
			case 8:
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
