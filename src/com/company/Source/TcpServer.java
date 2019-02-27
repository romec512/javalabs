package com.company.Source;
import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.net.*;
public class TcpServer {
    public static final int PORT = 2500;
    private static final int TIME_SEND_SLEEP = 100;
    private static final int COUNT_TO_SEND = 10;
    private ServerSocket servSocket;
    public TcpServer(){
        try{
            servSocket = new ServerSocket(PORT);
        }catch(IOException e){
            System.err.println("Не удаётся открыть сокет для сервера: " + e.toString());
        }
    }
    public void go(){
        class Listener implements Runnable{
            Socket socket;
            public Listener(Socket aSocket){
                socket = aSocket;
            }
            public void run(){
                try{
                    System.out.println("Слушатель запущен");
                    int count = 0;
                    InputStream in = socket.getInputStream();
                    InputStreamReader reader = new InputStreamReader(in);
                    StringBuffer strBuff = new StringBuffer();
                    char[] readed = new char[256];
                    while(true){
                        int countBuf = reader.read(readed, 0, 256);
                        if(countBuf == -1) break;
                        strBuff.append(readed, 0, countBuf);
                        Thread.yield();
                    }

                    int resultOfExpression = Summator.getResult(strBuff.toString());
                    OutputStream out = socket.getOutputStream();
                    OutputStreamWriter writer = new OutputStreamWriter(out);
                    PrintWriter pWriter = new PrintWriter(writer);
                    while(count < COUNT_TO_SEND){
                        count++;
                        pWriter.print(resultOfExpression);
                        System.out.println(resultOfExpression);
                        Thread.sleep(TIME_SEND_SLEEP);
                    }
                    pWriter.close();
                }catch(IOException e){
                    System.err.println("Исключение: " + e.toString());
                } catch (InterruptedException e) {
                    System.err.println("Исключение: " + e.toString());
                }
            }
        }
        System.out.println("Сервер запущен...");
        while(true){
            try{
                Socket socket = servSocket.accept();
                Listener listener = new Listener(socket);
                Thread thread = new Thread(listener);
                thread.start();
            }catch(IOException e){
                System.err.println("Исключение: " + e.toString());
            }
        }
    }
}
