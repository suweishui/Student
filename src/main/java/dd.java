import com.entity.Admin;

import java.util.HashMap;
import java.util.Map;

public class dd<T> {
    private T data;
    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static void main(String[] args) {
        Class<?> clazz = Admin.class;
    }
}
