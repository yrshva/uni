import java.lang.reflect.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Fraction obj = new Fraction(1, 1);
        Class[] paramsFraction = {double.class, double.class};
        Constructor constructorFraction = Fraction.class.getConstructor(paramsFraction);
        Class[] paramsFractionalComplex = {double.class, double.class};
        Constructor constructorFractionalComplex = FractionalComplex.class.getConstructor(paramsFractionalComplex);
        System.out.println(obj.getClass().getModifiers());
        System.out.println(obj.getClass().getDeclaredFields()[1].getName());

        StringBuilder sb = new StringBuilder("\n Calling methods with annotation\n");


        for (Method m : obj.getClass().getDeclaredMethods()) {
            if (m.isAnnotationPresent(Command.class) && m.getParameterTypes().length == 0) {
                Object result = null;
                try {
                    result = m.invoke(obj);
                } catch (IllegalAccessException | InvocationTargetException ex) {
                    ex.printStackTrace();
                }
                sb.append(result);
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
        Proxy handler = new Proxy((Interface) obj);
        Interface proxy = (Interface) java.lang.reflect.Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                handler);
        try {
            proxy.getFraction();
            proxy.setFractionalComplex();
        } catch (Exception e) {
            e.printStackTrace();
        }    }
}


