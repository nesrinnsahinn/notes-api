package com.example.notes_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "http://localhost:4200")

@RestController // bu sınıf HTTP isteklerini karşılar
public class NoteController {

  private final NoteRepository repo;

 
  public NoteController(NoteRepository repo) {
    this.repo = repo;
  }

  @GetMapping("/notes/hello") // test 
  public String helloNotes() {
    return "Notes API çalışıyor!";
  }

  
  @GetMapping("/api/notes")
  public List<Note> list() {
    return repo.findAll();
  }

  // not ekleme 
  @PostMapping("/api/notes")
  public Note create(@RequestBody Note newNote) {
    return repo.save(newNote); 
  }

// not güncelleme
@PutMapping("/api/notes/{id}")
public Note update(@PathVariable Long id, @RequestBody Note payload) {
    Note n = repo.findById(id).orElseThrow(); 
    n.setTitle(payload.getTitle());
    n.setContent(payload.getContent());
    return repo.save(n);
}

//not silme
@DeleteMapping("/api/notes/{id}")
public void delete(@PathVariable Long id) {
    repo.deleteById(id);
}


}
