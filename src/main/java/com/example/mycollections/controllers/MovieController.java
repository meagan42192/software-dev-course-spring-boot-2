package com.example.mycollections.controllers;

import com.example.mycollections.models.Movies;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final List<Movies> movies = new ArrayList<>() {{
        add(new Movies("The Notebook", 2004,"Nick Cassavetes", 123));
        add(new Movies("Titanic", 1997,"James Cameron", 195));
        add(new Movies("Barbie", 2023,"Greta Gerwig", 114));
    }};

    @GetMapping("/json")
    public List<Movies> getMoviesJson() {
        return movies;
    }

    @GetMapping("/html")
    public String getMoviesHtml() {
        String movieList = "<ul>";

        for (Movies movie : movies) {
            movieList += "<li>" + movie + "</li>";
        }

        movieList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Movies</h1>
                """ +
                movieList +
                """
                    </body>
                </html>
                """;
    }
}
