package tacos.ingredientclient.resttemplate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ingredients")
@Slf4j
@Profile("resttemplate")
public class IngredientController {

    private IngredientServiceClient client;

    public IngredientController(IngredientServiceClient client) {
        this.client = client;
    }

    @GetMapping
    public String showAllIngredients(Model model) {
        log.info("Fetched all ingredients from a RestTemplate-based service.");
        model.addAttribute("ingredients", client.getAllIngredients());
        return "ingredientList";
    }

    @GetMapping("/{id}")
    public String getIngredientById(@PathVariable("id") String id, Model model) {
        log.info("Fetched an ingredient from a RestTemplate-based service.");
        model.addAttribute("ingredient", client.getIngredientById(id));
        return "ingredientDetail";
    }
}
