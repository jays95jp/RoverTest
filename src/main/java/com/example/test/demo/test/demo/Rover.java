package com.example.test.demo.test.demo;

import java.util.stream.Stream;

public class Rover {

    public void calCalculateFinalPosition(int maxPositionXaxis, int maxPositionYaxis, String initialPosition, String roverMovement) {
        String roverDirection;
        String[] initInput = initialPosition.trim().replaceAll(" ", "").split("");
        if (initInput.length < 3) {
            return;
        }
        String[] strArrayRoverMovement = roverMovement.split("");
        roverDirection = initInput[initInput.length - 1];

        var ref = new Object() {
            String currentHeadDirection = String.valueOf(roverDirection);
            int currentX = Integer.parseInt(initInput[0]);
            int currentY = Integer.parseInt(initInput[1]);
        };

        Stream.of(strArrayRoverMovement).forEach(it -> {

            if (it.equalsIgnoreCase("M")) {
                switch (ref.currentHeadDirection) {
                    case "E" -> {
                        if (ref.currentX < maxPositionXaxis) {
                            ref.currentX++;
                        }
                    }
                    case "W" -> {
                        if (ref.currentX > 0) {
                            ref.currentX--;
                        }
                    }
                    case "N" -> {
                        if (ref.currentY < maxPositionYaxis) ref.currentY++;
                    }
                    case "S" -> {
                        if (ref.currentY > 0) {
                            ref.currentY--;
                        }
                    }
                }

            } else if (it.equalsIgnoreCase("L")) {
                switch (ref.currentHeadDirection) {
                    case "E" -> ref.currentHeadDirection = "N";
                    case "W" -> ref.currentHeadDirection = "S";
                    case "N" -> ref.currentHeadDirection = "W";
                    case "S" -> ref.currentHeadDirection = "E";
                }

            } else if (it.equalsIgnoreCase("R")) {
                switch (ref.currentHeadDirection) {
                    case "E" -> ref.currentHeadDirection = "S";
                    case "W" -> ref.currentHeadDirection = "N";
                    case "N" -> ref.currentHeadDirection = "E";
                    case "S" -> ref.currentHeadDirection = "W";
                }
            }

        });

        System.out.println(ref.currentX + " " + ref.currentY + " "+ref.currentHeadDirection);
    }

}
