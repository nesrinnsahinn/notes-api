package com.example.notes_api;

import org.springframework.data.jpa.repository.JpaRepository;

// Note tablosu için Repository hazır CRUD metotları otomatik gelir
public interface NoteRepository extends JpaRepository<Note, Long> {
}
