package pl.security.project.oauth.protectedresource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.security.project.oauth.ClientConfiguration;

@FeignClient(
    value = "ResourceFeignClient",
    url = "http://localhost:8083/",
    configuration = ClientConfiguration.class,
    fallback = ResourceFeignClientFallback.class
)
@Qualifier("default")
public interface ResourceFeignClient {

  @RequestMapping(method = RequestMethod.GET, value = "/nonProtectedEndpointOne")
  String getResourcePage();
}
