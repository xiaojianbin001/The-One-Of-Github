package a.b.controller;

import a.b.pojo.Books;
import a.b.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jean.K
 * @TIME 2022/2/24 16:24
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook1";
    }

    @RequestMapping("/toAddBook")
    public String toAddBook(Model model) {
        return "addBook";
    }
    @RequestMapping("/addBook")
    public String addBook(Books books){
        bookService.addBook(books);
        System.out.println("新增书籍:"+books);
        return "redirect:/book/allBook";//重定向到方法，通过方法调用返回到allBook1页面
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("books",books);
        return "updateBook";
    }
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        bookService.updateBook(books);
        System.out.println("the book is :"+books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/queryBookByName")
    public String queryBookByName(String bookName,Model model){
        Books books = bookService.queryBookByName(bookName);
        System.out.println("查询到的书籍"+books);
        List<Books> list =new ArrayList<Books>();
        list.add(books);
        if(books==null){
            list=bookService.queryAllBook();
        }
        model.addAttribute("list", list);
        return "allBook1";
    }

}
