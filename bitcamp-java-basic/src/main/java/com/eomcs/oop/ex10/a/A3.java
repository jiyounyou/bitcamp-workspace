// 추상 클래스와 추상 메서드 I

package com.eomcs.oop.ex10.a;

// 추상 메서드는 구현하지 않은 메서드이기 때문에
// 일반 클래스(=구현 클래스; concrete class)는 추상 메서드를 가질 수 없다.
// 오직 추상 클래스만이 추상 메서드를 가질 수 있다.
//  왜? 일반 클래스는 인스턴스를 생성할 수 있다.
//     인스턴스로 메서드를 호출하기 때문에
//     일반 클래스가 완전히 만들지 않은 메서드를 가지고 있다면,
//     호출할 때 오류가 발생할 것이다.
//     원천적으로 이런 문제를 발생시키지 않기 위해
//     일반 클래스는 추상 메서드를 갖지 않게 하였다.
public class A3 { // 컴파일 오류!
  // 메서드 앞에 abstract를 붙인다.
  public abstract void m1();
}
