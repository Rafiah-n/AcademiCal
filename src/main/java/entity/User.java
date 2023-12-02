package main.java.entity;

import java.time.LocalDateTime;

public interface User {

    String getEmail();

    String getPassword();

    LocalDateTime getCreationTime();
}
