package com.api.pgrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.pgrest.models.Article;
import com.api.pgrest.repositories.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	
	
	public Article create(Article article) {
		return articleRepository.save(article);
	}
	
	public List<Article> findAllArticles() {
		return (List<Article>) articleRepository.findAll();
	}
	
	public void delete(Article article) {
		articleRepository.delete(article);
	}
	
	public Optional<Article> findById(Integer id) {
		return articleRepository.findById(id);
	}
}
