package mk.finki.ukim.wp.birdenricher.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "sql_queries")
public class SqlQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String question;

    @Column(name = "schema_name")
    private String schemaName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Difficulty difficulty;

    @Column(name = "sql_answer", columnDefinition = "TEXT", nullable = false)
    private String sqlAnswer;

    @Column(name = "chatgpt_valid")
    private boolean chatgptValid;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(name = "schema_ddl", columnDefinition = "TEXT")
    private String schemaDdl;

    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @PrePersist
    public void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = Instant.now();
    }

    public SqlQuery() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }
    public String getSchemaName() { return schemaName; }
    public void setSchemaName(String schemaName) { this.schemaName = schemaName; }
    public Difficulty getDifficulty() { return difficulty; }
    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }
    public String getSqlAnswer() { return sqlAnswer; }
    public void setSqlAnswer(String sqlAnswer) { this.sqlAnswer = sqlAnswer; }
    public boolean isChatgptValid() { return chatgptValid; }
    public void setChatgptValid(boolean chatgptValid) { this.chatgptValid = chatgptValid; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public String getSchemaDdl() { return schemaDdl; }
    public void setSchemaDdl(String schemaDdl) { this.schemaDdl = schemaDdl; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
}