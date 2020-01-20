package com.wildcodeschool.wildandwizard.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Wizard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String birthPlace;
    private String biography;
    private boolean muggle;
    
    
    @ManyToMany
    @JoinTable(name = "wizard_course",
    		joinColumns = @JoinColumn(name = "wizard_id"),
    		inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses = new ArrayList<>();
    
    /*
     * 
     @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
    
    =======
    @OneToMany(mappedBy = "school")
    public List<Wizard> wizards;
    
    // additional information:
/*    
    -->
    You notice that the class School will contain a reference to a list of Wizards. It will
    therefore be necessary to create getters and setters for it.
    
    Here, mappedBy contains the value "school": it refers to the attribute school of the
    class Wizard.
    
    To be read carefully: you must give the attribute the name you want to attach to the
    value of mappedBy. For example if in Wizard the name of the attribute was School foo, it
    would be necessary to write mappedBy = "foo" in the class Wizard.
    
    When recovering a school, it is now possible to have all the wizards associated with it:
    
    
    */

    public Wizard() {
    }

    // getter & setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public boolean isMuggle() {
        return muggle;
    }

    public void setMuggle(boolean muggle) {
        this.muggle = muggle;
    }

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}