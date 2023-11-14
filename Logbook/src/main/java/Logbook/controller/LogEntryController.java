package Logbook.controller;

import Logbook.service.LogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LogEntryController {

    private final LogEntryService logEntryService;

    @Autowired
    public LogEntryController(LogEntryService logEntryService) {
        this.logEntryService = logEntryService;
    }

    @GetMapping("/logentries")
    public String listLogEntries(Model model) {
        model.addAttribute("logEntries", logEntryService.getAllLogEntries());
        return "logentries";
    }

    @GetMapping("/logentries/{id}")
    public String viewLogEntry(@PathVariable Long id, Model model) {
        model.addAttribute("logEntry", logEntryService.getLogEntryById(id));
        return "viewlogentry";
    }
}
