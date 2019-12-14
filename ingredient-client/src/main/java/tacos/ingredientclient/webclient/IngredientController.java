package tacos.ingredientclient.webclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ingredients")
@Slf4j
public class IngredientController {

    private IngredientServiceClient client;

    public IngredientController(final IngredientServiceClient client) {
        this.client = client;
    }

    @GetMapping
    public String ingredientList(final Model model) {
        log.info("Fetched all ingredients from a WebClient-based service.");
        model.addAttribute("ingredients", client.getAllIngredients());
        return "ingredientList";
    }

    @GetMapping("/{id}")
    public String ingredientDetailPage(@PathVariable("id") final String id, final Model model) {
        log.info("Fetched an ingredient from a WebClient-based service.");
        model.addAttribute("ingredient", client.getIngredientById(id));
        return "ingredientDetail";
    }
}