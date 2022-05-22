package hu.uni.miskolc.lev.java.CourseBoot.persist;

import hu.uni.miskolc.lev.java.CourseBoot.persist.entity.Profile;
import lombok.ToString;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Integer> { }
