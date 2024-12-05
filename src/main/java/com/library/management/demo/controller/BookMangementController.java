package com.library.management.demo.controller;

import com.library.management.demo.model.Book;
import com.library.management.demo.service.BookManagementInterface;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/u1")
public class BookMangementController {

    private final BookManagementInterface bookManagementInterface;

    BookMangementController(BookManagementInterface bookManagementInterface) {
        this.bookManagementInterface = bookManagementInterface;
    }

    @GetMapping({"/library"})
    public List<Book> getAllBooks(){
         return bookManagementInterface.getAllBooks();

    }
    @GetMapping({"/library/{bookId}"})
public Book getBookByBookId(@PathVariable Integer bookId){
        return bookManagementInterface.getBookByBookId(bookId);
    }
@PostMapping({"/library"})
    public Book addBooks(@RequestBody Book book){
        return bookManagementInterface.addBooks(book);
}
@PutMapping({"/library/{bookId}"})
   public Book editBook(@RequestBody Book book,@PathVariable Integer bookId){
    return bookManagementInterface.editBook(book,bookId);
    }
@DeleteMapping({"/library/{bookId}"})
    public String deleteBook(@PathVariable Integer bookId){
        return bookManagementInterface.deleteBook(bookId);
}
}
