package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String title;

    private String description;

    @NotNull
    @ManyToOne
    private Enterprise enterprise;


    /**
     *
     * @return the enterprise
     */
    public Enterprise getEnterprise() {
        return enterprise;
    }

    /**
     * Set the title
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the description
     * @param projectDescription the description
     */
    public void setDescription(String projectDescription) {
        this.description = projectDescription;
    }

    /**
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * set the enterprise
     * @param enterprise the enterprise
     */
    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
}
