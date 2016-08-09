package main;
import node.Node;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import output_processor.OutputProcessor;

import input_processor.InputProcessor;

public class Main {
	
	
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException{
		
		ArrayList<Node> list= new ArrayList<Node> ();
		ArrayList<Boolean> available; 
		HashMap<String, Integer> map= new HashMap<>();	
		/*Recieving command line arguments
		int numProc=args[1]; 
		String fileName=args[0];
		*/
		int numProc=2;
		String fileName="largeinput.dot";
		InputProcessor ip=new InputProcessor(fileName);
		ip.processInput();
		list=ip.getGraph();
		map=ip.getMap();
		available=ip.getNextAvailableNodes();
		
		for(Node n : list){
			System.out.println(n.getName()+ " weight: " +n.getWeight());
		}
		for(String name: map.keySet()){
			int index=map.get(name);
			boolean isAvailable = available.get(index);
			System.out.println(name +" index: " + index + " isAvailable: " + isAvailable);
		}

		
		OutputProcessor op = new OutputProcessor(fileName, list);
		op.processOutput();
	}
	
	
	
}
