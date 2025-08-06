# Gestionale Corsi – Backend  
*Academy Sistemi Informativi S.p.A.*

Questo progetto rappresenta il **backend del gestionale corsi** sviluppato durante il test finale dell’**Academy di Sistemi Informativi S.p.A.**  
L'applicazione espone API REST per la gestione di corsi, utenti e iscrizioni, ed è progettata per integrarsi con un frontend Angular.

---

## 🚀 Funzionalità principali

- Creazione, modifica e cancellazione di corsi formativi
- Registrazione e gestione degli utenti
- Iscrizione degli utenti ai corsi
- Espone API REST per l’interazione con il frontend

---

## 🛠️ Tecnologie utilizzate

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Database relazionale (es. PostgreSQL o H2)
- Maven / Gradle

---

## ▶️ Avvio del progetto

1. **Clona il repository**:
   ```bash
   git clone <URL_REPO_BACKEND>
   cd nome-cartella-backend
   ```

2. **Configura il file `application.properties` o `application.yml`** con:
   - URL e credenziali del database
   - eventuali parametri per CORS se serve comunicare col frontend

3. **Avvia l’applicazione**:

   Con Maven:
   ```bash
   ./mvnw spring-boot:run
   ```

   Oppure con Gradle:
   ```bash
   ./gradlew bootRun
   ```

---

### 🌐 Accesso al backend

L’app sarà disponibile su:

```bash
http://localhost:8080/
```

---

### 📘 API disponibili

Le API sono esposte in formato REST. Se Swagger è abilitato, la documentazione sarà visibile su:

```bash
http://localhost:8080/swagger-ui.html
```

---

### 🔗 Collegamento con il frontend

Il frontend Angular comunica con questo backend per:

- Effettuare login e registrazione
- Visualizzare i corsi disponibili
- Iscriversi ai corsi

> Assicurati che il backend sia attivo e accessibile dal frontend (configura CORS se necessario).

---

### 👤 Autore

Realizzato da **Luigi Vasile**  
Nell’ambito del test finale dell’Academy di **Sistemi Informativi S.p.A.**

---

### 📄 Licenza

Uso accademico / dimostrativo – Nessuna licenza commerciale.
