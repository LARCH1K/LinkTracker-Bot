package edu.java.bot.core.communication.dialog;

import edu.java.bot.core.communication.command.Command;
import java.util.Queue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Dialog {

    private final Queue<Command> events;

    public boolean isEmpty() {
        return events.isEmpty();
    }

    public Command pop() {
        return events.poll();
    }

    public Command peek() {
        return events.peek();
    }

    public void push(Command command) {
        events.add(command);
    }
}
