package pl.security.project.oauth.protectedresource;

import org.springframework.stereotype.Component;

@Component
class ResourceFeignClientFallback implements ResourceFeignClient {

  private static final String RESOURCE_FALLBACK_MESSAGE = "Something failed. Rest resource fallback message - feign client.";

  @Override
  public String getResourcePage() {
    return RESOURCE_FALLBACK_MESSAGE;
  }
}