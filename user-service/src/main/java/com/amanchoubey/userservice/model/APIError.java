package com.amanchoubey.userservice.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record APIError(LocalDateTime timestamp, int status, String errorMessage, String message, String path) implements Serializable {

}
