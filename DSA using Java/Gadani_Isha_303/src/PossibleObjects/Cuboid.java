package PossibleObjects;

import Factory.Shape;

public class Cuboid implements Shape {
	
	private double length;
	private double width;
	private double height;
	
	public double getLength() {
		return length;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}

	
	public double calculateVolume() {
		double volume = length*width*height;
		return volume;
	}
	
	
}
