// 관련된 기능(메서드)을 묶어 분류하기 - 인스턴스 변수

package com.eomcs.oop.ex02;

public class Exam0250 {

  static class Calculator {
    // 인스턴스 변수
    //  - 작업 결과를 개별적으로 관리하고 싶을 때 인스턴스 변수로 선언한다.
    //  - 인스턴스 변수는 클래스가 로딩될 때 만들어지지 않는다.
    //  - new 명령을 사용해서 만들어야 한다.
    //  - 변수 선언 앞에 static이 붙지 않는다.
    int result = 0;

    static void plus(Calculator that, int value) {
      // 인스턴스 변수를 다루는 메서드는 작업을 수행할 때 그 인스턴스 주소를 받아야 한다.
      // result는 더이상 클래스 변수가 아니기 때문에 직접 접근할 수 없다.
      // 오직 인스턴스 주소를 통해서만 접근할 수 있다.
      // that은 Calculator의 레퍼런스!
      that.result += value;
    }

    static void minus(Calculator that, int value) {
      that.result -= value;
    }

    static void multiple(Calculator that, int value) {
      that.result *= value;
    }

    static void divide(Calculator that, int value) {
      that.result /= value;
    }

    static int abs(int a) {
      return a>=0 ? a : a * -1;
    }
  }

  public static void main(String[] args) {
    // 다음 두 개의 식을 분리하여 계산해 보자!
    //  - 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
    //  식1) 2 + 3 - 1 * 7 / 3 = ?
    //  식2) 3 * 2 + 7 / 4 - 5 = ?

    // 두 개의 식을 동시에 계산하고 싶은가?
    // 그럴려면 계산 결과를 개별적으로 관리할 수 있어야 한다.
    // 다음과 같이 각 식의 계산 결과를 보관할 메모리를 준비한다.
    Calculator c1 = new Calculator(); // 식1의 계산 결과를 보관할 메모리 준비
    Calculator c2 = new Calculator(); // 식2의 계산 결과를 보관할 메모리 준비

    // 계산을 수행할 때 계산 결과를 보관할 메모리를 전달한다.
    //  - 스태틱 메서드를 사용할 경우 인스턴스의 주소를 파라미터로 넘겨줘야 한다.
    Calculator.plus(c1, 2);
    Calculator.plus(c2, 3);

    Calculator.plus(c1, 3);
    Calculator.multiple(c2, 2);

    Calculator.minus(c1, 1);
    Calculator.plus(c2, 7);

    Calculator.multiple(c1, 7);
    Calculator.divide(c2, 4);

    Calculator.divide(c1, 3);
    Calculator.minus(c2, 5);

    // 식1의 계산 결과는 c1 인스턴스의 result 변수에 들어 있고,
    // 식2의 계산 결과는 c2 인스턴스의 result 변수에 들어 있다.
    System.out.printf("c1.result = %d\n", c1.result);
    System.out.printf("c2.result = %d\n", c2.result);
  }
}