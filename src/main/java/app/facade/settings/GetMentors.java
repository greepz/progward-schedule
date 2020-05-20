package app.facade.settings;

import app.factories.JsonMentorFactory;
import app.repository.Repository;
import app.repository.model.Mentor;

import java.util.List;


public class GetMentors {

    private Repository<Mentor> mentors = JsonMentorFactory.getMentors();


    public List<Mentor> fromJson(){
        return mentors.get();
    }

}
