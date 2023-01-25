package com.api.bootrestbook.controller;

import com.api.bootrestbook.entities.Book;
import com.api.bootrestbook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
   // @RequestMapping(value = "/books", method = RequestMethod.GET)
    @GetMapping("/books")
    /* public Book getBooks(){
       //return "This is a testing Book Controller!!";
        Book book = new Book();
        book.setId(1234);
        book.setTitle("Java Complete Reference");
        book.setAuthor("xyz");
        return book;
    }
   */
           public ResponseEntity<List<Book>> getBooks()
    {
        List<Book> list =bookService.getAllBooks();
        if(list.size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

     /*public List<Book> getBooks()
    {
        return this.bookService.getAllBooks();
    }

      */

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id)
    {
        return bookService.getBookById(id);
    }
    //Create book Handler
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book ){

        Book b = this.bookService.addBook(book);
        return book;
    }
    //Delete book Handler
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId")int bookId)
    {
        this.bookService.deleteBook(bookId);
    }

    //Update book Handler
    @PutMapping("/books/{bookId}")
    public void updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId)
    {
        this.bookService.updateBook(book,bookId);
    }

}
