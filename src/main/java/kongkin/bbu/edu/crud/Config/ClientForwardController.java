package kongkin.bbu.edu.crud.Config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientForwardController {
    @GetMapping(value = "/**/{path:[^\\.]*}")
    public String forward() {
        // Forward all non-file routes to the index.html
        return "forward:/";
    }
}
