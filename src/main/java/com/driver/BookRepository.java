package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
   private  List<Book> bookList;
   private int id ;
    public BookRepository(){
        this.bookList = new ArrayList<>();
        this.id = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Book save(Book book){
        BookRepository bookRepository = new BookRepository();
        book.setId(this.getId());
            bookList.add(book);
            setBookList(bookList);
            this.setId(id++);
            return book;
    }

    public Book findBookById(int id){
        for(Book book : bookList)
        if(book.getId() == id){
            return book;
        }
        return null;
    }

    public List<Book> findAll(){
        return getBookList();

    }

    public void deleteBookById(int id){
        for(Book book : bookList)
        if(book.getId() == id){
            bookList.remove(book);
        }

        return;
    }

    public void deleteAll(){
        bookList.clear();
        return;
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> books = new ArrayList<>();
        for(Book m: this.bookList){
            if(m.getAuthor().equals(author)){
                books.add(m);
            }
        }

        return books;
    }

    public List<Book> findBooksByGenre(String genre){

        List<Book> books = new ArrayList<>();
        for(Book m: this.bookList){
            if(m.getGenre().equals(genre)){
                books.add(m);
            }
        }

        return books;
    }
}
