package devopsProject.devopsProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SeedClass implements CommandLineRunner {

    private final LogService logService;

    @Autowired
    public SeedClass(LogService logService) {
        this.logService = logService;
    }

    @Override
    public void run(String... args) {
        String serverStartTime = getCurrentTime();
        String logMessage = "Seed data loaded. Server started at: " + serverStartTime;
        logService.logEndpointAccess(logMessage);
    }

    private String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
}
