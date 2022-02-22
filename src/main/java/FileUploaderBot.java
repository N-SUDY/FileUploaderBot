import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.Update;

public class FileUploaderBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {

        if (update.getMessage().hasDocument()){
            String fileName =update.getMessage().getDocument().getFileName();
            System.out.println(fileName);
        }
    }

    @Override
    public String getBotUsername() {
        return "Name_bot";
    }

    @Override
    public String getBotToken() {
        return "token_bot";
    }


}
