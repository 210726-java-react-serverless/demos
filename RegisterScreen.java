package src.main.java.com.revature.bookstore.screens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RegisterScreen extends Screen {

    public RegisterScreen() {
        super("RegisterScreen", "/welcome/register");
    }

    @Override
    public void render() {

        String menu = "\nWelcome to RevaBooks!\n" +
                "Register\n" +
                "> ";

        System.out.print(menu);



        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String userSelection = consoleReader.readLine();
            System.out.println("Enter First Name \n");
            String fn = userSelection;
            String pw = "";
            String ln = "";
            if(fn.length() > 4)
            {
                System.out.println("Enter Last Name \n");
                 ln = userSelection;
            }

            if(ln.length() > 4)
            {
                System.out.println("Enter Password \n");
                pw = userSelection;
            }

            if(PasswordValidation(pw))
                System.out.println(" registered ! \n");


            System.out.println(userSelection); // if an exception is thrown this will not be executed
        } catch (IOException ioe) {
            System.err.println("An IOException was thrown...");
        } finally {
            System.out.println("This will run regardless of whether or not an exception is thrown.");

            // TODO clean up this ugly garbage!
            try {
                consoleReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    public static boolean PasswordValidation(String inPut)
    {
        for(char o : inPut.toCharArray())
        {
            if(o == ' ' || o == '_')
                return false;
        }

        return true;
    }
}
