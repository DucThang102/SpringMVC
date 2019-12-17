package thangpd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import thangpd.dto.StudentDTO;
import thangpd.service.StudentService;

import java.io.FileNotFoundException;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/student")
    public String findAll(Model model) {
        List<StudentDTO> list = studentService.findAll();
        model.addAttribute("listData", list);
        return "student";
    }

    @RequestMapping(value = "/detail/{id}")
    public String findById(@PathVariable("id") String id, Model model) {
        StudentDTO data = studentService.findById(id);
        model.addAttribute("data", data);
        return "detail";
    }

//    @RequestMapping(value = "/detail")
//    public String findByIdv(@RequestParam("id") String id, Model model) {
//        StudentDTO data = studentService.findById(id);
//        model.addAttribute("data", data);
//        return "detail";
//    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String saveInit(Model model) {
        model.addAttribute("student", new StudentDTO());
        return "add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveDo(@ModelAttribute("student") StudentDTO dto) {
        studentService.save(dto);
        return "redirect:/student";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String uploadInit() {
        return "upload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView uploadDo(@RequestParam(name = "file") MultipartFile file) {
        ModelAndView modelAndView = new ModelAndView("upload");
        try {
            if (studentService.uploadFile(file)) {
                modelAndView.addObject("message", "upload successful");
                return modelAndView;
            }
            modelAndView.addObject("message", "upload error!");
            return modelAndView;
        } catch (FileNotFoundException e) {
            modelAndView.addObject("message", "upload error!");
            return modelAndView;
        }
    }

    // =========================== REST =======================//
    @RequestMapping(value = "api/findAll")
    public @ResponseBody
    List<StudentDTO> findAllStudent() {
        return studentService.findAll();
    }

    @RequestMapping(value = "api/add", method = RequestMethod.POST)
    public @ResponseBody
    void addStudent(@RequestBody StudentDTO dto) {
        studentService.save(dto);
    }

}
