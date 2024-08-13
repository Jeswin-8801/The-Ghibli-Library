package com.jeswin8801.ghibli_lib.repository.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class MovieTitle {
    @Id
    private String name;
}
