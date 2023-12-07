package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface User {

    String getEmail();

    String getPassword();

    LocalDateTime getCreationTime();
}
