package solitaire;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) 
	throws IOException {
		
		
		Solitaire ss = new Solitaire();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter deck file name => ");
		
		Scanner sc = new Scanner(new File(br.readLine()));
		
		ss.makeDeck(sc);
		for(int i=0;i<30;i++){
		System.out.println(ss.getKey());
		System.out.println();;
		}
		
		
		
		
	

	}

}
