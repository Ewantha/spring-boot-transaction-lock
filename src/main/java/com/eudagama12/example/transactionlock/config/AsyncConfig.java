package com.eudagama12.example.transactionlock.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableAsync
@Slf4j
public class AsyncConfig {

    private final TaskExecutor taskExecutor;

    public AsyncConfig(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    @PostConstruct
    public void logAsyncConfig() {
        ThreadPoolTaskExecutor executor = (ThreadPoolTaskExecutor) taskExecutor;
        log.info("Async Configuration:");
        log.info("Core Pool Size: " + executor.getCorePoolSize());
        log.info("Max Pool Size: " + executor.getMaxPoolSize());
        log.info("Queue Capacity: " + executor.getQueueCapacity());
        log.info("Thread Name Prefix: " + executor.getThreadNamePrefix());
    }
    
}
