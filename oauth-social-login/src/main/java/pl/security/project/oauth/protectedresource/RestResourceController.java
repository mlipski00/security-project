package pl.security.project.oauth.protectedresource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.security.project.oauth.protectedresource.typicodepost.Post;

import java.util.List;

@RestController
public class RestResourceController {

  TypiCodeFeignClient typiCodeFeignClient;
  ResourceFeignClient resourceFeignClient;

  public RestResourceController(TypiCodeFeignClient typiCodeFeignClient, @Qualifier("default") ResourceFeignClient resourceFeignClient) {
    this.typiCodeFeignClient = typiCodeFeignClient;
    this.resourceFeignClient = resourceFeignClient;
  }

  @RequestMapping("/typicode")
  List<Post> getPostFromTypiCode() {
    return typiCodeFeignClient.getPosts();
  }

  @RequestMapping("/restresource")
  String getRestResource() {
    return resourceFeignClient.getResourcePage();
  }

}
