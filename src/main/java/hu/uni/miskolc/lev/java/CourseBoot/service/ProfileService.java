package hu.uni.miskolc.lev.java.CourseBoot.service;

import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.Profile;

import java.util.List;


    public interface ProfileService {
        void addProfile(Profile profile);
        void deleteProfile(Profile profile);
        List<Profile> getAllProfile();
    }

