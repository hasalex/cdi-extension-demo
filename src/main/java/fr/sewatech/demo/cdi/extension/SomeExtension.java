package fr.sewatech.demo.cdi.extension;

import fr.sewatech.demo.cdi.event.SomeBean;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.*;

/**
 * @author Alexis Hassler
 */
public class SomeExtension implements Extension {

    public void afterDeploymentValidation(@Observes AfterDeploymentValidation afterDeploymentValidation) {
        SomeBean obj = CDI.current().select(SomeBean.class).get();
        System.out.println("AfterDeploymentValidation=" + obj);
    }

    public void beforeShutdown(@Observes BeforeShutdown beforeShutdown) {
        SomeBean obj = CDI.current().select(SomeBean.class).get();
        System.out.println("BeforeShutdown=" + obj);
        System.out.println("===========================================================================================");
    }

}
