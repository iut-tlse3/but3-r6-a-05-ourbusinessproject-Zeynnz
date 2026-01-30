package ourbusinessproject;


import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class Bootstrap {


    private static final Logger logger = LoggerFactory.getLogger(Bootstrap.class);

    private final InitializationService initializationService;

    public Bootstrap(InitializationService initializationService) {
        this.initializationService = initializationService;
    }

    /**
     * init for some values
     */
    @PostConstruct
    public void init() {
        try {
            this.initializationService.initProjects();
            this.initializationService.initPartnerships();
        } catch (RuntimeException re){
            logger.error("Error during initialization",re);
        }
    }

    /**
     *
     * @return the initialization service
     */
    public InitializationService getInitializationService() {
        return this.initializationService;
    }
}
