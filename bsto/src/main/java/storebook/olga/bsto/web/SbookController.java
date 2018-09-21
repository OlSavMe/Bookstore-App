package storebook.olga.bsto.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import storebook.olga.bsto.domain.SbookRepository;



@Controller
public class SbookController {
	@Autowired
	private SbookRepository repository;
	
	
	@RequestMapping(value="/booklist", method=RequestMethod.GET)
    public String bookList(Model model) {
    	

        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
	

}




