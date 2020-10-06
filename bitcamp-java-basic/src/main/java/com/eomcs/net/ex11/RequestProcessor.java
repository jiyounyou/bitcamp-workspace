package com.eomcs.net.ex11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class RequestProcessor extends Thread {
  Socket socket;

  public RequestProcessor(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try (Socket socket = this.socket;
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream())) {

      sendResponse(out, compute(in.readLine()));
    } catch (Exception e) {
      System.out.printf("클라이언트 요청 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }

  static String compute(String request) {

    try {
      String[] values = request.split(" ");

      int a = Integer.parseInt(values[0]);
      String op = values[1];
      int b = Integer.parseInt(values[2]);
      int result = 0;

      switch (op) {
        case "+": result = a + b; break;
        case "-": result = a - b; break;
        case "*": result = a * b; break;
        case "/": result = a / b; break;
        default:
          return String.format("%s 연산자를 지원하지 않습니다.", op);
      }
      return String.format("결과는 %d %s %d = %d", a, b, op, result);

    } catch (Exception e) {
      return String.format("계산 중 오류 발생! - %s", e.getMessage());
    }
  }

  static void sendResponse(PrintStream out, String message) {
    out.println(message);
    out.println();
    out.flush();
  }

}