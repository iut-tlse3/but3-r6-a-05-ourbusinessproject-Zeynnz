package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Enterprise {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotBlank
    private String name;

    @Size(min = 10)
    private String description;

    @NotBlank
    private String contactName;

    @NotBlank
    @Email
    private String contactEmail;

    @OneToMany(mappedBy = "enterprise")
    private Collection<Project> projects;


    public Enterprise() {
    }

    /**
     * set the name
     * @param name the name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     *
     * @return the name
     */
    public String getName(){
        return name;
    }

    /**
     * set the description
     * @param compDescription the description
     */
    public void setDescription(String compDescription) {
        this.description = compDescription;
    }

    /**
     *
     * @return the description
     */
    public String getDescription(){
        return description;
    }

    /**
     * set the Contact name
     * @param paulDurand the contact name
     */
    public void setContactName(String paulDurand) {
        this.contactName = paulDurand;
    }

    /**
     *
     * @return the contact name
     */
    public String getContactName(){
        return contactName;
    }

    /**
     * set the Contact email
     * @param mail the email
     */
    public void setContactEmail(String mail) {
        this.contactEmail = mail;
    }

    /**
     *
     * @return the contact email
     */
    public String getContactEmail(){
        return contactEmail;
    }

    /**
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    public Collection<Project> getProjects() {
        return this.projects;
    }

    /**
     * Add a project
     * @param project the project
     */
    public void addProject(Project project) {
        if (this.projects == null){
            this.projects = new ArrayList<>();
        }
        this.projects.add((project));
    }
}