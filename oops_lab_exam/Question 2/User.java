import java.util.Scanner;

final class User
{
    public User(String str)
    {
        this.name = str;
    }

    public String name;
    public SocialMediaPlatform platform;

    public void createAccount()
    {
        System.out.println("Which Platform do you want?");

        Scanner sc = new Scanner(System.in);
        String input  = sc.nextLine();
        sc.close();

        SocialMediaPlatform platform = new SocialMediaPlatform(input);
        
        this.platform = platform;
    }

    public void askInput(int menu)
    {
        switch (menu) {
            case 1:
                platform.post();
                break;
            
            case 2: 
                platform.comment();
                break;
            
            case 3:
                System.out.println("Exiting...");
                break;
        }
    }

    public static void main(String[] args) {

        User user = new User("Yuvraj");
        user.createAccount();

        user.askInput(1);
        user.askInput(1);
        user.askInput(2);
        user.askInput(1);
        user.askInput(1);
        user.askInput(2);
        user.askInput(2);
        user.askInput(2);
        user.askInput(2);
        user.askInput(1);
        user.askInput(2);
        user.askInput(2);
        user.askInput(3);

        System.out.println(user.platform.getComment());
    }

}

class SocialMediaPlatform
{

    public SocialMediaPlatform(String str)
    {
        name = str;
        System.out.println("Your account has been created on platform : " + str);
    }

    public static String name;
    static int countComment = 0;

    public void comment()
    {
        System.out.println("comment added");
        countComment++;
    }

    public int getComment()
    {
        return countComment;
    }

    public void post()
    {
        FinalImagePost post_media = new FinalImagePost();
        post_media.post();
    }
}

abstract class ImagePost
{
   public abstract void post();
}

final class FinalImagePost extends ImagePost
{
    public void post()
    {
        System.out.println("Your Media has been Posted!");
    }
}

