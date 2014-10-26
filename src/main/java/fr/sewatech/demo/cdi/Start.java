package fr.sewatech.demo.cdi;

import fr.sewatech.demo.cdi.event.SomeBean;
import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.core.api.provider.BeanProvider;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Alexis Hassler
 */
public class Start {
    public static void main(String[] args) throws Exception {
        Logger.getLogger("").setLevel(Level.SEVERE);

        System.out.println("===========================================================================================");

        CdiContainer cdiContainer = CdiContainerLoader.getCdiContainer();
        cdiContainer.boot();
        cdiContainer.getContextControl().startContexts();

        SomeBean obj = BeanProvider.getContextualReference(SomeBean.class, false);
        System.out.println("main=" + obj);

        cdiContainer.shutdown();
    }

}
