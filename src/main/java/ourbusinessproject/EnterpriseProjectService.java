package ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    public EnterpriseProjectService() {}

    /**
     * Create a new EnterpriseProjectService initialized with an entity manager
     * @param entityManager the entity manager
     */
    public EnterpriseProjectService(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    /**
     * Create a new project
     * @param aTitle       the title of the new project
     * @param aDescription the description of the new project
     * @param enterprise   the enterprise
     * @return the created project
     */
    public Project newProject(String aTitle, String aDescription, Enterprise enterprise) {
        Project newProject = new Project();
        newProject.setTitle(aTitle);
        newProject.setDescription(aDescription);
        newProject.setEnterprise(enterprise);
        this.entityManager.persist(newProject);
        this.entityManager.flush();
        newProject.getEnterprise().addProject(newProject);
        return newProject;
    }

    /**
     *
     * @return the entity manager
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * Find a project by its id
     * @param anId the id of the project
     * @return the project with the right id
     */
    public Project findProjectById(Long anId) {
        return entityManager.find(Project.class, anId);
    }

    /**
     * Find an enterprise by its id
     * @param anId the id of the enterprise
     * @return the enterprise with the right id
     */
    public Enterprise findEnterpriseById(Long anId) {
        return entityManager.find(Enterprise.class, anId);
    }

    /**
     * Create a new enterprise
     * @param aName the name of the enterprise
     * @param aDescription the description of the enterprise
     * @param aContactName the name of the contact
     * @param mail the mail of the contact
     * @return the new enterprise
     */
    public Enterprise newEnterprise(
            String aName,
            String aDescription,
            String aContactName,
            String mail
    ) {
        Enterprise newEnterprise = new Enterprise();
        newEnterprise.setName(aName);
        newEnterprise.setDescription(aDescription);
        newEnterprise.setContactName(aContactName);
        newEnterprise.setContactEmail(mail);
        this.entityManager.persist(newEnterprise);
        this.entityManager.flush();
        return newEnterprise;
    }

    public List<Project> findAllProjects() {
        String query = "SELECT p FROM Project p ORDER BY p.title";
        TypedQuery<Project> queryObj = entityManager.createQuery(query, Project.class);
        return  queryObj.getResultList();
    }
}
