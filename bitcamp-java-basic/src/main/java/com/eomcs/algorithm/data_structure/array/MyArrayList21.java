package com.eomcs.algorithm.data_structure.array;

import java.util.Arrays;

// 테스트1: MyArrayListTest
//  01) 인스턴스/객체 (의 주소)를 담을 레퍼런스 배열을 준비한다.
//  02) 인스턴스를 추가하는 add() 메서드를 정의한다.
//  03) 특정 인덱스의 인스턴스를 리턴하는 get() 메서드를 정의한다.
//  04) 인스턴스를 특정 위치에 삽입하는 add(int, Object) 메서드를 정의한다.
//  05) 특정 위치의 값을 항목을 인스턴스로 교체하는 set(int, Object) 메서드를 정의한다.
//  06) 특정 위치의 항목을 제거하는 remove(int) 메서드를 정의한다.

// 테스트2: MyArrayListTest2
//  07) add()할 때 배열의 크기를 넘는 경우, 배열의 크기를 늘린다.
//  08) add(int, Object)로 임의의 위치로 삽입할 때
//      - 배열의 크기가 작으면 크기를 늘린다.
//      - 인덱스가 유효하지 않으면 오류를 발생시킨다.
//  09) get(int)으로 유효하지 않은 인덱스의 값을 꺼낼 때 예외를 발생시킨다.
//  10) remove()를 수행한 후 맨 끝에 남아 있는 주소를 null로 설정하여
//      인스턴스의 레퍼런스 카운트를 한 개 줄인다.
//  11) set()을 호출할 때 인덱스가 유효하지 않으면 예외를 발생시킨다.

// 테스트3: MyArrayListTest3
//  12) 여러 개의 목록을 동시에 관리할 수 있도록
//      MyArrayList에 선언된 레퍼런스 배열을 스태틱 대신 인스턴스로 전환한다.
//      - 개별적으로 관리해야 할 데이터는 인스턴수 변수를 사용해야 한다.
//  13) 캡슐화를 적용하여 공개할 멤버와 공개하지 말아야 할 멤버를 구분한다.
//  14) ArrayList 인스턴스를 생성할 때 배열의 초기 크기를 설정할 수 있도록 생성자를 추가한다.
//  15) ArrayList 인스턴스를 생성할 때 초기 크기를 지정하지 않고 생성할 수 있도록 기본 생성자를 추가한다.
//  16) 배열 크기를 지정할 때 기본 크기보다 큰 값이 되도록 생성자를 변경한다.
//  17) 배열의 기본 크기를 직접 숫자로 지정하지 말고 상수를 사용하여 지정한다.
//  18) 배열의 크기를 늘릴 때 자바에서 제공하는 Arrays를 사용하여 처리한다. (java.util.Arrays.copyOf())
//  19) 배열의 특정 항목을 삭제할 때 배열 복사 기능을 이용하여 처리한다. (System.arraycopy())
//  20) ArrayList에 보관되어 있는 인스턴스 목록을 배열로 리턴하는 toArray() 메서드를 추가한다.
//  21) toArray()에서 배열을 복사할 때 Arrays.copyOf() 메서드를 활용해보자.
public class MyArrayList21 {

  private static final int DEFAULT_CAPACITY = 5;
  private Object[] elementDate;
  private int size;

  public MyArrayList21() {
    elementDate = new Object[DEFAULT_CAPACITY];
  }

  public MyArrayList21(int initialCapacity) {
    if(initialCapacity < DEFAULT_CAPACITY) {
      elementDate = new Object[DEFAULT_CAPACITY];
    } else {
      elementDate = new Object[initialCapacity];
    }
  }

  public boolean add(Object e) {
    if(size == elementDate.length) {
      grow();
    }
    elementDate[size++] = e;
    return true;
  }

  private void grow() {
    //System.out.println("오호라! 배열을 늘리자!");
    int newCapacity = elementDate.length + (elementDate.length >> 1);
    elementDate  = Arrays.copyOf(elementDate, newCapacity);
  }

  public void add(int index, Object element) {
    if(size == elementDate.length) {
      grow();
    }
    if (index < 0 || index > size) {
      throw new ArrayIndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
    }
    for(int i = size; i > index ; i--) {
      elementDate[i] = elementDate[i-1];
    }
    elementDate[index] = element;
    size++;
  }

  public Object get(int index) {
    if(index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
    }
    return elementDate[index];
  }

  public Object set(int index, Object element) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
    }
    Object old = elementDate[index];
    elementDate[index] = element;
    return old;
  }

  public Object remove(int index) {
    Object old = elementDate[index];

    System.arraycopy(
        elementDate, // 복사 대상
        index + 1, // 복사할 항목의 시작 인덱스
        elementDate, // 목적지
        index, // 복사 목적지 인덱스
        this.size - (index + 1) // 복사할 항목의 개수
        );

    size--;
    elementDate[size] = null;
    return old;
  }

  public int size() {
    return this.size;
  }

  public Object[] toArray() {
    Object[] arr = Arrays.copyOf(elementDate, this.size);
    //System.out.println(elementDate == arr); // false
    return arr;
    /*
    Object[] arr = new Object[this.size];
    for(int i = 0; i < arr.length; i++) {
      arr[i] = elementDate[i];
    }
    return arr;
    */
  }

}
