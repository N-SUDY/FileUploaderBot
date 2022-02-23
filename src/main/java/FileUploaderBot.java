import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class FileUploaderBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {

        if (update.getMessage().hasDocument()){
            String fileName =update.getMessage().getDocument().getFileName();
            System.out.println(fileName);

            String fileId=update.getMessage().getDocument().getFileId();
            SendDocument sendDocument = new SendDocument();
            sendDocument.setChatId(update.getMessage().getChatId().toString());
            sendDocument.setDocument(new InputFile(fileId));
            sendDocument.setCaption("upload to server...");

            try {
                execute(sendDocument);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

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
