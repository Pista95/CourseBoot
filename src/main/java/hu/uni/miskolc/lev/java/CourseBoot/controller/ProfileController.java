package hu.uni.miskolc.lev.java.CourseBoot.controller;

import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.Profile;
import hu.uni.miskolc.lev.java.CourseBoot.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class ProfileController {
    private ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("getAllProfile")
    @ResponseBody
    public List<Profile> getAllProfile(){
        return profileService.getAllProfile();
    }
}