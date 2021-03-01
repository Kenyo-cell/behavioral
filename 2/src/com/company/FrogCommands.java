package com.company;

import java.util.Stack;

public class FrogCommands {
    private static Stack<FrogCommand> commands = new Stack<>();
    private static Stack<FrogCommand> undoCommands = new Stack<>();

    public static FrogCommand jumpRight(Frog frog, int steps) {
        commands.push(new FrogCommand() {
            @Override
            public boolean execute() {
                return frog.jump(steps);
            }

            @Override
            public boolean undo() {
                return frog.jump(-steps);
            }
        });
        return commands.peek();
    }

    public static FrogCommand jumpLeft(Frog frog, int steps) {
        commands.push(jumpRight(frog, -steps));
        return commands.peek();
    }

    public static void undo() {
        if (commands.empty()) return;
        undoCommands.push(commands.pop());
        undoCommands.peek().undo();
    }

    public static void repeat() {
        if (commands.empty()) return;

        undoCommands.clear();
        commands.push(commands.peek());
        commands.peek().execute();
    }

    public static void redo() {
        if (undoCommands.empty()) return;

        commands.push(undoCommands.pop());
        commands.peek().execute();
    }
}
