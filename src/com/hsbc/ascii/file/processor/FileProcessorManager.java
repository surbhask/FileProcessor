package com.hsbc.ascii.file.processor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.hsbc.ascii.file.processor.constants.FileProcessorConstants;
import com.hsbc.ascii.file.processor.interfaces.FileProcessorInterface;

public class FileProcessorManager implements FileProcessorInterface {

	@Override
	public String processFile(String inputPath, String outputPath) {
		StringBuilder fileString = new StringBuilder();

		FileWriter fileWriter = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(inputPath));
			fileWriter = new FileWriter(outputPath);
			int ch;

			while ((ch = br.read()) != -1) {
				fileString.append(Character.toString((char) ch));
			}
			fileWriter.write(reverseFileContent(fileString));
			return FileProcessorConstants.STATUS_SUCCESS;
		} catch (FileNotFoundException e) {
			System.out.println("Exception occured while provided file is not found" + e.getMessage());
			return FileProcessorConstants.STATUS_FAILED;
		} catch (Exception e) {
			System.out.println("Exception occured while processing the file" + e.getMessage());
			return FileProcessorConstants.STATUS_FAILED;
		} finally {
			try {
				if (br != null && fileWriter != null) {
					br.close();

					fileWriter.close();
				}
			} catch (IOException e) {
				System.out.println("Exception occured while closing the input resource" + e.getMessage());
				return FileProcessorConstants.STATUS_FAILED;
			}
		}

	}

	public String reverseFileContent(StringBuilder fileString) {
		return fileString != null ? fileString.reverse().toString() : null;
	}

}
