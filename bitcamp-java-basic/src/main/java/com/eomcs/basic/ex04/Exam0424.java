// 부동소수점 변수 - 변수와 리터럴의 크기 II

package com.eomcs.basic.ex04;

public class Exam0424 {
  public static void main(String[] args) {

    float f;
    double d;

    // 주의!
    // - 잘못된 리터럴 값을 변수에 저장해봐야 소용없다!

    f = 99999.8888877777f;
    System.out.println(f);
    // 4바이트 크기를 넘어가는 부동소수점 리터럴은
    // 이미 잘린 값이기 때문에 제대로 저장될 수 없다.

    d = 99999.8888877777f;
    System.out.println(d);
    // 변수 크기가 넉넉하더라도
    // 이미 리터럴 값이 옳지 않기 때문에 제대로 저장될 수 없다.

    // 주의!
    // 정수의 경우 리터럴을 표현할 때
    // 값이 그 크기를 넘어가면 컴파일 오류가 발생하지만,
    // 부동소수점의 경우 리터럴이 메모리의 크기를 넘어갈 때
    // 컴파일 오류 대신 단지 값이 짤린다.

    // 변수의 크기에 맞춰 부동소수점의 리터럴을 지정하라.
    f = 99999.88f;
    System.out.println(f);

    d = 99999.8888877777;
    System.out.println(d);
  }
}