package robot.sim;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void processCommands(String filename) {
        RobotSimulation robot = new RobotSimulation(5, 5);
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] command = line.trim().split("\\s+");
                switch (command[0]) {
                    case "PLACE":
                        String[] params = command[1].split(",");
                        int x = Integer.parseInt(params[0]);
                        int y = Integer.parseInt(params[1]);
                        robot.place(x, y, params[2]);
                        break;
                    case "MOVE":
                        robot.move();
                        break;
                    case "LEFT":
                        robot.left();
                        break;
                    case "RIGHT":
                        robot.right();
                        break;
                    case "REPORT":
                        System.out.println(robot.report());
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        processCommands("inputFile.txt");
    }
}

