package PossibleObjects;

import Factory.Shape;

public class Cylinder implements Shape {
	
	private double radius;
	private double height;
	
	public double getRadius() {
		return radius;
	}
	
	public double getHeight() {
		return height;
	}
	public double calculateVolume() {
		 double volume = Math.PI*(radius*radius)*height;
		 return volume;
		 
		
	}
	
}
