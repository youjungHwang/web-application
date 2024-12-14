package di;

import static org.reflections.ReflectionUtils.getAllConstructors;

import annotation.Inject;
import org.reflections.util.ReflectionUtilsPredicates;
import java.lang.reflect.Constructor;
import java.util.Set;

public class BeanFactoryUtils {
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Constructor<?> getInjectedConstructor(Class<?> clazz) {
        Set<Constructor> injectedConstructors = getAllConstructors(clazz, ReflectionUtilsPredicates.withAnnotation(Inject.class));
        if (injectedConstructors.isEmpty()) {
            return null;
        }
        return injectedConstructors.iterator().next();
    }
}
