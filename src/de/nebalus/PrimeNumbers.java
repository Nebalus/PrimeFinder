package de.nebalus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PrimeNumbers {

	private static boolean isRunning;
	private static int primeCount;
	
	public static void main(String[] args) {	
		String line = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			while((line = reader.readLine()) != null &&!isRunning) {
				try {
					System.out.println(findPrimeNumbers(Integer.parseInt(line)));
					System.out.println(primeCount);
				}catch (NumberFormatException e) {
					System.out.println("Please use only a number!");
				}
			}
		}catch(IOException e) {}
	}
	
	private static List<Integer> findPrimeNumbers(int n){
		isRunning = true;
		primeCount = 0;
		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);
		for (int i = 2; i * i < n; i++) {
			if (primes[i]) {
				for (int j = i * i; j <= n; j += i)
					primes[j] = false;
			}
		}
		List<Integer> primeNumbers = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			if (primes[i])
				primeCount++;
				primeNumbers.add(i);
		}
		isRunning = false;
		return primeNumbers;
	}
	

}
