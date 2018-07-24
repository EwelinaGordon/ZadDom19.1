package Shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class Cwiczenie {
    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World";
    }

}
