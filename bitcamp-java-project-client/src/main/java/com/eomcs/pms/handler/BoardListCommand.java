package com.eomcs.pms.handler;

import java.sql.DriverManager;

public class BoardListCommand implements Command {


  @Override
  public void execute() {
    System.out.println("[게시물 목록]");

    try (java.sql.Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        java.sql.PreparedStatement stmt = con.prepareStatement(
            "select no, title, writer, cdt, vw_cnt"
            + " from pms_board"
            + " order by no desc");
        java.sql.ResultSet rs = stmt.executeQuery()) {

      System.out.println("번호, 제목, 작성자, 등록일, 조회수");
      while (rs.next()) {
        System.out.printf("%d, %s, %s, %s, %d\n",
            rs.getInt("no"),
            rs.getString("title"),
            rs.getString("writer"),
            rs.getDate("cdt"),
            rs.getInt("vw_cnt"));
      }

    } catch (Exception e) {
      System.out.println("데이터 목록 조회 중 오류 발생!");
      e.printStackTrace();
    }
  }
}
