package Logbook.service;

import Logbook.model.LogEntry;
import Logbook.repository.LogEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogEntryService {

    private final LogEntryRepository logEntryRepository;

    @Autowired
    public LogEntryService(LogEntryRepository logEntryRepository) {
        this.logEntryRepository = logEntryRepository;
    }

    public List<LogEntry> getAllLogEntries() {
        return logEntryRepository.findAll();
    }

    public LogEntry getLogEntryById(Long id) {
        return logEntryRepository.findById(id).orElse(null);
    }

    public LogEntry saveLogEntry(LogEntry logEntry) {
        return logEntryRepository.save(logEntry);
    }

    public void deleteLogEntry(Long id) {
        logEntryRepository.deleteById(id);
    }

}
