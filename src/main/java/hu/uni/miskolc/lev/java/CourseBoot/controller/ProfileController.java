package hu.uni.miskolc.lev.java.CourseBoot.controller;

import hu.uni.miskolc.lev.java.CourseBoot.model.entity.Profile;
import hu.uni.miskolc.lev.java.CourseBoot.service.ProfileService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    /*
    @GetMapping("getAllProfile")
    @ResponseBody
    public List<Profile> getAllProfile(){
        return profileService.getAllProfile();
     */

    @GetMapping(value = "/getProfile", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String ProfileAsHTML( int profile_id) {
        return profileService.getProfileByid(profile_id);
    }
}