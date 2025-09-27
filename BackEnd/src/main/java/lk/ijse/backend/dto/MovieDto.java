package lk.ijse.backend.dto;

import java.util.List;

public class MovieDto {
    private String title;
    private String year;
    private List<String> genres;
    private String description;
    private String imageUrl;
    private String videoUrl;
    private String subtitleUrl;
    private Long views = 0L;
}
