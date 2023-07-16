package devopsProject.devopsProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@RestController
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/logs")
    public String getLogs() {
        logService.logEndpointAccess("/logs");
        String logFilePath = "/logs/file.log";
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("<br>");
            }
        } catch (IOException e) {
            return "Failed to read log file: " + e.getMessage();
        }
        return stringBuilder.toString();
    }

    @GetMapping("/transactions")
    public String getTransactions() {
        logService.logEndpointAccess("/transactions");
        return "transactions";
    }
}
