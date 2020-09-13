// 부동소수점의 정규화 = 2진수로 바꾸기 II

package com.eomcs.basic.ex03;

class Exam0360 {
  public static void main(String[] args) {
    System.out.println(2.127f);
  }
}

// 주의!
//  - 유효 자릿수의 부동소수점이라도 정규화할 때 2진수로 딱 떨어지지 않 경우가 있다.
//    예) 2.127
//        2 => 0010
//        0.127 =>
//        0.127 * 2 = 0.254 --> 0
//        0.254 * 2 = 0.508 --> 0
//        0.508 * 2 = 1.016 --> 1
//        0.016 * 2 = 0.032 --> 0
//        0.032 * 2 = 0.064 --> 0
//        0.064 * 2 = 0.128 --> 0
//        0.128 * 2 = 0.256 --> 0
//        0.256 * 2 = 0.512 --> 0
//        0.512 * 2 = 1.024 --> 1
//        0.024 * 2 = 0.048 --> 0
//                ....
//    이처럼 2진수로 완벽히 표현할 수 없는 수가 있다.
//    0.00000....1 의 오차가 있다.
//    그래서 부동소수점은 정수와 다르게 정확하게 메모리에 저장되지 않는다.
