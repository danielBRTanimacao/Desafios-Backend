package daniel.security.domain.model;

import java.time.Instant;
import java.util.UUID;

public class User {
    private UUID id;

    private String name;
    private String email;
    private String mailToken;
    private String password;

    private Instant createdAt;
    private Instant updatedAt;

    public User() {}

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String email, String mailToken, String password) {
        this.name = name;
        this.email = email;
        this.mailToken = mailToken;
        this.password = password;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMailToken() {
        return this.mailToken;
    }

    public void setMailToken(String mailToken) {
        this.mailToken = mailToken;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
