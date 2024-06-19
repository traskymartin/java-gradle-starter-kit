package com.example.geektrust;

import java.util.List;

import com.example.geektrust.Impl.FileProcessingUtility;
import com.example.geektrust.entities.InputCommands;
import com.example.geektrust.exceptions.ProcessingException;
import com.example.geektrust.service.CardExecutionService;
import com.example.geektrust.service.CardExecutionServiceImpl;

public class Main {
  public static void main(String[] args) {
		try {
			if (args.length != 1) {
				throw new ProcessingException("Input file not supplied. Please provide the input file");
			}
			String filePath =  "sample_input/MetroCard_Input1";//args[0];
			processMetroCard(filePath);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static String processMetroCard(String filePath) {
		FileProcessingUtility reader = new FileProcessingUtility(filePath);
		List<InputCommands> commands = reader.getCommandsFromFile();
		CardExecutionService cardService=new CardExecutionServiceImpl();
		String output=cardService.executeCommands(commands);
		return output;
	}
}