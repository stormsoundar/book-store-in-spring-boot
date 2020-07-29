package com.example.demo.controller;

import com.example.demo.common.APIResponse;
import com.example.demo.dto.BookDTO;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;
    private Set<Integer> yop;

//    @RequestMapping(value = "/books", method = RequestMethod.GET)
//    public List<Book> getBooks() {
//        return bookService.getBooks();
//    }
    // Filter one resource using query param
//    @RequestMapping(value = "/books", method = RequestMethod.GET)
//    public List<Book> getBooks(@RequestParam(value = "yearOfPublication", required = false) Integer yop) {
//        return bookService.getBooks(yop);
//    }

    // Filter many resource using query param
//    @RequestMapping(value = "/books", method = RequestMethod.GET)
//    public List<Book> getBooks(@RequestParam(value = "yearOfPublications", required = false) Set<Integer> yop) {
//        return bookService.getBooks(yop);
//    }
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooks(
            @RequestParam(value = "yearOfPublications", required = false) Set<Integer> yop,
            @RequestParam(value = "bookType", required = false) String bookType) {
        return bookService.getBooks(yop, bookType);
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

//    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
//    public Optional<Book> getBookById(@PathVariable("id") Long bookId) {
//        return bookService.getBookById(bookId);
//    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public BookDTO getBookById(
            @PathVariable("id") Long bookId,
            @RequestParam(value = "authorData", required = false) boolean authorData)
    {
        return bookService.getBookById(bookId, authorData);
//        return bookService.getBookById(bookId);
    }

    @RequestMapping(value = "/books", method = RequestMethod.PUT)
    public Book updateBook(@RequestBody Book incomingBook) {
       return bookService.updateBook(incomingBook);
    }

    @RequestMapping(value = "/books/{bookId}", method = RequestMethod.DELETE)
    public Book deleteBookById(@PathVariable Long bookId) {
        return bookService.deleteBookById(bookId);
    }

    @GetMapping("/raw/books")
//    public List<Book> getBooksByRawQuery(@RequestParam(value = "yop") Set<Integer> yop) {
//        this.yop = yop;
//        return bookService.getBooksByRawQuery(yop);
//    }
    public APIResponse getBooksByRawQuery(@RequestParam(value = "yop") Set<Integer> yop) {
        this.yop = yop;
        return bookService.getBooksByRawQuery(yop);
    }

    @GetMapping("caughtException")
    public APIResponse getCaughtException(@RequestParam(value = "number") Integer yop) {
        return bookService.getCaughtException(yop);
    }
}
