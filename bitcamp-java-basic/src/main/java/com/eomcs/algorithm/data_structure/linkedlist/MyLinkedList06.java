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
public class MyLinkedList06 {

  Node first;
  Node last;
  int size;

  static class Node {
    Object value;
    Node next;

    // 기본 생성자
    public Node() {}

    // Object를 받는 생성자
    public Node(Object value) {
      this.value = value;
    }

  }

  public boolean add(Object e) {
    Node node = new Node();
    node.value = e;

    if (first == null) {
      first = node;
    } else {
      last.next = node;
    }
    last = node;

    size++;
    return true;
  }

  public Object get(int index) {
    if (index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
    }

    Node cursor = this.first;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }

    return cursor.value;
  }

  // 입력한 인덱스의 바로 전 인덱스를 찾아
  // 그 바로 다음에 element를 넣는다.
  public void add(int index, Object element) {
    // 인덱스의 유효성을 검증한다.
    if (index < 0 || index > this.size) {
      throw new IndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
    }

    Node node = new Node(element);

    size++;

    // element를 넣으려는 위치가 처음이면
    // node.next에 기존의 first를 넣고,
    // first라는 변수가 가리키는 Object를 node로 만든다.
    if (index == 0) {
      node.next = first;
      first = node;
      return;
    }

    // 입력한 인덱스의 바로 전 node를 찾는다.
    // 여기서 찾은 node의 next에는 인덱스 위치의 node를 가리키는 레퍼런스가 들어있다.
    Node cursor = this.first;
    for (int i = 1; i <= index - 1; i++) {
      cursor = cursor.next;
    }

    // 새 node에는 인덱스 node 주소를 넣고,
    // cursor 위치의 nod\\에는 새 node의 주소를 넣는다.
    node.next = cursor.next;
    cursor.next = node;

    // index를 지정했지만, 맨 끝에 데이터가 삽입된 경우에
    // last를 바꿔주어야 한다.
    // node가 끝에 들어간 경우, next가 null이다.
    if (node.next == null) {
      last = node;
    }
  }

}