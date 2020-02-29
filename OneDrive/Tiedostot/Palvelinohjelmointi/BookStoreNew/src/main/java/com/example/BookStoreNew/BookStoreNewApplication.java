package com.example.BookStoreNew;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.BookStoreNew.domain.Book;
import com.example.BookStoreNew.domain.BookRepository;
import com.example.BookStoreNew.domain.Category;
import com.example.BookStoreNew.domain.CategoryRepository;

@SpringBootApplication
public class BookStoreNewApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreNewApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookStoreNewApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookstoreDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {

			crepository.save(new Category("Gibli"));
			crepository.save(new Category("Fantasia"));
			crepository.save(new Category("Kauhu"));

			log.info("save a couple of books"); // logger tuottaa lokia ohjelman toiminnasta
			brepository.save(new Book("Maamerentarinat", "Hayao", "978-951-1-34784-2", 2000,
					crepository.findByName("Gibli").get(0)));
			brepository.save(new Book("Liisa Ihmemaassa", "Fantasia", "978-951-1-34784-2", 1980,
					crepository.findByName("Gibli").get(0)));
			brepository
					.save(new Book("It", "Kauhu", "978-951-1-34784-2", 2001, crepository.findByName("Gibli").get(0)));
			brepository.save(new Book("Liikkuva Linna", "Hayao", "978-951-1-34784-2", 2003,
					crepository.findByName("Gibli").get(0)));
			brepository.save(new Book("Laputa Linna Taivaalla", "Hayao", "978-951-1-34784-2", 2006,
					crepository.findByName("Gibli").get(0)));
			// repository.deleteAll(); //Poistaa kaikki kirjat mikäli niin halutaan

			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
