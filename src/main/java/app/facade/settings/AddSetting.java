package app.facade.settings;

import app.factories.JsonSettingFactory;
import app.repository.Repository;
import app.repository.model.Setting;

public class AddSetting {

    private Repository<Setting> repository = JsonSettingFactory.getSettings();

    public void inJsonFile(Setting setting){
        repository.save(setting);
    }


}
