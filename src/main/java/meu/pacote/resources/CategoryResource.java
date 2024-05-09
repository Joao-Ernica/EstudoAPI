package meu.pacote.resources;

import meu.pacote.entities.Category;
import meu.pacote.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("Categorys")
public class CategoryResource {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = categoryService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("{id}")
	public Category findById(@PathVariable Long id) {
		try {
			return categoryService.findById(id);
		} catch (NoSuchElementException e) {
			return
					null;
		}
	}
}
