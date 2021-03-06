package com.eomcs.oop.ex02.util;

public class Score3 {
  public String name;
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float aver;

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }

  public void init(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;

    // 변수를 초기화 한 후
    // 점수 계산까지 한번에 하도록 메서드를 수정한다.
    this.compute();
  }

}