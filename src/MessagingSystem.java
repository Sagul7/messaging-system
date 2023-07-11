import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface MessagingService
{
    void sendMessage();
}
class SMSMessagingService implements MessagingService
{

    @Override
    public void sendMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Reciver");
        long number = sc.nextLong();
        System.out.println("Enter content");
        String content = sc.next();
        String patten = "^[6-9]\\d{9}$";
        Pattern regex = Pattern.compile(patten);
        Matcher match = regex.matcher(Long.toString(number));
        if(match.matches())
        {
            System.out.println("Send message to "+number);
            System.out.println("message "+content);
        }
        else
        {
            System.out.println("invalid number");
        }

    }
}

class EmailMessagingService implements MessagingService
{


    @Override
    public void sendMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ReciverMail");
        String email = sc.next();
        System.out.println("Enter Content ");
        String content = sc.next();
        String pattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern regex = Pattern.compile(pattern);
        Matcher match = regex.matcher(email);
        if(match.matches())
        {
            System.out.println("sent to " +email);
            System.out.println("message "+content);
        }
        else {
            System.out.println("Invaild Email");
        }


    }
}

class WhatsAppMessagingService implements MessagingService
{

    @Override
    public void sendMessage() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Already existing user enter 1 for yes or enter 0 no");
        int existing=sc.nextInt();
        System.out.println("Enter number of Reciver");
        long number = sc.nextLong();
        System.out.println("Enter content");
        String content = sc.next();
        String patten = "^[6-9]\\d{9}$";
        Pattern regex = Pattern.compile(patten);
        Matcher match = regex.matcher(Long.toString(number));
        if(match.matches() && existing!=0)
        {
            System.out.println("Send message to "+number);
            System.out.println("message "+content);
        }
        else
        {
            System.out.println("invalid number");
        }

    }
}
public class MessagingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MessagingService sms = new SMSMessagingService();
        MessagingService email = new EmailMessagingService();
        MessagingService wp = new WhatsAppMessagingService();
        do {
            System.out.println("Enter 1 to use SMS or Enter 2 to use Email or Enter 3 to use Whatapp");
            int option=sc.nextInt();
            if(option>4)
                break;
            if(option == 1)
            {
                sms.sendMessage();
            }
            if(option == 2)
            {
                email.sendMessage();
            }
            if(option == 3)
            {
                wp.sendMessage();
            }

        }while(true);

    }
}
