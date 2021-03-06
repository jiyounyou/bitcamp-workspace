package com.eomcs.oop.ex02;

public class Exam0113 {

  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }

  public static void main(String[] args) {

    Score s1;
    s1 = new Score();

    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 87;
    computeScore(s1);

    Score s2 = new Score();
    s2.name = "임꺽정";
    s2.kor = 90;
    s2.eng = 100;
    s2.math = 100;
    computeScore(s2);

    printScore(s1);
    printScore(s2);
  }

  // 서로 관련된 데이터는 묶어서 관리하는게 편하지 않을까?
  //  => computeScore()를 Score 클래스 안으로 옮기자!
  static void computeScore(Score s) {
    s.sum = s.kor + s.eng + s.math;
    s.aver = s.sum / 3f;
  }

  static void printScore(Score s) {
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.aver );
  }

}
