package app.repository.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Setting {
    private String id;
    private String name;
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Setting setting = (Setting) o;
        return Objects.equals(id, setting.id) &&
                Objects.equals(name, setting.name) &&
                Objects.equals(value, setting.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, value);
    }
}
