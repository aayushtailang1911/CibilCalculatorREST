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
		System.out.println("hello world");
	}

}

