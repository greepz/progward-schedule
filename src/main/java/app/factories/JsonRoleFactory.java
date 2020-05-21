package app.factories;

import app.repository.Repository;
import app.repository.file.RoleFileRepository;
import app.repository.model.Role;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonRoleFactory {
    public static Repository<Role> getRoles(){
        return new RoleFileRepository(new ObjectMapper());
    }
}
