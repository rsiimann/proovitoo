package webclient;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author Rauno Siimann
 *
 */

@Controller
public class ClientController {

    @RequestMapping(value="/")
    public String getIndex() {
        return "index";
    }
}
