package app.repository.file;

import app.repository.Repository;
import app.repository.model.Role;
import app.repository.model.Setting;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;

public class RoleFileRepository extends AbstractFileRepository<Role> implements Repository<Role> {

    private final static String SETTINGS_FILE = "/files/roles.json";

    public RoleFileRepository(ObjectMapper mapper) {
        super(mapper);
    }

    @Override
    public List<Role> get() {
        try {
            List<Role> settings =
                    objectMapper.readValue(readFromFile(SETTINGS_FILE), new TypeReference<List<Role>>() {});
            if (settings.isEmpty()){
                throw new RuntimeException("Не удалось получить роли");
            }
            return settings;
        }catch (IOException  ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public Role get(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(Role item) {

    }

    @Override
    public void save(Role item) {

    }


}
