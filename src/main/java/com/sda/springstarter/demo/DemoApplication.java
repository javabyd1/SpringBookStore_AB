package com.sda.springstarter.demo;

import com.sda.springstarter.demo.model.Author;
import com.sda.springstarter.demo.model.Book;
import com.sda.springstarter.demo.model.Opinions;
import com.sda.springstarter.demo.model.Shops;
import com.sda.springstarter.demo.repository.AuthorRepository;
import com.sda.springstarter.demo.service.AuthorServiceImpl;
import com.sda.springstarter.demo.service.BookServiceImpl;
import com.sda.springstarter.demo.service.OpinionsServiceImpl;
import com.sda.springstarter.demo.service.ShopsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private BookServiceImpl bookService;
	@Autowired
	private OpinionsServiceImpl opinionsService;
	@Autowired
	private ShopsServiceImpl shopsService;
	@Autowired
	private AuthorRepository authorRepository;


	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book("Tytul","Autor");
		Book book2 = new Book("Tytul2","Autor2");

		bookService.saveBook(book1);
		bookService.saveBook(book2);

		Shops shop1 = new Shops("Nazwa1","ulica1", "Miasto1");
		Shops shop2 = new Shops("Nazwa2","ulica2", "Miasto2");

		shopsService.saveShops(shop1);
		shopsService.saveShops(shop2);


		Opinions opinions1 = new Opinions("Tytul", "abc1");
		Opinions opinions2 = new Opinions("Tytul1", "abc2");

		opinionsService.saveOpinions(opinions1);
		opinionsService.saveOpinions(opinions2);

		Author author = authorRepository.findById(1);

		Book book = new Book();
		book.setTitle("Java");
		book.setAuthor("XYZ");
		bookService.saveBook(book);

	}


}
