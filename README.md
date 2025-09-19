# Notes API — Spring Boot 3 (Java 17)

Basit not uygulamasının **REST API** katmanı. Angular UI (4200) bu servise **Basic Auth** ile bağlanır.  
Veritabanı: **H2 (in-memory)** — tablolar **otomatik** oluşur (elle yaratma yok).

---

## ✨ Özellikler
- CRUD: **listele / ekle / güncelle / sil**
- **Güvenlik**: Basic Auth, login olmadan `/api/**` kapalı
- **CORS**: `http://localhost:4200` için açık
- **H2 Console**: tarayıcıdan görüntüleme

---

## 🚀 Hızlı Başlangıç
```bash
# Proje kökünde
./mvnw spring-boot:run

Sağlık kontrolü: http://localhost:8080/notes/hello → "Notes API çalışıyor!"

H2 Console: http://localhost:8080/h2-console
JDBC: jdbc:h2:mem:testdb · User: sa · Password: (boş)

