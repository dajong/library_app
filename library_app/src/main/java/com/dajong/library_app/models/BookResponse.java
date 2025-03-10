package com.dajong.library_app.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BookResponse {
    Long bookId;
    String title;
    String author;
}
