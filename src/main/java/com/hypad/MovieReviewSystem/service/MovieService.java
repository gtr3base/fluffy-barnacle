package com.hypad.MovieReviewSystem.service;

import com.hypad.MovieReviewSystem.dto.MovieDTO;
import com.hypad.MovieReviewSystem.models.Movie;
import com.hypad.MovieReviewSystem.models.Review;
import com.hypad.MovieReviewSystem.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author hypad on 20.03.2025
 * @project MovieReviewSystem
 */
@Service
@Transactional
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private JwtService jwtService;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie addMovie(MovieDTO movieDTO){
        Movie movie = Movie
                .builder()
                .genre(movieDTO.getGenre())
                .title(movieDTO.getTitle())
                .reviews(movieDTO.getReviews())
                .description(movieDTO.getDescription())
                .releaseDate(movieDTO.getReleaseDate())
                .build();
        return movieRepository.save(movie);
    }

    public Movie getMovieById(Long id){
        return movieRepository.findById(id).orElse(null);
    }

    public String validateMovie(Model model, Long id) {
            Movie movie = this.getMovieById(id);
            if(movie != null) {
                model.addAttribute("movie", movie);

                HashMap<String, String> map = new HashMap<>(movie.getReviews().stream()
                                .collect(Collectors.toMap(
                                        rev -> rev.getUser().getUsername(),
                                        Review::getComment
                                )));
                model.addAttribute("reviewsMap", map);

            }
            else{
                return "redirect:/";
            }
        return "movie";
    }
}
