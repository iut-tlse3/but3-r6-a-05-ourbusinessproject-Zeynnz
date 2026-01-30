package ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import java.util.Date;


@Service
public class PartnershipService {

    @PersistenceContext
    private EntityManager entityManager;

    public PartnershipService() {}

    public Partnership newPartnership(Project project, Enterprise partnerEnterprise) {
        Partnership newPartnership = new Partnership();
        newPartnership.setCreationDate(new Date());
        newPartnership.setProject(project);
        newPartnership.setEnterprise(partnerEnterprise);
        this.entityManager.persist(newPartnership);
        this.entityManager.flush();
        return newPartnership;
    }


    public Partnership findPartnershipById(Long id){
        return entityManager.find(Partnership.class ,id);
    }

    public void remove(Partnership partnership) {
        entityManager.remove(partnership);
    }
}
