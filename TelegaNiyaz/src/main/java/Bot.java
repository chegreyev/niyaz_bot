import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    class MessageController {

        Update update;
        SendMessage sendMessage;

        public MessageController(Update update){
            this.update = update;
            this.sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        }

        public void send(String text){

            this.sendMessage.setText(text);

            try{
                execute(sendMessage);
            } catch (TelegramApiException e ) {
                e.printStackTrace();
            }
        }

        public void startMessage(){
            send("Hello , this is the Telegram bot\nMy main function is to show current weather");
        }
    }

    public void onUpdateReceived(Update update) {
         MessageController msg = new MessageController(update);
         String var = update.getMessage().getText();

        if(var.equals(Commands.start.getTitle())){
            msg.startMessage();
        } else if (var.equals(Commands.help.getTitle())) {
            msg.send("Hello i am a bot");
        } else {
            msg.send("Hello world");
        }
    }

    public String getBotUsername() {
        return "@niyaz_project_bot";
    }

    public String getBotToken() {
        return "994171271:AAFEcdwItUsXrt3FpXdMdN0Ah9FRdwV_oWI";
    }
}
