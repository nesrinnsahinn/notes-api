package com.example.notes_api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.notes_api.Note;
import com.example.notes_api.NoteRepository;

@Component
public class NoteBootstrap implements CommandLineRunner {
  private final NoteRepository repo;

  public NoteBootstrap(NoteRepository repo) { this.repo = repo; }

  @Override
  public void run(String... args) {
    // Tabloda hiç veri yoksa iki örnek not 
    if (repo.count() == 0) {
      Note a = new Note(); a.setTitle("İlk notum");     repo.save(a);
      Note b = new Note(); b.setTitle("İkinci notum");  repo.save(b);
    }
  }
}
