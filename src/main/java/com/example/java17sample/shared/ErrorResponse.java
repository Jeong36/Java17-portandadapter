package com.example.java17sample.shared;

import java.util.List;

public record ErrorResponse(
    boolean status,
    List<String> messages
) {

    public ErrorResponse(List<String> messages) {

        this(false, messages);
    }
}
