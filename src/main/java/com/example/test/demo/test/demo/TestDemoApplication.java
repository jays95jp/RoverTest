package com.example.test.demo.test.demo;


import java.util.List;

public class TestDemoApplication {

	public static void main(String[] args) {
		List<String> lines = Util.getInputString();
		String[] maxPosition = lines.get(0).split(" ");
		if(maxPosition.length<2){
			System.out.println("Not valid Input for line first");
			return;
		}

		Rover rover= new Rover();
		for(int index=1;index<lines.size();index++){
			rover.calCalculateFinalPosition(Integer.parseInt(maxPosition[0]), Integer.parseInt(maxPosition[1]), lines.get(index), lines.get(index + 1));
			index++;
		}

	}

}
