package pl.security.project.oauth.protectedresource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestResourceController {

  @Autowired
  TypiCodeFeignClient typiCodeFeignClient;

  @RequestMapping("/posts")
  List<Post> getPostFromTypiCode() {
    return typiCodeFeignClient.getPosts();
  }

}
