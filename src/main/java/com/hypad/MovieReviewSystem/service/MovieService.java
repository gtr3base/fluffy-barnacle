package com.hypad.MovieReviewSystem.service;

import com.hypad.MovieReviewSystem.details.UserDetailsImpl;
import com.hypad.MovieReviewSystem.dto.MovieDTO;
import com.hypad.MovieReviewSystem.models.Movie;
import com.hypad.MovieReviewSystem.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @author hypad on 20.03.2025
 * @project MovieReviewSystem
 */
@Service
@Transactional
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

    public Movie getMovieById(Long id){
        return movieRepository.findById(id).isPresent() ? movieRepository.findById(id).get() : null;
    }

    public String validateMovie(Model model, Long id, UserDetailsImpl userDetails) {
        if(userDetails != null){
            Movie movie = this.getMovieById(id);
            if(movie != null){
                model.addAttribute("movie", movie);
                model.addAttribute("user",userDetails);
            }
            else{
                return "redirect:/";
            }
        }else{
            return "redirect:/";
        }
        return "movie";
    }
}
