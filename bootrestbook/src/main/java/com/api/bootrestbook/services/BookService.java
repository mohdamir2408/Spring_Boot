package com.api.bootrestbook.services;

import com.api.bootrestbook.dao.BookRepository;
import com.api.bootrestbook.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

@Component
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    /* private static List<Book> list  = new ArrayList<>();
    static {
        list.add(new Book(5678,"Thing in Java","ABC"));
        list.add(new Book(9012,"Java Complete Reference","ABC"));
        list.add(new Book(5988,"Head First to Java","AABB"));
    }

     */

    //get all books

    public List<Book> getAllBooks()
    {
        //return list;
        List<Book> list=(List<Book>)this.bookRepository.findAll(); // type Cast
        return list;
    }

    //single book by id
    public Book getBookById(int id)
    {
        Book book = null;
        try {
            // book = list.stream().filter(e->e.getId()==id).findFirst().get();
           book= this.bookRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return book;
    }

    //Code for POST API using add book
    public Book addBook(Book b)
    {
        //list.add(b);
        Book result = bookRepository.save(b);
        return result;
    }

    //Delete book
    public void deleteBook(int bid)
    {
        //list = list.stream().filter(book->book.getId()!= bid).collect(Collectors.toList());
        bookRepository.deleteById(bid);
    }

    //Update book

    public void  updateBook(Book book, int bookId )
    {
        /*list = list.stream().map(b->
        {
             if (b.getId()==bookId)
            {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
         }).collect(Collectors.toList());

         */
        book.setId(bookId);
        bookRepository.save(book);
    }


}
