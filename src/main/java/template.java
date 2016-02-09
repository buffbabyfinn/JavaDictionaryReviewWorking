import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class template {
  public static void main( String[] args ) {
    staticFileLocation("/public");

    // System.out.println( "Hello World!" );

    get("/", (request, response) -> {
      return new ModelAndView(new HashMap(), "templates/hello.vtl");
    }, new VelocityTemplateEngine());
    };
  }
}
