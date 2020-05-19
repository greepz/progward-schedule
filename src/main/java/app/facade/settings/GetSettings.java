package app.facade.settings;

import app.factories.JsonSettingFactory;
import app.repository.Repository;
import app.repository.file.SettingFileRepository;
import app.repository.model.Setting;

import java.util.List;

public class GetSettings {

    Repository<Setting> settings = JsonSettingFactory.getSettings();

    public List<Setting> fromJson(){
        return settings.get();
    }
}
