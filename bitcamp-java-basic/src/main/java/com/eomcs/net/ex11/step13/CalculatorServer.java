// 계산기 서버 만들기 - 13단계: HTTP 프로토콜 기반 애플리케이션 실행
//  - 웹브라우저로부터 요청을 받아 응답한다.
//  - 요청 및 응답 프로토콜은 웹 기반 프로토콜인 HTTP를 사용한다.

package com.eomcs.net.ex11.step13;

import java.net.ServerSocket;

public class CalculatorServer {
  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행중...");

      while (true) {
        RequestProcessor thread = new RequestProcessor(serverSocket.accept());
        thread.start();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}

