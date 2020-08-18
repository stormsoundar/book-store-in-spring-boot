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

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public BookDTO getBookById(
            @PathVariable("id") Long bookId,
            @RequestParam(value = "authorData", required = false) boolean authorData)
    {
        return bookService.getBookById(bookId, authorData);
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
    public APIResponse getBooksByRawQuery(@RequestParam(value = "yop") Set<Integer> yop) {
        this.yop = yop;
        return bookService.getBooksByRawQuery(yop);
    }

    @GetMapping("caughtException")
    public APIResponse getCaughtException(@RequestParam(value = "number") Integer yop) {
        return bookService.getCaughtException(yop);
    }
}
