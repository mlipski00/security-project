package pl.security.project.oauth.protectedresource;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResourceController {

  private static final String RESOURCE_FALLBACK_MESSAGE = "Something failed. Resource fallback message.";
  private static final String MESSAGE = "message";
  private static final String RESOURCE_VIEW_NAME = "resource";


  @Value("${non.protected.endpoint.one}")
  private String nonProtectedResourceOneUrl;

  @HystrixCommand(fallbackMethod = "resourceFallback", commandKey = "resource", groupKey = "resource")
  @GetMapping("/resource")
  public ModelAndView getResourcePage() {
    RestTemplate restTemplate = new RestTemplate();
    ModelAndView modelAndView = new ModelAndView(RESOURCE_VIEW_NAME);

    ResponseEntity<String> response
        = restTemplate.getForEntity(nonProtectedResourceOneUrl, String.class);

    modelAndView.addObject(MESSAGE, response);
    return modelAndView;
  }

  public ModelAndView resourceFallback() {
    ModelAndView modelAndView = new ModelAndView(RESOURCE_VIEW_NAME);
    modelAndView.addObject(MESSAGE, RESOURCE_FALLBACK_MESSAGE);
    return modelAndView;
  }
}
