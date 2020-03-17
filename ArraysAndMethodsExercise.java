/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays.and.methods.exercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class ArraysAndMethodsExercise {
public static void num1(){
    //Number 1
    int h=-2147483648,h2=-2147483648,d=0,p=0;
    Scanner input = new Scanner(System.in);
    System.out.println("Number 1:");
    int x[],y[];
    System.out.print("How many values would you like the array to have? ");
    x = new int[input.nextInt()];
    for(int i = 0;i <= x.length - 1;i++){
        System.out.print("Enter the value: ");
        x[i]=input.nextInt();
    }
    for(int i = 0;i <= x.length - 1;i++){
        if(x[i]>h){
            h2 = h;
            h = x[i];
            p = i;
        }
        else if(x[i]>h2){
            h2 = x[i];
        }
    }
    d = h - h2;
    y = new int[x.length + 1];
    for(int i = 0,j = 0;i <= y.length - 1;i++){
        if(i==p){
            y[i] = h2;
            i++;
            y[i] = d;
            j++;
        }
        else{
            y[i] = x[j];
            j++;
        }
    }
    System.out.println("The original array is " + Arrays.toString(x));
    System.out.println("The changed array is " + Arrays.toString(y));
    ArraysAndMethodsExercise.init();
}
public static void num2(){
    //Number 2
    Scanner input = new Scanner(System.in);
    System.out.println("Number 2:");
    int x[],y[],z;
    System.out.print("How many values would you like the array to have? ");
    x = new int[input.nextInt()];
    y = new int[x.length];
    for(int i = 0;i <= x.length - 1;i++){
        System.out.print("Enter the value: "); 
        x[i]=input.nextInt();
    }
    System.out.print("How much to the right would you like to shift the array? ");
    z=input.nextInt();
    for(int i = 0;i <= x.length - 1;i++){ //Revamped my old code to allow customization, kinda proud of this lol. Idk why.
        if(z<=x.length-1){
            y[z] = x[i];
            z++;
        }
        else{
            z=0;
            y[z] = x[i];
            z++;
        }
    }
    x = y;
    System.out.println(Arrays.toString(x));
    ArraysAndMethodsExercise.init();
}
public static void num3(){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the no. of rows : ");
    int rows = input.nextInt();
    System.out.println("Enter the no. of columns : ");
    int cols = input.nextInt();
    int matrix[][] = new int[rows][cols];
    System.out.println("Enter the elements :");
    for (int i = 0; i < rows; i++){
        for (int j = 0; j < cols; j++){
            matrix[i][j] = input.nextInt();
        }
    }
    System.out.println("Printing the input matrix :");
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
	//Checking the input matrix for symmetric
	if(rows != cols){
            System.out.println("The given matrix is not a square matrix, so it can't be symmetric.");
	}
        else{
            boolean symmetric = true;
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < cols; j++){
                    if(matrix[i][j] != matrix[j][i]){
			symmetric = false;
			break;
                    }
		}
            }
            if(symmetric){
		System.out.println("The given matrix is symmetric...");
            }
            else{
		System.out.println("The given matrix is not symmetric...");
            }
	}
    ArraysAndMethodsExercise.init();
}
public static void num4(){
    //I hope not separating the creation and printing into methods are fine? I could do it but eh...
    Scanner input = new Scanner(System.in);
    System.out.print("Input the size of the magic square: ");
    int n = input.nextInt();
    int[][] magicSquare = new int[n][n]; 
    int i = n/2; 
    int j = n-1;
    //creating the magic square
    for (int num=1; num <= n*n;){ 
        if (i==-1 && j==n){ 
            j = n-2; 
            i = 0; 
        } 
        else{ 
            if (j == n){ 
                j = 0;
            }    
            if (i < 0){ 
                i=n-1;
            }    
        }
        if (magicSquare[i][j] != 0){ 
            j -= 2; 
            i++; 
            continue; 
        } 
        else{
            magicSquare[i][j] = num++;
        }
        j++;  i--;  
        }
    // printing the magic square 
    System.out.println("The Magic Square for "+n+":"); 
    for(i=0; i<n; i++) { 
        for(j=0; j<n; j++){ 
            System.out.print(magicSquare[i][j]+" ");
        }
    System.out.println(); 
    }
    ArraysAndMethodsExercise.init();    
}
    public static void init(){
    Scanner input = new Scanner(System.in);
    System.out.print("Which number would you like to test? ");
    int in = input.nextInt();
    if(in==1){
        ArraysAndMethodsExercise.num1();
    }
    else if(in==2){
        ArraysAndMethodsExercise.num2();
    }
    else if(in==3){
        ArraysAndMethodsExercise.num3();
    }
    else if(in==4){
        ArraysAndMethodsExercise.num4();
    }
    else{
        System.out.println("Please only input the valid values. (1-4)");
        ArraysAndMethodsExercise.init();
    }
}
    public static void main(String[] args) {
        // TODO code application logic here
        ArraysAndMethodsExercise AME = new ArraysAndMethodsExercise();
        AME.init();
    }
    
}
