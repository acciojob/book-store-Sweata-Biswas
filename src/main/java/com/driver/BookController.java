package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book newBook = bookService.createBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }
    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable String id){
        Book newBook = bookService.findBookById(id);
        return new ResponseEntity<>(newBook, HttpStatus.OK);
    }
    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> findAllBooks(){

        return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.OK);
    }
    @GetMapping("/get-book-by-author")
    public ResponseEntity<List<Book>> findBooksByAuthor(@RequestParam("author") String author){

        return new ResponseEntity<>(bookService.findBooksByAuthor(author), HttpStatus.OK);
    }
    @GetMapping("/get-book-by-genre")
    public ResponseEntity<List<Book>> findBooksByGenre(@RequestParam("genre") String genre){

        return new ResponseEntity<>(bookService.findBooksByGenre(genre), HttpStatus.OK);
    }
    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable String id){
        bookService.deleteBookById(id);
        return new ResponseEntity<>("Record deleted", HttpStatus.OK);
    }
    @DeleteMapping("/delete-all-books")
    public ResponseEntity<String> deleteBookById(){
        bookService.deleteAllBooks();
        return new ResponseEntity<>("all Records deleted", HttpStatus.OK);
    }
}
