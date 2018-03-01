package kisslinux.memento.status;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 属性 工具类
 * @author 庄壮壮 Administrator
 * @since 2018-03-01 16:02
 */
public class MementoStatusBeanUtils {

    public static Map<String, Object> backupProp(Object bean) {
        Map<String, Object> result = new HashMap<>();

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor descriptor : descriptors) {
                String fieldName = descriptor.getName();
                Method getter = descriptor.getReadMethod();
                Object fieldValue = getter.invoke(bean);

                if (!fieldName.equalsIgnoreCase("class")) {
                    result.put(fieldName, fieldValue);
                }
            }
        } catch (IntrospectionException
                | IllegalAccessException
                | InvocationTargetException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void restoreProp(Object bean, Map<String, Object> propMap) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor descriptor : descriptors) {
                String fieldName = descriptor.getName();
                if (propMap.containsKey(fieldName)) {
                    Method setter = descriptor.getWriteMethod();
                    setter.invoke(bean, propMap.get(fieldName));
                }
            }
        } catch (IntrospectionException
                | IllegalAccessException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
