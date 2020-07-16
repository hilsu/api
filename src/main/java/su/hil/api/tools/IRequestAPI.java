package su.hil.api.tools;

public interface IRequestAPI<T extends IResponseData> {
    Class<T> getResponseClass();

    String getUrl();

    RequestMethod getMethod();

    Object getData();
}