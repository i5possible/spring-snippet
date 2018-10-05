package net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lianghong
 * @date 04/10/2018
 */

public class SocketServerTest {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(2000)) {
            Socket socket = serverSocket.accept();
            String readLine;
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Client:" + is.readLine());
            readLine = sin.readLine();
            while (!readLine.equals("bye") ) {
                os.println(readLine);
                os.flush();
                System.out.println("Server:" + readLine);
                System.out.println("Client:" + is.readLine());
                readLine = sin.readLine();
            }
            os.close();
            is.close();
            sin.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test() {
        try (ServerSocket serverSocket = new ServerSocket(2000)) {
            Socket socket = null;
            socket = serverSocket.accept();

            PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
            DataInputStream di = new DataInputStream(socket.getInputStream());

            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
