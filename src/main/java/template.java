import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class template {
  public static void main( String[] args ) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    // System.out.println( "Hello World!" );

    get("/", (request, response) -> {
        HashMap model = new HashMap();
        model.put("template", "templates/hello.vtl" );

        return new ModelAndView(model, "templates/layout.vtl");
      }, new VelocityTemplateEngine());
    };

    get("/other", (request, response) -> {
        HashMap model = new HashMap();
        model.put("template", "templates/other.vtl" );

        return new ModelAndView(model, "templates/layout.vtl");
      }, new VelocityTemplateEngine());
    };
  }
}
