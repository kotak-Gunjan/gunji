package LoginController;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import LoginBean.LoginBean;

@Controller
public class LoginController {
  @RequestMapping(value = "index.jsp", method = RequestMethod.GET)
  public String init(Model model) {
    model.addAttribute("msg", "Please Enter Your Login Details");
    return "login";
  }

  @RequestMapping(value = "index.jsp", method = RequestMethod.POST)
  public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
    if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
      if (loginBean.getUserName().equals("gunjan") && loginBean.getPassword().equals("123")) {
        model.addAttribute("msg", loginBean.getUserName());
        return "success";
      } else {
        model.addAttribute("error", "Invalid Details");
        return "login";
      }
    } else {
      model.addAttribute("error", "Please enter Details");
      return "login";
    }
  }
}