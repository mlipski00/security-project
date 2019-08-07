package pl.security.project.resource.one.oauthresourceone.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class nonProtectedController {

  @GetMapping(name = "$non.protected.endpoint.one")
  public String getExampleNonProtectedResource() {
    return "Response from non protected endpoint one";
  }
}
