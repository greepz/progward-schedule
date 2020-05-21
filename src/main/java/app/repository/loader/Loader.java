package app.repository.loader;

import app.repository.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Loader {

    private static ObjectMapper objectMapper = new ObjectMapper();


    public static void main(String[] args) {
        loadSettings();
        List<Role> roles = loadRole();
        List<Mentor> mentors = loadMentors(roles);
        List<Client> clients = loadClients(roles);


    }

    private static List<Client> loadClients(List<Role> roles) {
        Role role = null;
        for(Role r: roles){
            if(r.getCode().equals("CLIENT")){
                role = r;
                break;
            }
        }
        List<Client> clients = new LinkedList<>();
        Client m = new Client();
        m.setId(UUID.randomUUID().toString());
        m.setEmail("mailClient1@mail");
        m.setLogin("client1");
        m.setPassword("client1");
        m.setRole(role);

        Client m2 = new Client();
        m2.setId(UUID.randomUUID().toString());
        m2.setEmail("mailClient2@mail");
        m2.setLogin("client2");
        m2.setPassword("client2");
        m2.setRole(role);

        clients.add(m2);
        clients.add(m);

        saveToFile("/files/clients.json", clients);
        return clients;
    }

    private static List<Mentor> loadMentors(List<Role> roles) {
        Role role = null;
        for(Role r: roles){
            if(r.getCode().equals("MENTOR")){
                role = r;
                break;
            }
        }

        List<Mentor> mentors = new LinkedList<>();
        Mentor m = new Mentor();
        m.setId(UUID.randomUUID().toString());
        m.setEmail("mail@mail");
        m.setLogin("mentor1");
        m.setPassword("mentor1");
        m.setRole(role);

        Mentor m2 = new Mentor();
        m2.setId(UUID.randomUUID().toString());
        m2.setEmail("mail2@mail");
        m2.setLogin("mentor2");
        m2.setPassword("mentor2");
        m2.setRole(role);

        mentors.add(m2);
        mentors.add(m);

        saveToFile("/files/mentors.json", mentors);
        return mentors;
    }


    public static List<Role> loadRole(){
        List<Role> roleList = new ArrayList<>();
        Role role = new Role();
        role.setId(UUID.randomUUID().toString());
        role.setCode("CLIENT");
        roleList.add(role);

        Role role1 = new Role();
        role1.setId(UUID.randomUUID().toString());
        role1.setCode("MENTOR");

        roleList.add(role1);
        saveToFile("/files/roles.json", roleList);
        return roleList;
    }

    public static void loadSettings(){
        List<Setting> settings = new ArrayList<>();
        Setting setting = new Setting();
        setting.setId(UUID.randomUUID().toString());
        setting.setName("Ограничение на кол-во консультаций в день");
        setting.setValue("0");

        Setting setting2 = new Setting();
        setting2.setId(UUID.randomUUID().toString());
        setting2.setName("Ограничение на кол-во консультаций в месяц");
        setting2.setValue("0");

        settings.add(setting2);
        settings.add(setting);

         saveToFile("/files/settings.json", settings);
    }



    private static <T> void saveToFile(String path, T data){
        try (PrintWriter pr = new PrintWriter(Loader.class.getResource(path).getPath())) {
            String str = objectMapper.writeValueAsString(data);
            pr.println(str);
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
