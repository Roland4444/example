import spark.ModelAndView;
import spark.Spark;
import spark.Spark.*;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Spark.port(9000);
        Spark.staticFileLocation("/");
        Spark.get("/hello", (request, response) -> "Hello Friend!");
        Spark.get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, "1.html")
            );
        });
    }
}