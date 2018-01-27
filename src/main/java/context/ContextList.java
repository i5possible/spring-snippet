package context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author lianghong
 * @date 27/01/2018
 */
public class ContextList {

    public ApplicationContext getAnnotationConfigApplicationContext() {
        new AnnotationConfigApplicationContext(ContextList.class);
        return new AnnotationConfigApplicationContext("context");
    }

    public ApplicationContext getFileSystemXmlApplicationContext() {
        FileSystemXmlApplicationContext applicationContext =
                new FileSystemXmlApplicationContext("/opt/config/knight.xml");
        new FileSystemXmlApplicationContext(applicationContext);
        new FileSystemXmlApplicationContext("location1", "location2", "location3");
        new FileSystemXmlApplicationContext(new String[]{"location"}, applicationContext);
        return new FileSystemXmlApplicationContext(new String[]{"location"}, false, applicationContext);
    }

    public ApplicationContext getClassPathXmlApplicationContext() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("path1", "path2");
        new ClassPathXmlApplicationContext(applicationContext);
        new ClassPathXmlApplicationContext("location1", "location2", "location3");
        return new ClassPathXmlApplicationContext(new String[]{"location"}, false, applicationContext);
    }

    public ApplicationContext getXmlApplicationContext() {
        return new GenericXmlApplicationContext();
    }

    public ApplicationContext getAnnotationConfigWebApplicationContext() {
        return null;
    }

    public ApplicationContext getElseApplicationContext() {
        return null;
    }
}
