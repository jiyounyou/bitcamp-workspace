package com.eomcs.algorithm.data_structure.linkedlist;

// 테스트1: MyLinkedListTest
//  01) LinkedList 클래스 정의
//  02) 값을 담을 노드 클래스를 설계한다.
//  03) 첫 번째 노드와 마지막 노드의 주소를 담을 필드를 추가한다.
//      목록 크기를 저장할 필드를 추가한다.
//  04) 목록에 값을 추가하는 add() 메서드를 정의한다.
//  05) 목록에서 값을 조회하는 get() 메서드를 정의한다.
//  06) 목록에서 특정 인덱스 위치에 값을 삽입하는 add(int, Object) 메서드를 정의한다.
//      - Node의 생성자를 추가한다.
//  07) 목록에서 특정 인덱스의 값을 제거하는 remove(int) 메서드를 정의한다.
//  08) 목록에서 특정 인덱스의 값을 바꾸는 set(int, Object) 메서드를 정의한다.
//  09) 목록의 데이터를 새 배열에 담아 리턴하는 toArray() 메서드를 정의한다.
//  10) 인스턴스 필드에 대해 캡슐화를 적용한다.
//      - 목록 크기를 리턴하는 size()를 추가로 정의한다.

// 테스트2: MyLinkedListTest2
//  11) 제네릭을 적용한다.
public class MyLinkedList11<E> {

  private Node<E> first;
  private Node<E> last;
  private int size;

  static class Node<E> {
    E value;
    Node<E> next;

    public Node() {}

    public Node(E value) {
      this.value = value;
    }
  }

  public boolean add(E e) {
    Node<E> node = new Node<>();
    node.value = e;

    if(first == null) {
      first = node;
    } else {
      last.next = node;
    }
    last = node;

    size++;
    return true;
  }

  public E get(int index) {
    if (index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
    }

    Node<E> cursor = this.first;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }

    return cursor.value;
  }

  public void add(int index, E element) {
    if (index < 0 || index > this.size) {
      throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
    }

    Node<E> node = new Node<>(element);

    size++;

    if (index == 0) {
      node.next = first;
      first = node;
      return;
    }

    Node<E> cursor = this.first;
    for (int i = 1; i <= index - 1; i++) {
      cursor = cursor.next;
    }

    node.next = cursor.next;
    cursor.next = node;

    if (node.next == null) {
      last = node;
    }
  }

  public E remove(int index) {
    if(index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
    }

    size--;

    if(index == 0) {
      Node<E> old = first;
      first = old.next;
      old.next = null;
      return old.value;
    }

    Node<E> cursor = this.first;
    for (int i = 1; i <= index - 1; i++) {
      cursor = cursor.next;
    }

    Node<E> old = cursor.next;

    cursor.next = old.next;

    old.next = null;

    if(cursor.next == null) {
      last = cursor;
    }

    return old.value;
  }

  public E set(int index, E element) {
    if(index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
    }

    Node<E> cursor = this.first;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }

    E old = cursor.value;
    cursor.value = element;

    return old;
  }

  public Object[] toArray() {
    Object[] arr = new Object[this.size];

    int i = 0;
    Node<E> cursor = first;
    // while문의 조건에 따라
    // cursor는 first부터 last까지 이동한다.
    while (cursor != null) {
      arr[i++] = cursor.value;
      cursor = cursor.next;
    }

    return arr;
  }

  public int size() {
    return this.size;
  }

}
