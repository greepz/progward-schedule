package app.factories;

import app.repository.Repository;
import app.repository.file.SimpleMentorFileRepository;
import app.repository.model.Mentor;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMentorFactory {

    public static Repository<Mentor> getMentors(){
        return new SimpleMentorFileRepository(new ObjectMapper());
    }

}
