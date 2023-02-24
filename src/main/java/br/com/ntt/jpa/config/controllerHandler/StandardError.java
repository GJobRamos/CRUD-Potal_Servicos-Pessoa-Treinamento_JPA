package br.com.ntt.jpa.config.controllerHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class StandardError {
    private Integer status;
    private String message;
    private LocalDateTime timeStamp;
}
