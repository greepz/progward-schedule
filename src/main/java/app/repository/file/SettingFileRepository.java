package app.repository.file;

import app.repository.Repository;
import app.repository.model.Setting;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SettingFileRepository implements Repository<Setting> {

    private final static String SETTINGS_FILE = "/files/settings.json";

    private ObjectMapper objectMapper;

    private ReadWriteLock lock;

    public SettingFileRepository(ObjectMapper mapper){
        this.lock = new ReentrantReadWriteLock();
        this.objectMapper = mapper;
    }

    @Override
    public List<Setting> get(){
         try {
            List<Setting> settings =
                    objectMapper.readValue(readFromFile(), new TypeReference<List<Setting>>() {});
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
        saveToFile(settings);

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

        saveToFile(settings);


    }

    @Override
    public void save(Setting item) {
        List<Setting> settings = this.get();
        item.setId(UUID.randomUUID().toString());
        settings.add(item);
        saveToFile(settings);
    }

    private void saveToFile(List<Setting> settings){
        lock.writeLock().lock();
        try {
            try (PrintWriter pr = new PrintWriter(new FileWriter(SETTINGS_FILE))) {
                String str = objectMapper.writeValueAsString(settings);
                pr.println(str);
            } catch (IOException ex) {
                throw new RuntimeException(ex.getMessage());
            }
        }finally {
            lock.writeLock().unlock();
        }
    }

    private String readFromFile(){
        lock.readLock().lock();
        try {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(SETTINGS_FILE)))) {
                StringBuilder builder = new StringBuilder();
                String str = "";
                while ((str = bufferedReader.readLine()) != null) {
                    builder.append(str);
                }
                return builder.toString();
            } catch (IOException ex) {
                throw new RuntimeException(ex.getMessage());
            }
        }finally {
            lock.readLock().unlock();
        }
    }
}
