// 배열 - 배열을 선언하는 방법

package com.eomcs.basic.ex04;

public class Exam0510 {
  public static void main(String[] args) {

    // 배열?
    //  - 같은 종류의 메모리를 쉽게 만드는 방법

    //  - 문법
    //      메모리종류[] 메모리이름 = new 메모리종류[개];
    //      데이터타입[] 변수명 = new 데이터타입[개수];
    //      ex) int[] arr = new int[5];

    //  - C언어 스타일
    //      데이터타입 변수명[] = new 데이터타입[개수];
    //      ex) int arr[] = new int[5];

    // 배열 사용 전
    int i1, i2, i3, i4, i5;

    //배열 선언
    int[] arr1 = new int[5];
    int arr2[] = new int[5]; // C-style

    int[] p = new int[3]; // c 언어 => int* p = (int*)malloc(sizeof(int) * 3);
    // p
    //  - int 배열의 주소를 담는 변수이다.
    //  - 자바에서는 주소를 담는 변수를 '레퍼런스'라 부른다.

    // new int[3]
    //  - int 변수를 연속해서 3개 확보한다.
    //  - 메모리를 확보한 후 리턴 값은 그 메모리의 시작 주소이다.

    // 배열의 개수 알아내기
    System.out.println(p.length);

    // 배열의 주소가 없는 상태에서 사용하지 말라!
    int[] x;
    // x = null // 주소 없음
    // System.out.print(x.length); // 변수에 값을 넣지 않고 사용할 수는 없다.

    // 배열에 값 저장
    p[0] = 100;
    p[1] = 200;
    p[2] = 300;

    System.out.printf("%d, %d, %d\n", p[0], p[1], p[2]);

    int sum = 0;
    for (int i = 0; i < p.length; i++) {
      sum = sum + p[i];
    }
    System.out.println(sum);

    // 배열 레퍼런스를 선언하는 방법
    int[] p2; // 자바에서 주로 사용하는 방식
    int p3[]; // C언어 방식도 사용 가능
              // 단, 개수를 지정해서는 안된다.

    //P2 = 100;
    p2 = p; // p 레퍼런스에 저장된 주소를 p2 레퍼런스에 복사한다.

    p2[1] = 1000;
    System.out.println(p[1]);

    p = new int[4];
    p[1] = 2000;
    System.out.printf("%d, %d\n", p[1], p2[1]);

    // System.out.println(p3[1]); // p3에는 값을 저장한 적은 없다 -> 컴파일 오류!

    // 자바는 primitive type을 제외한 모든 변수는 레퍼런스이다.
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    boolean bool;
    char c;

    // 레퍼런스 변수의 주소 값을 0으로 초기화하기
    // p2 = 0; // 이렇게 직접적으로 초기화시킬 수 없다.
    p2 = null; // 주소 변수(레퍼런스)를 0으로 초기화시키려면 null을 사용하라.

    // System.out.println(p2[0]); // NullPointerException => runtime exception

    int k1;
    // System.out.println(k1); // 변수를 초기화시키지 않고 사용하면 컴파일 오류

    int[] k2 = new int[3];
    // new 명령으로 메모리를 준비할 때,
    //  - 모든 메모리는 0으로 자동 초기화된다.
    //  - 따라서 따로 초기화할 필요없이 바로 사용할 수 있다.
    System.out.println(k2[0]);
    System.out.println(k2[1]);
    System.out.println(k2[2]);

    // 배열 생성 후 즉시 초기화하기
    int[] k3 = new int[] {100, 200, 300};
    //  => {} 안에 값을 넣을 수 있는 int 배열을 든 후 그 배열에 값을 넣는다.
    //  => 배열의 개수를 지정해서는 안된다.

    int[] k4;
    k4 = new int[] {10, 20};

    int[] k5 = {11,12,13}; // ==> new int[] {11, 12, 13}
    // 변수 선언과 동시에 초기화할 경우만 'new int[]'를 생략할 수 있다.

    int[] k6;
    // k6 = {111, 222, 333}; //  컴파일 오류! 변수 선언 없이는 생략할 수 없다.

    int[] x1 = new int[3];
    int[] x2 = new int[4];
    int[] x3 = x1; // reference count: JVM이 어떤 레퍼런스가 어떤 인스턴스를 가리키는지 확인하는 것
    x2 = x1; //  x1, x2, x3가 모두 한 인스턴스를 가리키고 있다.
             // x2가 가리켰던 int[4] 배열 메모리의 주소를 잃어버려 더이상 사용할 수 없다.
             // 이렇게 주소를 잃어버려 사용할 수 없는 메모리를 garbage라 한다.
             // garbage는 JVM이 자동으로 해제시킨다. (garbage collector)
             // 단, 바로 해제시키는 것이 아니라 다음에 해당할 때 해제시킨다.
             //  (garbage collector 활성화)
             //  1) 메모리가 부족할 때
             //  2) 시스템(CPU)이 한참동안 한가할 때
             //      => 결론! 언제 가비지를 메모리에서 해제시킬지 알 수 없다.

    System.gc(); // 가능하다면 빠른 시일 내에 가비지를 수집해줄 것을 요구!
    // 주의
    //  => gc()를 호출한다고 해서 바로 동작하는 것은 아니다.
    //  => 가비지 컬렉터의 실행을 앞당겨 달라고 요청하는 것이다.
    //  => 따라서 gc()를 호출하면 가비지 컬렉터가 바로 실행된다고 믿지 말라!
  }
}