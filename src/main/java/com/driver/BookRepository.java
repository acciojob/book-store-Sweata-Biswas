package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public BookRepository(){
        
    }
        HashMap<Integer,Book> bookHashMap = new HashMap<>();

    public Book save(Book book){
            bookHashMap.put(book.getId(),book);
        return book;
    }

    public Book findBookById(int id){
        if(bookHashMap.containsKey(id)){
            return bookHashMap.get(id);
        }
        return null;
    }

    public List<Book> findAll(){
        return new ArrayList<>(bookHashMap.values());

    }

    public void deleteBookById(int id){
        if(bookHashMap.containsKey(id)){
            bookHashMap.remove(id);
        }

        return;
    }

    public void deleteAll(){
        bookHashMap.clear();
        return;
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> bookList = new ArrayList<>();
        for(Map.Entry<Integer,Book> m: bookHashMap.entrySet()){
            if(m.getValue().getAuthor().equals(author)){
                bookList.add(m.getValue());
            }
        }

        return bookList;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> bookList = new ArrayList<>();
        for(Map.Entry<Integer,Book> m: bookHashMap.entrySet()){
            if(m.getValue().getGenre().equals(genre)){
                bookList.add(m.getValue());
            }
        }

        return bookList;
    }
}
