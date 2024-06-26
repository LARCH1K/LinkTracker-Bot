package edu.java.bot.core.communication.dialog;

import edu.java.bot.core.communication.command.Command;
import edu.java.bot.core.communication.command.impl.CommandRemoveLink;
import edu.java.bot.core.communication.command.impl.CommandSaveLink;
import edu.java.bot.core.communication.command.impl.CommandSendMessage;
import edu.java.bot.core.communication.command.impl.CommandSetLinkName;
import edu.java.bot.core.communication.command.impl.CommandSetLinkValue;
import edu.java.bot.entity.Link;
import java.util.ArrayDeque;
import java.util.Queue;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BotDialogs {

    public Dialog newAddLinkDialog() {

        Queue<Command> events = new ArrayDeque<>();
        Link link = new Link();

        Command commandSetLinkName = new CommandSetLinkName(link);

        commandSetLinkName.setNextIfSuccess(
            new CommandSendMessage(
                "Now send the link.",
                true
            )
        );
        commandSetLinkName.setNextIfFailed(
            new CommandSendMessage(
                "Name isn't valid! :(",
                false
            )
        );

        events.add(commandSetLinkName);

        Command commandSetLinkValueAndSave = new CommandSetLinkValue(link);

        Command commandSetLinkValueSuccessMessage = new CommandSaveLink(link);

        commandSetLinkValueSuccessMessage.setNextIfSuccess(
            new CommandSendMessage(
                "Success!", true
            )
        );

        commandSetLinkValueAndSave.setNextIfSuccess(
            commandSetLinkValueSuccessMessage
        );
        commandSetLinkValueAndSave.setNextIfFailed(new CommandSendMessage(
            "Link isn't supported!", false
        ));

        events.add(commandSetLinkValueAndSave);

        return new Dialog(events);

    }

    public Dialog newRemoveLinkDialog() {

        Queue<Command> events = new ArrayDeque<>();

        Command command = new CommandRemoveLink();

        command.setNextIfSuccess(
            new CommandSendMessage(
                "Link successfully removed!", true
            )
        );
        command.setNextIfFailed(
            new CommandSendMessage(
                "Link isn't supported! :(", false
            )
        );

        events.add(command);

        return new Dialog(events);

    }
}
