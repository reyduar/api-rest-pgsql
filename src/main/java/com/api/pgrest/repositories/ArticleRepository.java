package com.api.pgrest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.api.pgrest.models.Article;

@RepositoryRestResource
public interface ArticleRepository extends CrudRepository<Article, Integer> {

}
