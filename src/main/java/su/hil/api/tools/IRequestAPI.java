package su.hil.api.tools;

public interface IRequestAPI<T> {
    Class<T> getResponseClass();

    String getUrl();

    RequestMethod getMethod();

    Object getData();
}