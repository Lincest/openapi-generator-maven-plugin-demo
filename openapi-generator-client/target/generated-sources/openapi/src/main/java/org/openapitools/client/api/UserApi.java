package org.openapitools.client.api;

import org.openapitools.client.ApiClient;
import org.openapitools.client.EncodingUtils;

import org.openapitools.client.model.Response;
import org.openapitools.client.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-07-22T01:43:59.373+08:00[Asia/Shanghai]")
public interface UserApi extends ApiClient.Api {


  /**
   * save user
   * return init password
   * @param user  (required)
   * @return Response
   */
  @RequestLine("POST /user/save")
  @Headers({
    "Content-Type: */*",
    "Accept: application/json",
  })
  Response saveUser(User user);
}
