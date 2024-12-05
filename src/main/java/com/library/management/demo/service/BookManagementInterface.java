package com.library.management.demo.service;

import com.library.management.demo.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookManagementInterface {
    Book getBookByBookId(Integer BookId);
    List<Book> getAllBooks();

    Book addBooks(Book book);
    Book editBook(Book book,Integer bookId);
    String deleteBook(Integer bookId);
}
