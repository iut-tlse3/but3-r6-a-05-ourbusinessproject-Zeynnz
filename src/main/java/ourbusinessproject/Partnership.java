package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Partnership {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @NotNull
    private Enterprise enterprise;

    @NotNull
    private Date creationDate;

    @ManyToOne
    @NotNull
    private Project project;

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setProject(Project project) {
    this.project = project;
    }

    public Enterprise getEnterprise() { return this.enterprise;}

    public Date getCreationDate(){ return this.creationDate;}

    public Project getProject() {return this.project;}

    public Long getId() {return this.id;}
}
