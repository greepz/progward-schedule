package app.facade.settings;

import app.factories.JsonSettingFactory;
import app.repository.Repository;
import app.repository.model.Setting;

import java.util.List;

public class DeleteSettings {

    Repository<Setting> settings = JsonSettingFactory.getSettings();

    public void deleteFromJson(String id){
        settings.delete(id);
    }

}
