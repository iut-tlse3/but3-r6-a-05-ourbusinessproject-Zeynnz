package ourbusinessproject;

import jakarta.validation.constraints.NotNull;

import java.util.Date;


public class Partnership {

    @NotNull
    private Enterprise enterprise;

    @NotNull
    private Date creationDate;

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
}
