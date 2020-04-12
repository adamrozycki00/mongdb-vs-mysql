package pl.adaroz.springboot2.homework9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.adaroz.springboot2.homework9.dbjdbc.service.UserJdbcService;
import pl.adaroz.springboot2.homework9.dbjpa.service.UserJpaService;
import pl.adaroz.springboot2.homework9.dbmongo.service.UserMongoService;
import pl.adaroz.springboot2.homework9.service.UserServices;

import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class Start {

    private UserJpaService userJpaService;
    private UserJdbcService userJdbcService;
    private UserMongoService userMongoService;
    private UserServices userServices;

    private final String CSV_FILE = "src\\main\\resources\\MOCK_DATA.csv";

    @Autowired
    public Start(UserJpaService userJpaService, UserJdbcService userJdbcService, UserMongoService userMongoService, UserServices userServices) {
        this.userJpaService = userJpaService;
        this.userJdbcService = userJdbcService;
        this.userMongoService = userMongoService;
        this.userServices = userServices;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void test() {
        getAllAndSave();
        readAll();
    }

    public void getAllAndSave() {
        Path csvFilePath = Paths.get(CSV_FILE);
        userServices.getAllFromCsvAndSave(userMongoService, csvFilePath);
        userServices.getAllFromCsvAndSave(userJpaService, csvFilePath);
        userServices.getAllFromCsvAndSave(userJdbcService, csvFilePath);
    }

    public void readAll() {
        userServices.findAll(userJdbcService);
        userServices.findAll(userMongoService);
        userServices.findAll(userJpaService);
    }

}
