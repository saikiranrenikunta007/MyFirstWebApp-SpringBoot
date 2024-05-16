package com.in28minutes.springboot.MyFirstWebApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class HelloController {
    @RequestMapping("onemuthoot.com")
    @ResponseBody
    public String sayGreeting()
    {
        return "Hi! Welcome to One Muthoot.";
    }
    @RequestMapping("/html/onemuthoot.com")
    public @ResponseBody  String sayGreetingHtml()
    {
        StringBuffer sb = new StringBuffer();

        sb.append("<html>");
        sb.append(" <head>");
        sb.append(" <title>Rcb Sponsored</title>");
        sb.append("<h1>Greetings from OneMuthoot</h1>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("</body>");
        sb.append("</html>\n");
        return sb.toString();
    }
    @RequestMapping("one")
    public String sayGreetingjsp()
    {
        return "sayHello";
    }

}
