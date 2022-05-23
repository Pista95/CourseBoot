package hu.uni.miskolc.lev.java.CourseBoot.controller;

import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.Course;
import hu.uni.miskolc.lev.java.CourseBoot.service.CourseService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {
    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    // Kurzus felvétel
    @PostMapping("addCourse")
    @ResponseBody
    public void addCourse(@RequestBody Course course){
        courseService.addCourse(course);
        System.out.println(course.toString());
    }

    @PostMapping("deleteCourse")
    @ResponseBody
    public void deleteCourseById(@RequestParam int id){
        courseService.deleteCourse(id);
        //System.out.println(course.toString());
    }

    @GetMapping(value = "/getAllCourse", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String StudentAsHTML() {
        String result;
        if (courseService.getAllCourse().size() == 0) {
            result= "<html>\n" + "<header><title>getAllCourse</title></header>\n" +
                    "<body>\n" + "Course táblában nincs rekord!\n" +
                    "</body>\n" + "</html>";
        } else {
            result= "<html><header><title>getAllCourse</title></header><body>";
            result+="Course ( rekordok száma: " + courseService.getAllCourse().size()+")<br><table align='center' border='1'>" +
                    "<th>Course id</th><th>Course név</th><th>Törlés</th>";
            for(int i=0; i<courseService.getAllCourse().size(); i++) {
                result += "<tr><td>"+courseService.getAllCourse().get(i).getCourse_id()+"</td>" +
                        "<td><input value='"+courseService.getAllCourse().get(i).getName()+"'></td>" +
                      "<td><button onclick='sendJsonToDeleteCourse(this.id,9)' id='"+courseService.getAllCourse().get(i).getCourse_id()+"'>Törlés</button></td>";
            }
            result+="<tr><table></body></html>";
        }
        return result;
    }
}