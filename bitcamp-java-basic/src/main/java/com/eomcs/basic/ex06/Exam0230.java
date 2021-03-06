// 흐름 제어문 - switch 문법 I

package com.eomcs.basic.ex06;

public class Exam0230 {
  public static void main(String[] args) {
    // switch (값) {}
    // 값으로 가능한 데이터 타입은?
    //   - int 정수(byte, short, int, char), 문자열, 특별한 상수 Enum 타입
    //   - case 값으로 변수를 사용할 수 없다. 리터럴만 가능하다.

    byte b = 2;
    switch (b) {
      case 1:
      case 2:
      default:
    }

    short s = 2;
    switch (s) {
      case 1:
      case 2:
      default:
    }

    int i = 2;
    switch (b) {
      case 1:
      case 2:
      default:
    }

    char c = 'A'; // A문자의 유니코드 값(UTF-16) 0x41(65)을 c에 저장한다.
    switch (c) {
      // case의 값도 int 값이면 무엇이든 된다.
      case 'A': // 0x41 = 65
      case 1:
      case 2:
      default:
    }

    // String 값을 switch와 case의 값으로 사용할 수 있다.
    String str = "hello";
    switch (str) {
      case "hello":
      case "ohora":
      case "hul":
      default:
    }

  }
}
