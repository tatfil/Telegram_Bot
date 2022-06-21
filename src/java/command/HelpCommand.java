package src.java.command;

import src.java.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static src.java.command.CommandName.*;

public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public final static String HELP_MESSAGE = String.format("Привет. Я New Telegram Bot.\n " +
            "%s чтобы узнать о ближайших событиях\n" +
            "%s чтобы задать вопрос\n" +
            "%s для справки", EVENT.getCommandName(), QUESTION.getCommandName(), HELP.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId(), HELP_MESSAGE);
    }
}
