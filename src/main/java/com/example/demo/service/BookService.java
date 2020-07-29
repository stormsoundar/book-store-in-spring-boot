package com.example.demo.service;

import com.example.demo.common.APIResponse;
import com.example.demo.data.BookData;
import com.example.demo.dto.AuthorDTO;
import com.example.demo.dto.BookDTO;
import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.entity.BookAuthor;
import com.example.demo.repository.BookAuthorRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookAuthorRepository bookAuthorRepository;
    // Read - GET
//    public List<Book> getBooks() {
//
//        List<Book> bookList = new ArrayList<>();
//
//        bookRepository.findAll()
//                .forEach(book -> bookList.add(book));
//
//        return bookList;
//    }

//    public List<Book> getBooks(Integer yop) {
//
//        List<Book> bookList = new ArrayList<>();
//
//        if(yop == null) {
//            bookRepository.findAll()
//                    .forEach(book -> bookList.add(book));
//        } else {
//           return bookRepository.findAllByYearOfPublication(yop);
//        }
//        return bookList;
//    }

//    public List<Book> getBooks(Set<Integer> yop) {
//
//        List<Book> bookList = new ArrayList<>();
//
//        if(yop == null) {
//            bookRepository.findAll()
//                    .forEach(book -> bookList.add(book));
//        } else {
//            return bookRepository.findAllByYearOfPublicationIn(yop);
//        }
//        return bookList;
//    }

    public List<Book> getBooks(Set<Integer> yop, String bookType) {

        List<Book> bookList = new ArrayList<>();

        if(yop == null) {
            bookRepository.findAll()
                    .forEach(book -> bookList.add(book));
        } else {
            return bookRepository.findAllByYearOfPublicationInAndBookType(yop, bookType);
        }
        return bookList;
    }

    // Create - POST
    public Book createBook(Book book) {
        // validate
        // return bookRepository.save(book);
        return bookRepository.save(book);
    }

    // Get Single Resource - Get One
//    public Optional<Book> getBookById(Long book) {
//        return bookRepository.findById(book);
//    }
    public BookDTO getBookById(Long bookId, boolean authorData) {

        Book books;
        List<BookAuthor> bookAuthors = null;

        books = bookRepository.getOne(bookId);

        if (authorData) {
            bookAuthors = bookAuthorRepository.findAllByBookId(bookId);
        }

        BookDTO bookDTO = new BookDTO();

            bookDTO.setId(books.getId());
            bookDTO.setName(books.getName());
            bookDTO.setDescription(books.getDecription());
            bookDTO.setYearOfPublication(books.getYearOfPublication());
            bookDTO.setBookType(books.getBookType());
            bookDTO.setPrice(books.getPrice());

            List<AuthorDTO> authorDTOList = new ArrayList<>();
        if (bookAuthors != null) {
                for (BookAuthor bookAuthor : bookAuthors) {
                    Author author = bookAuthor.getAuthor();

                    AuthorDTO authorDTO = new AuthorDTO();

                    authorDTO.setId(author.getId());
                    authorDTO.setName(author.getName());
                    authorDTO.setGender(author.getGender());

                    authorDTOList.add(authorDTO);
                }
            bookDTO.setAuthors(authorDTOList);
            }
            return bookDTO;
        }


    // Update Single Resource    - PUT
    public Book updateBook(Book incomingBook) {
        return bookRepository.save(incomingBook);
    }

    // DELETE
    public Book deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
        return  null;
    }

    // Raw Query - get Books
//    public List<Book> getBooksByRawQuery(Set<Integer> yop) {
////        List<Book> bookRepository.getBookByYop(yop);
//        List<Book> bookList = bookRepository.findAllByYearOfPublicationIn(yop);
//        return bookList;
//    }
        public APIResponse getBooksByRawQuery(Set<Integer> yop) {
    //        List<Book> bookRepository.getBookByYop(yop);
            APIResponse apiResponse = new APIResponse();

            // db call
            List<Book> bookList = bookRepository.findAllByYearOfPublicationIn(yop);

//            Map data = new HashMap();
//            data.put("books", bookList);

            // set data
            BookData bookData = new BookData();
            bookData.setBooks(bookList);

//            bookData.setBook();
            // set api response
//            apiResponse.setData(bookList);
            apiResponse.setError(300);
            apiResponse.setData(bookData);

            return apiResponse;
        }

    public APIResponse getCaughtException(Integer yop) {

        int result = 100/yop;

        APIResponse response = new APIResponse();
        response.setData(result);
        return response;
    }
}
