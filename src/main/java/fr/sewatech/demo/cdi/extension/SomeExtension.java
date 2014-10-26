package fr.sewatech.demo.cdi.extension;

import fr.sewatech.demo.cdi.event.SomeBean;
import org.apache.deltaspike.core.api.provider.BeanProvider;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.BeforeShutdown;
import javax.enterprise.inject.spi.Extension;

/**
 * @author Alexis Hassler
 */
public class SomeExtension implements Extension {

    public void afterDeploymentValidation(@Observes AfterDeploymentValidation afterDeploymentValidation, BeanManager beanManager) {
        SomeBean obj = BeanProvider.getContextualReference(beanManager, SomeBean.class, false);
        System.out.println("AfterDeploymentValidation=" + obj);
    }

    public void beforeShutdown(@Observes BeforeShutdown beforeShutdown, BeanManager beanManager) {
        SomeBean obj = BeanProvider.getContextualReference(beanManager, SomeBean.class, false);
        System.out.println("BeforeShutdown=" + obj);
        System.out.println("===========================================================================================");
    }

}
