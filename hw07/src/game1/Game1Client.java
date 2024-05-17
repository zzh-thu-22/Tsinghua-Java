package game1;

import javax.management.AttributeList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Game1Client {
    public String Host;
    public int Port;

    public Game1Client(String host, int port) {
        Host = host;
        Port = port;
    }

    public int run() {
        try (Socket socket = new Socket(Host, Port);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            writer.write("hello\n");
            writer.flush();

            int lowerBound = Integer.parseInt(reader.readLine());
            int upperBound = Integer.parseInt(reader.readLine());
            int limit = Integer.parseInt(reader.readLine());

            int guess;
            String response;

            while (true) {
                guess = (upperBound + lowerBound) / 2;
                writer.write(guess + "\n");
                writer.flush();

                response = reader.readLine();
                if ("<".equals(response)) {
                    lowerBound = guess + 1;
                } else if (">".equals(response)) {
                    upperBound = guess - 1;
                } else if ("Correct!".equals(response)) {
                    reader.readLine();
                    break;
                }
            }
            return guess;
        } catch (IOException e) {

        }
        return 0;
    }
}