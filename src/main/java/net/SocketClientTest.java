package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author lianghong
 * @date 04/10/2018
 */

public class SocketClientTest {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 2000)) {
            BufferedReader sin = new BufferedReader((new InputStreamReader(System.in)));
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String readLine;
            readLine = sin.readLine();
            while (!readLine.equals("bye")) {
                os.println(readLine);
                os.flush();
                System.out.println("Client:" + readLine);
                System.out.println("Server:" + is.readLine());
                readLine = sin.readLine();
            }
            os.close();
            is.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
