package pl.security.project.oauth.protectedresource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.security.project.oauth.ClientConfiguration;

@FeignClient(
    value = "ResourceFeignClient",
    url =" ${non.protected.endpoint.one}",
    configuration = ClientConfiguration.class,
    fallback = ResourceFeignClient.ResourceFeignClientFallback.class
)
public interface ResourceFeignClient {

  @RequestMapping(method = RequestMethod.GET, value = "/restresource")
  String getResourcePage();

  @RestController
  class ResourceFeignClientFallback implements ResourceFeignClient {

    private static final String RESOURCE_FALLBACK_MESSAGE = "Something failed. Rest resource fallback message - feign client.";

    @Override
    public String getResourcePage() {
      return RESOURCE_FALLBACK_MESSAGE;
    }
  }
}
