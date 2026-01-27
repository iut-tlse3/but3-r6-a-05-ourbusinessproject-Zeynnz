package ourbusinessproject;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Project {

    @NotEmpty
    private String title;

    private String description;

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
}
