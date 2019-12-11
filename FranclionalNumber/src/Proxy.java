import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy implements InvocationHandler {
    private Interface obj;

    public Proxy(Interface obj) {
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().contains("set")) {
            throw new IndexOutOfBoundsException("method set");
        } else
            return method.invoke(obj, args);
    }
}