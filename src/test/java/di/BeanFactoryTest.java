package di;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import annotation.Controller;
import annotation.Service;
import controller.UserController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class BeanFactoryTest {
    private Reflections reflections;
    private BeanFactory beanFactory;

    @BeforeEach
    void setUp() {
        reflections = new Reflections();
        Set<Class<?>> preInstantiatedClazz = getTypesAnnotatedWith(Controller.class, Service.class);
        beanFactory = new BeanFactory(preInstantiatedClazz);

    }

    private Set<Class<?>> getTypesAnnotatedWith(Class<? extends Annotation>... annotations) {
        return Arrays.stream(annotations)
                .flatMap(annotation -> reflections.getTypesAnnotatedWith(annotation).stream())
                .collect(Collectors.toSet());
    }

    @Test
    public void diTest() {
        UserController userController = beanFactory.getBean(UserController.class);
        assertNotNull(userController.getUserService());
    }
}