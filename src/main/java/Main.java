import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder inviteCode = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < 8; i++) {
            int index = rnd.nextInt(characters.length());
            inviteCode.append(characters.charAt(index));
        }

        System.out.println("Generated Invite Code: " + inviteCode.toString());
    }
}