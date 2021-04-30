package de.nebalus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PrimeNumbers {

	private static boolean isRunning;
	
	
	public static void main(String[] args) {	
		start();
	}
	
	public static void start() {	
		String line = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			while((line = reader.readLine()) != null &&!isRunning) {
				try {
					Long amount = Long.parseLong(line)+1l;	
					Long amountofprimenumbers = 0l;
					int prozent = 0;
					final Long time = System.currentTimeMillis();
					isRunning = true;
					System.out.println("Program has now been started");
					for (Long i= 1l; i < amount; ++i) {
	
							boolean isPrimeNumber = true;
							for(Long i1= 2l; i1 < i; ++i1) {
								if(isPrimeNumber && i % i1 == 0 && i != i1) isPrimeNumber = false;
							}
							if(isPrimeNumber) {
								amountofprimenumbers++;
								System.out.println(i);
							}
							int newProzent = (int) (i*100/amount);
							if(newProzent != prozent) {
								prozent = newProzent;
								//System.out.println(prozent+"%");
								
							
						}
					}			
					isRunning = false;
					System.out.println("Program ended! ("+((System.currentTimeMillis()-time)/1000)+"s)");
					System.out.println("There are "+amountofprimenumbers+" primenumbers from "+(amount-1));
				}catch(NumberFormatException e) {
					System.out.println("Please use only a number!");
				}
			}
		}catch(IOException e) {}	
	}
}
