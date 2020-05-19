package app.factories;

import app.repository.Repository;
import app.repository.file.SettingFileRepository;
import app.repository.model.Setting;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSettingFactory {
    public static Repository<Setting> getSettings(){
        return new SettingFileRepository(new ObjectMapper());
    }
}
