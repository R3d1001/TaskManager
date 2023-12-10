package com.TaskManager.Controllers;


import com.TaskManager.Repositories.CommentsRepository;
import com.TaskManager.Repositories.TaskRepository;
import com.TaskManager.Repositories.UserRepository;
import com.TaskManager.Repositories.UserTasksRepository;
import com.TaskManager.Services.PdfService;
import com.TaskManager.entities.Tasks;
import com.TaskManager.entities.Users;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pdf")
public class PdfDownloadController {

    @Autowired
    private PdfService pdfService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserTasksRepository userTasksRepository;

    @Autowired
    CommentsRepository commentsRepository;

    @GetMapping("/download")
    public void downloadPdf(HttpServletResponse response , @RequestParam(name = "task") String taskID) throws IOException {
        Model model = new ExtendedModelMap(); {
        };

        Map<String, Object> data = new HashMap<>();


        // Add data to be displayed in the template
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        List<Tasks> tasks = userTasksRepository.findByEmail(userDetails.getUsername());
        int input = Integer.parseInt(taskID);
        Tasks task;
        if(input == -1) task = tasks.get(0);
        else task = taskRepository.findByTaskID(input).get(0);
        model.addAttribute("Task", task);
        List<Users> userList = userTasksRepository.findByTaskID(input);
        String emails = "";
        for (Users u : userList) emails += u.email + ", ";
        model.addAttribute("userList", emails);
        model.addAttribute("Comments", commentsRepository.findByTaskID(input));


        byte[] pdfBytes = pdfService.generatePdfFromHtmlTemplate("ExportPDF", model);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=exported-pdf.pdf");
        response.setContentLength(pdfBytes.length);

        response.getOutputStream().write(pdfBytes);
        response.getOutputStream().flush();
    }
}