package su.hil.api.tools;

public interface IRequestAPI<T extends IResponseMessage> {
    Class<T> getResponseClass();

    String getUrl();

    RequestMethod getMethod();

    Object getData();
}