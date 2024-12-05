package com.library.management.demo.service;

import com.library.management.demo.model.Book;
import com.library.management.demo.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookManagement implements BookManagementInterface {

   private final BookRepository bookRepository;

   BookManagement(BookRepository bookRepository) {
       this.bookRepository = bookRepository;
   }
    @Override
    public Book getBookByBookId(Integer BookId) {
        return bookRepository.findById(BookId).get();
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> BookList = bookRepository.findAll();
        return BookList;
    }
    public Book addBooks(Book book){
        return bookRepository.save(book);
    }
@Override
    public Book editBook(Book book,Integer bookId){
       Book existingBook=bookRepository.findById(bookId).get();

       existingBook.setBookAuthor(book.getBookAuthor() != null ? book.getBookAuthor() : existingBook.getBookAuthor());
       existingBook.setBookName(book.getBookName() != null ? book.getBookName() : existingBook.getBookName());
       existingBook.setQuantity(book.getQuantity() != null ? book.getQuantity() : existingBook.getQuantity());

       return bookRepository.save(existingBook);

    }
    @Override
    public String deleteBook(Integer bookId){

       bookRepository.deleteById(bookId);
       return "data deleted successfully";

    }
}
