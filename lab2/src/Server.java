import java.net.*;
import java.io.*;
import java.util.Scanner;


public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4999);
        Socket s =ss.accept();

        System.out.println("Client connected");

        while(true){
            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);

            String str = bf.readLine();
            System.out.println("Client: "+ str);

            PrintWriter pr = new PrintWriter(s.getOutputStream());
            Scanner inp = new Scanner(System.in);
            pr.println("You: ");
            String message = inp.nextLine();
            pr.flush();

        }
    }
}

