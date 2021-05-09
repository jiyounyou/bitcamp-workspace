// 클래스 정보 추출 - 클래스의 중첩 클래스 정보 알아내기 II
package com.eomcs.reflect.ex02;

public class Exam04 {
  static class A {
    static class B {
    } // static nested class
    class C {
    } // non-static nested class == inner class

    public void m() {
      class D {
      } // local class
    }

    public void m2() {
      Object obj = new Object() {}; // anonymous class
    }

    public static class E {
    }
    public class F {
    }
    private class G {
    }
    protected class H {
    }
  }

  public static void main(String[] args) throws Exception {
    Class<?> clazz = Class.forName("com.eomcs.reflect.ex02.Exam04$A");

    // 접근 범위에 상관 없이 모든 중첩 클래스 및 인터페이스 정보를 가져온다.
    // => 메서드 안에 정의된 로컬 클래스는 대상이 아니다.
    Class<?>[] nestedList = clazz.getDeclaredClasses();
    for (Class<?> nested : nestedList) {
      System.out.println(nested.getName());
    }


    // 출력 결과
//    com.eomcs.reflect.ex02.Exam04$A$B
//    com.eomcs.reflect.ex02.Exam04$A$C
//    com.eomcs.reflect.ex02.Exam04$A$E
//    com.eomcs.reflect.ex02.Exam04$A$F
//    com.eomcs.reflect.ex02.Exam04$A$G
//    com.eomcs.reflect.ex02.Exam04$A$H

    //getDeclaredClasses
    //접근 범위에 상관 없이 모든 클래스에 접근 가능.

  }

}