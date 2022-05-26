package hu.uni.miskolc.lev.java.CourseBoot.service;
import hu.uni.miskolc.lev.java.CourseBoot.model.repo.ProfileRepository;
import hu.uni.miskolc.lev.java.CourseBoot.model.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService{
    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> getAllProfile() {
        return (List<Profile>) profileRepository.findAll();
    }

    public String getProfileByid(int profile_id){
        Optional<Profile> profile = profileRepository.findById(profile_id);
        String result = null;
        if (profile.isPresent()) {
            result="<table align='center' border='1'><th>Név</th><th>Kor<t/h><th>Művelet</th><tr><td>" +
                    "<input id='name"+profile_id+"' value='"+profile.get().getName()+"'/></td><td>" +
                    "<input id='age"+profile_id+"' type='number' value='"+profile.get().getAge()+"'/></td><td>" +
                    "<button onclick='updateProfile("+profile_id+")'>Módosít</button></td></tr></table>";
        }
        return result;
    }
}