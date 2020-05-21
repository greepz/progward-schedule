package app.repository.file;

import app.repository.Repository;
import app.repository.model.Setting;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;
import java.util.UUID;

public class SettingFileRepository  extends AbstractFileRepository<Setting> implements Repository<Setting> {

    private final static String SETTINGS_FILE = "/files/settings.json";

    public SettingFileRepository(ObjectMapper mapper) {
        super(mapper);
    }


    @Override
    public List<Setting> get(){
         try {
            List<Setting> settings =
                    objectMapper.readValue(readFromFile(SETTINGS_FILE), new TypeReference<List<Setting>>() {});
            if (settings.isEmpty()){
                throw new RuntimeException("Не удалось получить настройки системы");
            }
            return settings;
        }catch (IOException  ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public Setting get(String id) {

        List<Setting> list = this.get();


        for (Setting setting: list){
            if(setting.getId().equals(id)){
                return setting;
            }
        }

        throw new RuntimeException("По ID: "+id+ " настройки не найдены");

    }

    @Override
    public void delete(String id) {
        Setting setting = this.get(id);
        List<Setting> settings = this.get();
        settings.remove(setting);
        saveToFile(settings, SETTINGS_FILE);

    }

    @Override
    public void update(Setting item) {
        boolean isUpdate = false;
        List<Setting> settings = this.get();
        for (Setting setting:settings) {
            if(setting.getId().equals(item.getId())){
                setting.setName(item.getName());
                setting.setValue(item.getValue());
                isUpdate = true;
            }
        }
        if (!isUpdate){
            throw new RuntimeException("запись не обновлена");
        }

        saveToFile(settings, SETTINGS_FILE);


    }

    @Override
    public void save(Setting item) {
        List<Setting> settings = this.get();
        item.setId(UUID.randomUUID().toString());
        settings.add(item);
        saveToFile(settings, SETTINGS_FILE);
    }


}
