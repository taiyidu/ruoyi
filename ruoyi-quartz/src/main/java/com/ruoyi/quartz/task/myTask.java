package com.ruoyi.quartz.task;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class myTask {
    public void runTask1() {
        System.out.println("执行了定时任务:"+ LocalDateTime.now());
    }
}
