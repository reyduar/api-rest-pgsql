package com.api.pgrest.controllers;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.CONFLICT;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.pgrest.models.Article;
import com.api.pgrest.services.ArticleService;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@PostMapping
	private ResponseEntity<?> create(@RequestBody Article body){
		Map<String, Object> map = new HashMap<>();

		try {
			Article newArticle = articleService.create(body);
			map.put("article", newArticle);
			return new ResponseEntity<>(map, OK);
		} catch (Exception e) {
			map.put("error", "Error al crear el nuevo articulo");
			return new ResponseEntity<>(map, CONFLICT);
		}
	}


	@GetMapping(value = "/getArticles")
	public ResponseEntity<?> getAll(){
		Map<String, Object> map = new HashMap<>();
		map.put("articulos", articleService.findAllArticles());
		return new ResponseEntity<>(map, OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> delete(@RequestBody Article body) {
		Map<String, Object> map = new HashMap<>();
		try {
			articleService.delete(body);
			map.put("message", "Borrado con éxito");
			return new ResponseEntity<>(map, OK);
		} catch (Exception e) {
			map.put("error", "Error al borrar el articulo");
			return new ResponseEntity<>(map, CONFLICT);
		}
	}
}
