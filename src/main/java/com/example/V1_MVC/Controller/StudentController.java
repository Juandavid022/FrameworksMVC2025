package com.example.V1_MVC.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.example.V1_MVC.DTO.StudentDashboardDTO;
import com.example.V1_MVC.DTO.StudentRegistrationDTO;
import com.example.V1_MVC.Model.ClassModel;
import com.example.V1_MVC.Model.Role;
import com.example.V1_MVC.Model.StudentModel;
import com.example.V1_MVC.Model.UserModel;
import com.example.V1_MVC.Repository.StudentsRepository;
import com.example.V1_MVC.Services.ClassService;
import com.example.V1_MVC.Services.StudentService;
import com.example.V1_MVC.Services.UserService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@Tag(name = "Estudiantes", description = "Operaciones sobre el manejo y recursos de los estudiantes")
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private ClassService classService;

    @Autowired
    private StudentsRepository studentsRepository;

    private final StudentService studentService;

    @Autowired
    private UserService userService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/register")
    @Operation(summary = "Registro de estudiantes", description = "Permite el registro de nuevos estudiantes en el sistema.")
    public String showForm(Model model) {
        model.addAttribute("studentDTO", new StudentRegistrationDTO());
        return "register-student"; // el nombre del HTML
    }

    @GetMapping("/dashboard")
    @Operation(summary = "Dashbodard", description = "Permite la visualizacion de las clases y notas del estudiante.")
    public String dashboard(Model model, Principal principal) {

        if (principal == null) {
            return "redirect:/login"; // Si no hay sesión
        }

        String username = principal.getName(); // Nombre de usuario logueado

        // Traer UserModel desde la base de datos
        UserModel user = userService.findByUsername(username); // Debes tener este método
        if (user == null) {
            return "redirect:/login";
        }

        // Traer StudentModel asociado por email
        StudentModel student = studentService.findByEmail(user.getEmail());
        if (student == null) {
            // Si no es estudiante, puedes manejar otro tipo de rol (coach, admin, etc.)
            return "redirect:/login";
        }

        // Mapear a DTO
        StudentDashboardDTO dashboard = new StudentDashboardDTO();
        dashboard.setName(student.getName());
        dashboard.setEmail(student.getEmail());
        dashboard.setUsername(user.getUsername());
        dashboard.setRole(user.getRole().name());

        // Por ahora dejamos clases vacío
        dashboard.setClases(List.of());

        model.addAttribute("usuario", dashboard);

        return "dashboard-students"; // Tu template HTML
    }

    @GetMapping("/list")
    @Operation(summary = "Lista de estudiantes", description = "Muestra la lista de todos los estudiantes registrados en el sistema.")
    public String listar(Model model) {
        model.addAttribute("student", studentService.listar());
        return "list-students";
    }

    @PostMapping("/save")
    @Operation(summary = "Guardar estudiante", description = "Guarda un nuevo estudiante y su usuario asociado en el sistema.")
    public String saveStudent(StudentRegistrationDTO dto, RedirectAttributes redirectAttrs) {

        // 1️⃣ Guardar estudiante
        StudentModel student = new StudentModel();
        student.setName(dto.getName());
        student.setBirthday(dto.getBirthday());
        student.setGenere(dto.getGenere());
        student.setEmail(dto.getEmail());
        student.setPhoneNumber(dto.getPhoneNumber());
        student.setStatus("ACTIVE"); // o lo que uses como default
        studentsRepository.save(student);

        // 2️⃣ Guardar usuario
        UserModel user = new UserModel();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(Role.STUDENT);
        userService.saveUser(user);

        redirectAttrs.addFlashAttribute("success", "Estudiante registrado correctamente");
        return "redirect:/students/list"; // o donde quieras
    }

    @GetMapping("/dashboard/{userId}")
    @Operation(summary = "Dashbodard por ID", description = "Permite la visualizacion de las clases y notas del estudiante segun su ID.")
    public String dashboard(@PathVariable Long userId, Model model) {

        // Obtener estudiante y usuario
        StudentModel student = studentService.listarId(userId);
        UserModel user = userService.listarId(userId);

        // Mapear a DTO
        StudentDashboardDTO dashboard = new StudentDashboardDTO();
        dashboard.setName(student.getName());
        dashboard.setEmail(user.getEmail());
        dashboard.setUsername(user.getUsername());
        dashboard.setRole(user.getRole().name());

        // Traer clases desde el servicio
        List<ClassModel> clasesEstudiante = classService.listar();

        List<StudentDashboardDTO.ClassDTO> clases = clasesEstudiante.stream().map(c -> {
            StudentDashboardDTO.ClassDTO dto = new StudentDashboardDTO.ClassDTO();
            dto.setNombre(c.getName());
            dto.setHorario(c.getSchedule().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
            dto.setNotas(""); // si hay notas, llenarlas
            dto.setCoach(c.getCoach().getName());
            return dto;
        }).toList();

        dashboard.setClases(clases);

        model.addAttribute("usuario", dashboard);

        return "dashboard-students";
    }

}
