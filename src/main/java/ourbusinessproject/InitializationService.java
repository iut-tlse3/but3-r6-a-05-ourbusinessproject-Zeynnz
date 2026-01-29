package ourbusinessproject;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitializationService {

    private Enterprise e1;
    private Enterprise e2;
    private Project p1;
    private Project p2;
    private Project p3;

    @Autowired
    private EnterpriseProjectService enterpriseProjectService;


    @Transactional
    public void initProjects() {

       this.e1 = enterpriseProjectService.newEnterprise(
                "Chasseneige",
                "Ceci est une description parfaite pour une enterprise",
               "Jean Ladalle",
                "ladalle@gmail.com"

        );
        this.e2 = enterpriseProjectService.newEnterprise(
                "Tellement vrai",
                "Ceci est une description parfaite pour une enterprise si vrai",
                "Tellement Vrai",
                "tellementvrai@gmail.com"
        );

        this.p1 = enterpriseProjectService.newProject(
                "projet 1",
                "Description du projet 1",
                e1
        );

        this.p2 = enterpriseProjectService.newProject(
                "projet 2",
                "Description du projet 2",
                e2
        );
        this.p3 = enterpriseProjectService.newProject(
                "projet 3",
                "Description du projet 3",
                e1
        );
    }

    public Project getProject1E1() {
        return p1;
    }

    public Project getProject1E2() {
        return p2;
    }

    public Project getProject2E1() {
        return p3;
    }

    public Enterprise getEnterprise1() {
        return e1;
    }

    public Enterprise getEnterprise2() {
        return e2;
    }
}
