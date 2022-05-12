package hu.uni.miskolc.lev.java.CourseBoot.service;
import hu.uni.miskolc.lev.java.CourseBoot.persist.ProfileRepository;
import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService{
    private ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    @Override
    public void addProfile(Profile profile) {
        profileRepository.save(profile);
    }

    @Override
    public void deleteProfile(Profile profile) {
        profileRepository.delete(profile);
    }

    @Override
    public List<Profile> getAllProfile() {
        return (List<Profile>) profileRepository.findAll();
    }
}