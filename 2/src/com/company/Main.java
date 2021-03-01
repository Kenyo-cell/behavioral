package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frog frog = new Frog();


        while (true) {
            String com = scanner.nextLine();
            if (com.equalsIgnoreCase("0")) break;

            FrogCommand current = null;
            switch (com) {
                case "<<":
                    FrogCommands.undo();
                    break;
                case "!!":
                    FrogCommands.repeat();
                    break;
                case ">>":
                    FrogCommands.redo();
                    break;
                default:
                    int steps = Integer.parseInt(com);
                    current = steps > 0 ?
                            FrogCommands.jumpRight(frog, steps) :
                            FrogCommands.jumpLeft(frog, -steps);
                    break;
            }
            if (current != null) current.execute();
        }

        System.out.println(frog);
    }
}
