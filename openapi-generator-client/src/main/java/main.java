import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.openapitools.client.ApiClient;
import org.openapitools.client.api.UserApi;
import org.openapitools.client.model.Response;
import org.openapitools.client.model.User;

public class main {
    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        // 拦截器, 设定content-type等header字段, 这里主要做个演示
        client.getFeignBuilder().requestInterceptor(new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                template.header("Content-type","application/json");
            }
        });
        client.setBasePath("http://localhost:23456/api");
        UserApi api = client.buildClient(UserApi.class);
        User u = new User();
        u.setUserName("Mike");
        u.setUserNumber("12345677");
        u.setId(1L);
        Response resp = api.saveUser(u);
        System.out.println(resp.toString());
    }
}
