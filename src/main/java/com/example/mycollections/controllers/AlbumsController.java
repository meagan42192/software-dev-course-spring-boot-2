package com.example.mycollections.controllers;

import com.example.mycollections.models.Albums;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

    private final List<Albums> albums = new ArrayList<>() {{
        add(new Albums("1989", 2014,"Taylor Swift",  13));
        add(new Albums("Rumours", 1977,"Fleetwood Mac",  11));
        add(new Albums("Thriller", 1982,"Michael Jackson",  9));
    }};

    @GetMapping("/json")
    public List<Albums> getAlbumsJson() {
        return albums;
    }

    @GetMapping("/html")
    public String getAlbumsHtml() {
        String albumList = "<ul>";

        for (Albums album : albums) {
            albumList += "<li>" + album + "</li>";
        }

        albumList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Albums</h1>
                """ +
                albumList +
                """
                    </body>
                </html>
                """;
    }
}
