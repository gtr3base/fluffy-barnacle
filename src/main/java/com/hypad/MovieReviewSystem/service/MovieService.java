package com.hypad.MovieReviewSystem.service;

import com.hypad.MovieReviewSystem.dto.MovieDTO;
import com.hypad.MovieReviewSystem.models.Movie;
import com.hypad.MovieReviewSystem.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hypad on 20.03.2025
 * @project MovieReviewSystem
 */
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

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
}
