package com.example.notes_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class NotesApiApplication {
  public static void main(String[] args) {
    SpringApplication.run(NotesApiApplication.class, args);
  }

  
  @RestController
  static class InlinePingController {
    @GetMapping("/ping")
    public String ping() {
      return "pong";
    }
  }
}
