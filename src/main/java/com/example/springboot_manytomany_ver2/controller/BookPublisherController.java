package com.example.springboot_manytomany_ver2.controller;

import com.example.springboot_manytomany_ver2.entity.BookEntity;
import com.example.springboot_manytomany_ver2.entity.Book_Pulisher;
import com.example.springboot_manytomany_ver2.entity.Publisher;
import com.example.springboot_manytomany_ver2.service.BookService;
import com.example.springboot_manytomany_ver2.service.Book_PublisherService;
import com.example.springboot_manytomany_ver2.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookPublisherController {
    @Autowired
    private BookService bookService;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private Book_PublisherService bookPublisherService;

    // Get data
    @GetMapping("/getbook")
    public ResponseEntity<?> getAllBook() {
        List<BookEntity> list = bookService.getAllBook();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/getpublisher")
    public ResponseEntity<?> getAllPublisher() {
        List<Publisher> list = publisherService.getAllPublisher();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAllBookPublisher() {
        List<Book_Pulisher> list = bookPublisherService.getAllBook_publisher();
        return ResponseEntity.ok().body(list);
    }

    // Add data
    @PostMapping("/add-book")
    @Transactional
    public ResponseEntity<?> addBook(@RequestBody BookEntity bookEntity) {
        return ResponseEntity.ok().body(bookService.addBook(bookEntity));
    }

    @PostMapping("/add-book-publisher")
    @Transactional
    public ResponseEntity<?> addBookPublisher(@RequestBody Book_Pulisher bookPulisher) {
        return ResponseEntity.ok().body(bookPublisherService.addBookPulisher(bookPulisher));
    }

}

