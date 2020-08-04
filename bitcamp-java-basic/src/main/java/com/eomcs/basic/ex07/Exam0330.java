// 메서드 : call by reference II

package com.eomcs.basic.ex07;

public class Exam0330 {

  // main()에서 만든 int a와 int b의 값을 바꾸고 싶다면,
  // primitive data type 값을 직접 넘기지 말고
  // 객체에 담아 넘겨라!

  // 배열을 만들지 않고 클래스를 만든 이유?
  //  => 여러 종류의 데이터 타입을 담을 수 있다.
  static class MyObject {
    int a;
    int b;
  }

  static void swap(MyObject ref) { // ref는 참조변수!
    System.out.printf("swap(): a = %d, b = %d\n", ref.a, ref.b);
    int temp = ref.a;
    ref.a = ref.b;
    ref.b = temp;
    System.out.printf("swap(): a = %d, b = %d\n", ref.a, ref.b);
  }

  public static void main(String[] args) {
    // MyObject 설계도에 따라 int a 와int b 메모리를 만든다.
    // 그리고 그 메모리(인스턴스=객체)의 주소를 ref 변수에 저장한다.
    MyObject ref = new MyObject();
    ref.a = 100;
    ref.b = 200;

    // a, b 변수가 들어 있는 인스턴스(객체=메모리)의 주소를
    // swap()에 넘긴다. => 그래서 "call by reference"인 것이다.
    swap(ref);
    System.out.printf("main(): a = %d, b = %d\n", ref.a, ref.b);
  }

}
