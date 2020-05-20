package app.repository.file;

import app.repository.Repository;
import app.repository.model.Mentor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Logger;

public class SimpleMentorFileRepository implements Repository<Mentor> {

    private ObjectMapper mapper;
    private final static String MENTOR_FILE = "/files/mentors.json";
    private final static Logger LOGGER = Logger.getLogger(SimpleMentorFileRepository.class.getName());

    public SimpleMentorFileRepository(ObjectMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<Mentor> get() {

        StringBuilder content = new StringBuilder();

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(MENTOR_FILE)))){
            String str = "";
            while ((str = bufferedReader.readLine()) != null){
                content.append(str);
            }
            List<Mentor> list = mapper.readValue(content.toString(), new TypeReference<List<Mentor>>() {
            });

            if (list == null || list.isEmpty()){
                throw new RuntimeException("Список пуст");
            }
            return list;
        }catch (IOException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public Mentor get(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(Mentor item) {

    }

    @Override
    public void save(Mentor item) {

    }
}
