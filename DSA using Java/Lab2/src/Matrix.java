/**

 * 
 * Practice for Multidimensional Arrays

 * Student Name: Isha Gadani

 * Student Number: 041085940

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 2

 * Lab Professor: Daniel Cormier

 *

  */

import java.util.Arrays;

 
//Representation of matrix with rows, columns and elements 
 
public class Matrix {
    private double[][] array;
    private int rows;
    private int columns;

    
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.array = new double[rows][columns];
    }

    public Matrix(double[][] array) {
        this.rows = array.length;
        this.columns = array[0].length;
        this.array = array;
    }
//writing a method for addition of the matrix
    public Matrix add(Matrix matrix) {
    	//Exception has been raised to see if the rows and columns have the same dimensions
        if (rows != matrix.rows || columns != matrix.columns) {
            throw new IllegalArgumentException("Matrices must have the same dimensions.");
        }
        //use of for loop to execute the addition of matrices
        double[][] result = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = array[i][j] + matrix.array[i][j];
            }
        }

        return new Matrix(result);
    }
//writing a method for subtraction of the matrix    
    public Matrix sub(Matrix matrix) {
    	//Exception has been raised to check the dimensions of rows and columns 
        if (rows != matrix.rows || columns != matrix.columns) {
            throw new IllegalArgumentException("Matrices must have the same dimensions.");
        }
        //use of for loop to execute the subtraction of the matrices	
        double[][] result = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = array[i][j] - matrix.array[i][j];
            }
        }

        return new Matrix(result);
    }

    public Matrix subMatrix(Matrix matrix) {
        if (rows != matrix.rows || columns != matrix.columns) {
            throw new IllegalArgumentException("Matrices must have the same dimensions.");
        }

        double[][] result = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = array[i][j] - matrix.array[i][j];
            }
        }

        return new Matrix(result);
    }

//writing a method to multiply the matrices   
    public Matrix mult(Matrix matrix) {
        if (rows != matrix.rows || columns != matrix.columns) {
            throw new IllegalArgumentException("Matrices must have the same dimensions.");
        }

        double[][] result = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = array[i][j] * matrix.array[i][j];
            }
        }

        return new Matrix(result);
    }
//method is used for calculating the sum of the elements
    public double sum() {
        double sum = 0.0;
        for (int i = 0; i < rows ; i=i+1) {
        	for (int j = 0; j < columns; j++) {
        		sum = sum + array[i][j];
        	
        	}
        }
      return sum;  
    }
    
//creating a method that will create sub matrices with given positions 
	public Matrix subMatrix(int a, int b, int c, int d) {
		double[][] result = new double[c][d];
		for(int i=a ; i<a+c; i++ ) {
			for(int j=b; j<b+d;j++) {
				result[i-a][j-b]= this.array[i][j];
			}
		}
			return new Matrix(result);
		}
		
	public String toString() {
		StringBuffer reuslt = new StringBuffer();
		for(double[] row : array) {
			reuslt.append(Arrays.toString(row));
			reuslt.append('\n');
		}
		return reuslt.toString();
	}
}    