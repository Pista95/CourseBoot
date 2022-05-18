package hu.uni.miskolc.lev.java.CourseBoot.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetAllController {
    @GetMapping(value = "/getAll", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String welcomeAsHTML() {
        return "<html>\n" + "<header><title>getAll</title></header>\n" +
                "<body>\n" + "Student tábla listázása\n" + "</body>\n" + "</html>";
    }
}
