package com.spring.swagger.controller;

import com.spring.swagger.model.Task;
import com.spring.swagger.repository.TaskRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/task")
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("")
    @Timed(value = "findAllTask.time", description = "Time taken to return all tasks")
    @CircuitBreaker(name = "findAllTaskSupport")
    //@RateLimiter(name = "findAllTaskLimit", fallbackMethod = "findAllTaskLimitFallBack")
    public ResponseEntity<List<Task>> findAllTask(){
        try{
            logger.info("[taskService]: /task findAllTask started..");
            List<Task> tasks = taskRepository.findAll();
            logger.info("[taskService]: /task findAllTask completed");
            return ResponseEntity.ok(tasks);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("[taskService]: /task findAllTask had an error..");
            return ResponseEntity.notFound().build();
        }
    }

    // This is the fallback mechanism for circuit breaker, a proper implemented fallback method can
    // save the application
    private ResponseEntity findAllTaskFallBack(){
        return ResponseEntity.internalServerError().build();
    }

    // A ratelimiter implementation to prevent attacks
    private String findAllTaskLimitFallBack(Throwable throwable){
        return "Please try this service call later -> "+ throwable.getLocalizedMessage();
    }

    @GetMapping("/{id}")
    @Timed(value = "findTaskById.time", description = "Time taken to findTaskById")
    public ResponseEntity<Task> findTaskById(@PathVariable("id") Long id){
        try{
            Optional<Task> task = taskRepository.findById(id);
            return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
