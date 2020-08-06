// 클래스 변수와 인스턴스 변수 생성 시점과 메모리 영역

package com.eomcs.oop.ex03;

public class Exam0140 {
  static class A{
    static int v1; // 클래스 변수
    int v2; // 인스턴스 변수
  }

  public static void main(String[] args) {
    // 클래스 변수
    //  - 클래스가 로딩되는 시점에 Method Area에 생성된다.
    //  - 클래스가 로딩되는 순간 바로 사용할 수 있다.
    // 클래스가 로딩되는 경우
    //  - 로딩되지 않은 클래스를 사용할 때
    //  - 클래스 변수(스태틱 변수)를 사용하거나 클래스 메서드(스태틱 메서드)를 사용하려 할 때
    //  - 인스턴스를 생성할 때
    //  - 단 중복 로딩되지 않는다.
    A.v1 = 100;

    // 인스턴스 변수는 new로 인스턴스를 생성할 때마다 Heap에 생성된다.
    // v2는 인스턴스 변수이기 때문에 사용하기 전에 new 명령으로 먼저 생성해야 한다.
    // A.v2 = 200; // 컴파일 오류!

    A obj1 = new A();
    // 이제 v2 변수가 Heap에 생성되었다.
    // A클래스의 인스턴스를 만들 때
    // static이 안붙은 변수가 그 대상이다.

    // v2 인스턴스 변수는 인스턴스 주소를 통해 사용해야 한다.
    // 클래스 이름으로 사용할 수 없다.
    // A.v2 = 200; // 컴파일 오류!

    obj1.v2 = 200; // OK!

    // 인스턴스 변수는 인스턴스를 만들 때마다 생성된다.
    A obj2 = new A(); // 새 v2 변수가 생성된다.
    obj2.v2 = 300;

    System.out.println(A.v1);
    System.out.println(obj1.v1); // A.v1
    System.out.println(obj2.v1); // A.v1
    System.out.println(obj1.v2);
    System.out.println(obj2.v2);
  }
}
