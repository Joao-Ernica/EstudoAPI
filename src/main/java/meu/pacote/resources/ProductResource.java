package meu.pacote.resources;

import meu.pacote.entities.Product;
import meu.pacote.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("Products")
public class ProductResource {

	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = productService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("{id}")
	public Product findById(@PathVariable Long id) {
		try {
			return productService.findById(id);
		} catch (NoSuchElementException e) {
			return
					null;

		}
	}
}
