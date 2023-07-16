package devopsProject.devopsProject;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LogService {

    private final Logger logger = LoggerFactory.getLogger(LogService.class);
    private final String logFilePath = "/logs/file.log";
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void logEndpointAccess(String endpoint) {
        String logMessage = generateLogMessage(endpoint);
        logger.info(logMessage);
        writeToFile(logMessage);
    }

    private String generateLogMessage(String endpoint) {
        String timestamp = dateFormat.format(new Date());
        return String.format("INFO %s Accessed endpoint: %s", timestamp, endpoint);
    }

    private void writeToFile(String logMessage) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFilePath, true))) {
            writer.println(logMessage);
        } catch (IOException e) {
            logger.error("Failed to write log to file", e);
        }
    }
}
