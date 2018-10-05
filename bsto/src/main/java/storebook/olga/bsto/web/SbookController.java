package storebook.olga.bsto.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import storebook.olga.bsto.domain.Sbook;
import storebook.olga.bsto.domain.SbookRepository;



@Controller
public class SbookController {
	@Autowired
	private SbookRepository repository;
	
	
	@RequestMapping(value="/booklist", method=RequestMethod.GET)
    public String bookList(Model model) {
    	

   model.addAttribute("sbooks", repository.findAll());
        return "booklist";
    }
	
	@RequestMapping(value = "/add")
	public String addBook(Model model){
	model.addAttribute("sbook", new Sbook());
	return "addbook";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Sbook sbook){
	repository.save(sbook);
	return "redirect:booklist";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long sbookId, Model model) {
	repository.deleteById(sbookId);
	return "redirect:../booklist";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String addBook(@PathVariable("id") Long sbookId, Model model){
	model.addAttribute("sbook", repository.findById(sbookId));
	return "editbook";
	}
	
}




