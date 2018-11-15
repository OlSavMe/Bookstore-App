package storebook.olga.bsto.web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import storebook.olga.bsto.domain.Sbook;
import storebook.olga.bsto.domain.SbookRepository;
import storebook.olga.bsto.domain.CategoryRepository;



@Controller
public class SbookController {
	@Autowired
	private SbookRepository repository;
	
	@Autowired
	private CategoryRepository catrepository;
	 @RequestMapping(value="/login")
	    public String login() {	
	        return "login";
	    }
	
	
	@RequestMapping(value="/booklist", method=RequestMethod.GET)
    public String bookList(Model model) {
    	model.addAttribute("sbooks", repository.findAll());
        return "booklist";
        
    }
	
	
	//RESTfull to get all books
	@RequestMapping(value="/sbooks", method = RequestMethod.GET)
	public @ResponseBody List<Sbook> sbookListRest() {
	return (List<Sbook>) repository.findAll();
	}
	
	
	// RESTful to get sbook by id
    @RequestMapping(value="/sbook/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Sbook> findSbookRest(@PathVariable("id") Long sbookId) {	
    	return repository.findById(sbookId);
    } 
	
	
	
	@RequestMapping(value = "/add")
	public String addBook(Model model){
	model.addAttribute("sbook", new Sbook());
	model.addAttribute("categories", catrepository.findAll());
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
	public String editBook(@PathVariable("id") Long sbookId, Model model){
	model.addAttribute("sbook", repository.findById(sbookId));
	model.addAttribute("categories", catrepository.findAll());
	return "editbook";
	}

}




