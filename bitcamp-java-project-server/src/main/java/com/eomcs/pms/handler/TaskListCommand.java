package com.eomcs.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import com.eomcs.pms.domain.Task;
import com.eomcs.pms.service.TaskService;

public class TaskListCommand implements Command {

  TaskService taskService;

  public TaskListCommand(TaskService taskService) {
    this.taskService = taskService;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in, Map<String, Object> context) {
    try {
      out.println("[작업 목록]");

      List<Task> list = taskService.list();

      out.println("번호, 내용, 마감일, 상태, 담당자");
      for (Task task : list) {
        String stateLabel = null;
        switch (task.getStatus()) {
          case 1:
            stateLabel = "진행중";
            break;
          case 2:
            stateLabel = "완료";
            break;
          default:
            stateLabel = "신규";
        }
        out.printf("%d, %s, %s, %s, %s\n",
            task.getNo(),
            task.getContent(),
            task.getDeadline(),
            stateLabel,
            task.getOwner());
      }
    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }
}
