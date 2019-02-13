package com.manning.readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 王禹展 wyuzhan@163.com
 * @date 2019/2/12  18:28
 */
@Controller
@RequestMapping("/readingList")
public class ReadingListController {
    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository){
        this.readingListRepository =  readingListRepository;
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readerBooks(
            @PathVariable("reader") String reader, Model model){
        List<Book> readingList = readingListRepository.findAllByReader(reader);
        if(readingList != null){
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reder, Book book){
        book.setReader(reder);
        readingListRepository.save(book);
        return "redirect:/readingList/{reader}";
    }
}
