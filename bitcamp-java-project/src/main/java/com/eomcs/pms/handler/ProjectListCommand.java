package com.eomcs.pms.handler;

import java.util.Iterator;
import java.util.List;
import com.eomcs.pms.domain.Project;

public class ProjectListCommand implements Command {

  List<Project> projectList;
  MemberListCommand memberListCommand;

  public ProjectListCommand(List<Project> list, MemberListCommand memberListCommand) {
    this.projectList = list;
    this.memberListCommand = memberListCommand;
  }

  @Override
  public void execute() {
    System.out.println("[프로젝트 목록]");

    Iterator<Project> iterator = projectList.iterator();

    while(iterator.hasNext()) {
      Project project = iterator.next();
      System.out.printf("%d, %s, %s, %s, %s, [%s]\n",
          project.getNo(),
          project.getTitle(),
          project.getStartDate(),
          project.getEndDate(),
          project.getOwner(),
          project.getMembers());
    }
  }

}