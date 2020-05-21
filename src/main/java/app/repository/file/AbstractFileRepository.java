package app.repository.file;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class AbstractFileRepository<T> {
    protected ObjectMapper objectMapper;
    protected ReadWriteLock lock;

    public AbstractFileRepository(ObjectMapper mapper){
        this.lock = new ReentrantReadWriteLock();
        this.objectMapper = mapper;
    }

    protected <T> void saveToFile(T items, String path){
        lock.writeLock().lock();
        try {
            try (PrintWriter pr = new PrintWriter(AbstractFileRepository.class.getResource(path).getPath())) {
                String str = objectMapper.writeValueAsString(items);
                pr.println(str);
            } catch (IOException ex) {
                throw new RuntimeException(ex.getMessage());
            }
        }finally {
            lock.writeLock().unlock();
        }
    }

    protected String readFromFile(String path){
        lock.readLock().lock();
        try {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(path)))) {
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
