package com.CibilCalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

@SpringBootApplication
public class CibilCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CibilCalculatorApplication.class, args);
//		System.out.println("hello world");

//				// Define the number of rows to generate
//				int numRows = 1000000;
//
//				// Define the output file
//				String fileName = "user_ids.csv";
//
//				// Create a Random object for generating random user_id values
//				Random random = new Random();
//
//				// Create a FileWriter for writing to the CSV file
//				try (FileWriter writer = new FileWriter(fileName)) {
//
//					// Write the header to the CSV file
//					writer.append("user_id\n");
//
//					// Write 1 million rows with random user_id between 1 and 1.5 million
//					for (int i = 0; i < numRows; i++) {
//						// Generate a random user_id between 1 and 1,500,000
//						int userId = random.nextInt(1500000) + 1;
//
//						// Write the user_id to the file
//						writer.append(String.valueOf(userId)).append("\n");
//					}
//
//					System.out.println("CSV file '" + fileName + "' has been generated with " + numRows + " rows.");
//
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}

		{
			System.out.println("hello world");
		}


	}}



