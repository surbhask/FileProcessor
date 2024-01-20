package com.hsbc.ascii.file.processor;

public class FileProcessor {

	public static void main(String[] args) {

		FileProcessorManager fileProcessorManager = new FileProcessorManager();

		if (args != null && args.length == 2) {
			fileProcessorManager.processFile(args[0], args[1]);
		} else {
			System.out.println("Please provide user input!!!");
		}

	}
}