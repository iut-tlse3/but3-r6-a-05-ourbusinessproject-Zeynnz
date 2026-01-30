package ourbusinessproject;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {

    private final EnterpriseProjectService enterpriseProjectService;

    public ProjectController(EnterpriseProjectService enterpriseProjectService) {

        this.enterpriseProjectService = enterpriseProjectService;
    }

    /**
     * all projects with the associated enterprises
     * @return the project
     */
    @RequestMapping("/projects")
    public List<Project> findAllProjectsWithEnterprises() {
        return  enterpriseProjectService.findAllProjects();
    }
}
