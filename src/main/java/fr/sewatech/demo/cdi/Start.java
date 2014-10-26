package fr.sewatech.demo.cdi;

import fr.sewatech.demo.cdi.event.SomeBean;
import org.jboss.weld.environment.se.StartMain;

import javax.enterprise.inject.spi.CDI;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Alexis Hassler
 */
public class Start {
    public static void main(String[] args) throws IOException {
        Logger.getLogger("").setLevel(Level.SEVERE);

        System.out.println("===========================================================================================");
        StartMain.main(args);

        SomeBean obj = CDI.current().select(SomeBean.class).get();
        System.out.println("main=" + obj);

        System.exit(0);
    }
}
