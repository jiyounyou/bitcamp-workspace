// 변수의 종류

package com.eomcs.basic.ex04;

public class Exam0400 {
  public static void main(String[] args) {
    // 정수
    byte b; // 1바이트 크기의 메모리
    short s; // 2바이트 크기의 메모리
    int i; // 4바이트 크기의 메모리
    long l; // 8바이트 크기의 메모리

    // 부동소수점
    float f; // 4바이트 크기의 메모리
    double d; // 8바이트 크기의 메모리

    // 문자
    char c; // 2바이트 크기의 메모리

    // 논리
    boolean bool;

    // 레퍼런스
    String str; //자바 언어 명세서에는 메모리의 크기가 정의되어 있지 않다.
                // 메모리 주소를 저장할 만큼 큰 크기

    // 변수의 메모리 크기
    //  - 정수 리터럴은 기본이 4바이트이다.
    //  - 원래 작은 메모리에 저장할 수 없지만,
    //    오른쪽의 값이 4바이트 정수 리터럴일 경우
    //    메모리에 그 리터럴을 저장할 수 있다면 허락한다.
    b = -128;
    b = 127;

    // b = -129; 8비트를 초과했다. => 컴파일 오류!
    // b = 128;

    // 리터럴끼리의 연산 결과는 리터럴로 취급한다.
    b = 20 + 30;

    b = 120 + 7;
    // b = 120 + 8; 8비트를 초과했다. => 컴파일 오류!

    // 리터럴과 변수의 연산 결과는 리터럴로 취급하지 않는다.
    byte b2 = 20;
    // b = 100 + b2; // 컴파일 오류!

    s = -32768;
    s = 32767;
    // s = -32769;
    // s = 32768;

    i = -21_0000_0000;
    i = 21_0000_0000;
    // i = -22_0000_0000;
    // i = 22_0000_0000;

    l = -922_0000_0000_0000_0000L;
    l = 922_0000_0000_0000_0000L;
    // l = -932_0000_0000_0000_0000L;
    // l = 932_0000_0000_0000_0000L;

    b = 100;
    s = 100;
    i = 100;

    // b = 100L;
    // s = 100L;
    // i = 100L;

    byte b3;
    b3 = b;
    // b3 = s;
    // b3 = i;
    // b3 = l;

    short s2; // 2바이트 메모리
    s2 = b;
    s2 = s;
    // s2 = i;
    // s2 = l;

    int i2; // 4바이트 메모리
    i2 = b;
    i2 = s;
    i2 = i;
    // i2 = l;

    long l2; // 8바이트 메모리
    l2 = b;
    l2 = s;
    l2 = i;
    l2 = l;

    s = -32768;
    s = 32767;

    char c2; // 2바이트 메모리
    // c2 = -32768; // char는 음수를 담을 수 없다.
    c2 = 0;
    c2 = 65535;
    // c2 = 65536;

    // c2 = s;
    // s = c2;

    f = 999.9999f;
    f = 9.999999f;
    f = 999999.9f;

    // 부동소수점은 7자리까지의 숫자만 유효하다.
    // 그 이상의 자릿수인 경우 값이 잘린다.
    // 또는 반올림 처리 된다.
    // 주의!
    //  - 유효자릿수를 넘어간다고 오류가 발생하지는 않는다.
    f = 999.99993f;
    System.out.println(f); // 999.99994 출력

    float f1 = 1.234567f;
    float f2 = 92345.22f;
    float f3 = f1 + f2; // float과 float의 연산 결과는 float => 7자리가 넘어가면 값이 잘린다.
    System.out.println(f1);
    System.out.println(f2);
    System.out.println(f3); // 92346.45 출력

    // 두 부동소수을 연산한 결과가 7자리를 넘어갈 것 같으면
    // 처음부터 double을 사용하라.
    double d1 = 1.123456;
    double d2 = 92345.22;
    double d3 = d1 + d2;
    System.out.println("==>");
    System.out.println(d1);
    System.out.println(d2);
    System.out.println(d3); // 92346.343456 출력

    d = 99999999.99999999;
    System.out.println(d);

    // f = 2345678912.123456; double을 float에 저장할 수 없다.
    f = 2345678912.123456f;
    // 뒤에 f를 붙이면 8바이트 값을 4바이트로 만든다.
    // 4바이트를 넘어가는 값은 자른다.
    //  => 따라서 f에 들어가는 값은 이미 잘린 값이다.
    System.out.println(f);

    d = 234.5678;
    System.out.println(d);

    d = 234.5678f; // float을 double에 담았다.
    System.out.println(d); // 234.5677947998047 출력
    // 부동소수점은 계산방식이 복잡해서 float을 double에 담으면 값이 제대로 담기지 않는다.
    // 부동소수점 연산은 그래픽카드에서 주로 사용된다.
  }
}

// 메모리 크기에 따라 저장할 수 있는 값의 범위
//  1) primitive data type (원시 데이터 타입)
//    - 정수
//      byte   : 1byte 메모리 (-128 ~ 127)
//      short  : 2byte 메모리 (-32768 ~ 32767)
//      int    : 4byte 메모리 (약 -21억 ~ 21억)
//      long   : 8byte 메모리 (약 -922경 ~ 922경)
//    - 부동소수점
//      float  : 4byte 메모리 (유효자릿수 7자리)
//      double : 8byte 메모리 (유효자릿수 15자리)
//    - 문자
//      char   : 2byte 메모리 (0 ~ 65535). UCS-2 코드 값 저장.
//    - 논리값
//      boolean : JVM에서 4 바이트 int 메모리를 사용한다.
//              배열일 경우 1 바이트 byte 메모리를 사용한다.
//
//  2) reference(레퍼런스)
//     데이터가 저장된 메모리의 주소를 저장하는 메모리.
//    - 문자열(주소)
//      String : 문자열이 저장된 메모리의 주소를 저장한다.
//               프로그래밍 입문 단계에서는 그냥 문자열을 저장하는 메모리로 생각하라!
//    - 날짜(주소)
//      Date : 날짜 값이 저장된 메모리의 주소를 저장한다.
//             프로그래밍 입문 단계에서는 그냥 날짜를 저장하는 메모리로 생각하라!
//    - 레퍼런스에 대한 자세한 사항은 추후에 자세히 설명할 것이다.

