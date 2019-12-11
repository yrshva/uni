import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("localhost", 4999);

        while(true){

            PrintWriter pr = new PrintWriter(s.getOutputStream());
            Scanner inp = new Scanner(System.in);
            pr.println("You: ");
            String message = inp.nextLine();
            pr.flush();

            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);

            String str = bf.readLine();
            System.out.println("Server: "+ str);
        }
    }
}
