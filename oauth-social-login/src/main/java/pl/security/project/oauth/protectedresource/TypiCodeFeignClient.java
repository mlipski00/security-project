package pl.security.project.oauth.protectedresource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.security.project.oauth.ClientConfiguration;

import java.util.List;

@FeignClient(value = "jplaceholder",
    url = "https://jsonplaceholder.typicode.com/",
    configuration = ClientConfiguration.class)
public interface TypiCodeFeignClient {

  @RequestMapping(method = RequestMethod.GET, value = "/posts")
  List<Post> getPosts();
}