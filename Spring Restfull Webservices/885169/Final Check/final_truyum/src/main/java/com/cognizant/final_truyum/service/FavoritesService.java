package com.cognizant.final_truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.final_truyum.dao.FavoritesDao;
import com.cognizant.final_truyum.exception.FavoritesEmptyException;
import com.cognizant.final_truyum.model.Movie;

@Service
public class FavoritesService {
	
	@Autowired
	FavoritesDao dao;
	
	public void addFavoritesMovie(long userId, long movieId)
	{
		dao.addFavoritesMovie(userId, movieId);
	}
	
	public List<Movie> getAllFavoriteMovies(long userId) throws FavoritesEmptyException
	{
		return dao.getAllFavoritesMovies(userId);
	}
	
	public void removeFavoriteMovie(long userId, long movieId)
	{
		dao.removeFavoritesMovie(userId, movieId);
	}

}
