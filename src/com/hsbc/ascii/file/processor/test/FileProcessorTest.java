package com.hsbc.ascii.file.processor.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.hsbc.ascii.file.processor.FileProcessor;
import com.hsbc.ascii.file.processor.FileProcessorManager;

public class FileProcessorTest {

	@Test
	public void test_fileProcessor_main() {
		String[] args = { "E:\\Input.txt", "E:\\Output.txt" };
		FileProcessor.main(args);
	}
	
	@Test
	public void test_fileProcessor_main_blankFilePath() {
		String[] args = {  };
		FileProcessor.main(args);
	}

	@Test
	public void test_fileProcessor_correctFilePath() {
		FileProcessorManager fileProcessor = new FileProcessorManager();
		String response = fileProcessor.processFile("E:\\Input.txt", "E:\\Output.txt");
		assertEquals("Success", response);
	}

	@Test
	public void test_fileProcessor_incorrectFilePath() {
		FileProcessorManager fileProcessor = new FileProcessorManager();
		String response = fileProcessor.processFile("E:\\kkk.txt", "E:\\ooo.txt");
		assertEquals("Failed", response);
	}
	
	@Test
	public void test_fileProcessor_correctCSVFilePath() {
		FileProcessorManager fileProcessor = new FileProcessorManager();
		String response = fileProcessor.processFile("E:\\CSVInput01.csv", "E:\\Outputcsv.csv");
		assertEquals("Success", response);
	}

	@Test
	public void test_fileProcessor_incorrectCSVFilePath() {
		FileProcessorManager fileProcessor = new FileProcessorManager();
		String response = fileProcessor.processFile("E:\\kkk.csv", "E:\\ooo.csv");
		assertEquals("Failed", response);
	}
	
	@Test
	public void test_fileProcessor_fileContentReverse() {
		FileProcessorManager fileProcessor = new FileProcessorManager();
		String response = fileProcessor.reverseFileContent(new StringBuilder("ABC"));
		assertEquals("CBA", response);
	}
	
	@Test
	public void test_fileProcessor_notEquals_fileContentReverse() {
		FileProcessorManager fileProcessor = new FileProcessorManager();
		String response = fileProcessor.reverseFileContent(new StringBuilder("ABC"));
		assertNotSame("CBDA", response);
	}
	
	@Test
	public void test_fileProcessor_fileContentReverseNull() {
		FileProcessorManager fileProcessor = new FileProcessorManager();
		String response = fileProcessor.reverseFileContent(null);
		assertNull(response);
	}

}
