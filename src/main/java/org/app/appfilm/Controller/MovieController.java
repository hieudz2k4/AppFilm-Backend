package org.app.appfilm.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.app.appfilm.DTO.MovieDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/movies")
@Tag(name = "Movie API")
public class MovieController {
  @GetMapping(path =  "")
  public ResponseEntity<List<MovieDTO>> getAll(@RequestParam(name = "page", required = false) Integer page,
                                               @RequestParam(name = "sort", required = false) String sort) {
    return null;
  }

  public ResponseEntity<List<MovieDTO>> getAllByFiltersAndSort(@RequestParam Map<String, Object> params) {
    return null;
  }

  @PostMapping(path = "/upload")
  public ResponseEntity<String> uploadMovie(MovieDTO movieDTO) {
    return null;
  }

  // PUT

  // PATCH

  // DELETE

}
