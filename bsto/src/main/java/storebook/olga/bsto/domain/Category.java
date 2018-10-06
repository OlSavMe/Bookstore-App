package storebook.olga.bsto.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Sbook> sbooks;
	
	public Category() {}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Sbook> getSbooks() {
		return sbooks;
	}

	public void setSbooks(List<Sbook> sbooks) {
		this.sbooks = sbooks;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", name=" + name + "]";
	}
	
	

}
