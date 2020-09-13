// 정수 리터럴(literal) - 정수를 메모리에 저장하는 방법

package com.eomcs.basic.ex03;

public class Exam0250 {
  public static void main(String[] args) {
    // 23
    // => 0000 0000 0000 0000 0000 0000 0001 0111
    System.out.println(23);

    // -23
    // 1) Sign-magnitude : 맨 앞비트로 음수 표시
    //   => 1000 0000 0000 0000 0000 0000 0001 0111 (-23)
    //   => 23 + (-23) = 0
    //   => 정말?
    //    0000 0000 0000 0000 0000 0000 0001 0111 (23)
    //    1000 0000 0000 0000 0000 0000 0001 0111 (-23)
    //    ---------------------------------------
    //    1000 0000 0000 0000 0000 0000 0010 1110 = -46
    //    이 방식은 23 + (-23) 의 결과가 옳게 나오지 않는다.
    //

    // 2) 1's complement(1의 보수)
    //   => 모든 비트를 1이 되는 수로 바꾼다. 즉 0을 1로, 1을 0으로 바꾼다.
    //   => 1111 1111 1111 1111 1111 1111 1110 1000 (-23)
    //   => 23 + (-23)
    //    0000 0000 0000 0000 0000 0000 0001 0111 (23)
    //    1111 1111 1111 1111 1111 1111 1110 1000 (-23)
    //    ---------------------------------------
    //    1111 1111 1111 1111 1111 1111 1111 1111 = 0이 아니다.
    //   +                                      1 <= 1을 추가로 더한다.
    //    ---------------------------------------
    //   10000 0000 0000 0000 0000 0000 0000 0000 = 0
    //    음수를 더할 때는 항상 결과에 1을 추가해야 한다.
    //
    // 3) 2's complement(2의 보수)
    //   => 1의 보수로 저장된 음수 값을 더할 때 마다
    //    계산 결과에 1을 추가하는 번거로움을 없애기 위해
    //    음수를 저장할 때 미리 1을 추가해 두는 방법
    //   => 1의 보수 + 1 => 2의 보수
    //   => 1111 1111 1111 1111 1111 1111 1110 1001 (-23)
    //   => 23 + (-23)
    //    0000 0000 0000 0000 0000 0000 0001 0111 (23)
    //    1111 1111 1111 1111 1111 1111 1110 1001 (-23)
    //    ---------------------------------------
    //   10000 0000 0000 0000 0000 0000 0000 0000 = 0
    //   그래서 컴퓨터에서 음수를 메모리에 저장할 때는
    //   양수와 음수를 더할 때 정상적인 값이 나오도록
    //   2의 보수 방법으로 음수를 저장한다.
    //
    System.out.println(-23);
  }
}
