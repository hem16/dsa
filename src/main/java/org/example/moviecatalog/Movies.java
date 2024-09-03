package org.example.moviecatalog;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDate;

@JsonPropertyOrder({ "movieId", "title", "date", "genres" })
@Data
public class Movies {

    @JsonProperty
    private int movieId;
    @JsonProperty
    private String title;
    @JsonProperty
    private String date;
    @JsonProperty
    private String genres;

}
