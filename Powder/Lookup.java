/*
 * Written by Jamel Chouarfia
 */

import java.awt.Color;
import java.util.Random;

public class Lookup {
	public static double TempOf(String Name) {
		switch(Name) {
			case "Nothing":
				return Nothing.getTemp();
			case "Wall":
				return Wall.getTemp();
			case "Ice":
				return Ice.getTemp();
			case "Water":
				return Water.getTemp();	
			case "Steam":
				return Steam.getTemp();
			case "Fire":
				return Fire.getTemp();
			default:
				return 20;
		}
	}
	
	public static double ThermalConductivityOf(String Name) {
		switch(Name) {
			case "Nothing":
				return Nothing.getThermalConductivity();
			case "Wall":
				return Wall.getThermalConductivity();
			case "Ice":
				return Ice.getThermalConductivity();
			case "Water":
				return Water.getThermalConductivity();
			case "Steam":
				return Steam.getThermalConductivity();
			case "Fire":
				return Fire.getThermalConductivity();
			default:
				return 20;
		}
	}
	
	public static Color ColorOf(String Name) {
		switch(Name) {
			case "Nothing":
				return Nothing.getColor();
			case "Wall":
				return Wall.getColor();
			case "Ice":
				return Ice.getColor();
			case "Water":
				return Water.getColor();
			case "Steam":
				return Steam.getColor();
			case "Fire":
				return Fire.getColor();
			default:
				return new Color(0, 0, 0);
		}
	}
	
	public static Color ColorOf(char Symbol) {
		switch(Symbol) {
			case 'N':
				return Nothing.getColor();
			case 'W':
				return Wall.getColor();
			case 'I':
				return Ice.getColor();
			case 'w':
				return Water.getColor();
			case 'S':
				return Steam.getColor();
			case 'F':
				return Fire.getColor();
			default:
				return new Color(0, 0, 0);
		}
	}
	
	public static char SymbolOf(String Name) {
		switch(Name) {
			case "Nothing":
				return Nothing.getSymbol();
			case "Wall":
				return Wall.getSymbol();
			case "Ice":
				return Ice.getSymbol();
			case "Water":
				return Water.getSymbol();
			case "Steam":
				return Steam.getSymbol();
			case "Fire":
				return Fire.getSymbol();
			default:
				return 'N';
		}
	}
	
	public static int[] Move(String Name, int[] Pos, Random random) {
		switch(Name) {
			case "Nothing":
				return Nothing.move(Pos, random);
			case "Wall":
				return Wall.move(Pos, random);
			case "Ice":
				return Ice.move(Pos, random);
			case "Water":
				return Water.move(Pos, random);
			case "Steam":
				return Steam.move(Pos, random);
			case "Fire":
				return Fire.move(Pos, random);
			default:
				return Pos;
		}
	}
}
