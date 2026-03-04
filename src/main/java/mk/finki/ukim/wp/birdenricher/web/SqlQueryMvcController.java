package mk.finki.ukim.wp.birdenricher.web;

import mk.finki.ukim.wp.birdenricher.model.Difficulty;
import mk.finki.ukim.wp.birdenricher.model.SqlQuery;
import mk.finki.ukim.wp.birdenricher.service.SqlQueryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/queries")
public class SqlQueryMvcController {

    private final SqlQueryService service;

    public SqlQueryMvcController(SqlQueryService service) {
        this.service = service;
    }


    @GetMapping("/")
    public String home() {
        return "redirect:/queries";
    }


    @GetMapping
    public String list(Model model) {
        model.addAttribute("queries", service.findAll());
        return "queries/list";
    }


    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("query", new SqlQuery());
        model.addAttribute("difficulties", Difficulty.values());
        return "queries/form";
    }


    @PostMapping("/add")
    public String add(@RequestParam String question,
                      @RequestParam(required = false) String schemaName,
                      @RequestParam Difficulty difficulty,
                      @RequestParam String sqlAnswer,
                      @RequestParam(defaultValue = "false") boolean chatgptValid,
                      @RequestParam(required = false) String notes) {

        SqlQuery q = new SqlQuery();
        q.setQuestion(question);
        q.setSchemaName(schemaName);
        q.setDifficulty(difficulty);
        q.setSqlAnswer(sqlAnswer);
        q.setChatgptValid(chatgptValid);
        q.setNotes(notes);

        service.create(q);
        return "redirect:/queries";
    }


    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("q", service.findById(id));
        model.addAttribute("difficulties", Difficulty.values());
        return "queries/form-edit";
    }


    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id,
                       @RequestParam String question,
                       @RequestParam(required = false) String schemaName,
                       @RequestParam Difficulty difficulty,
                       @RequestParam String sqlAnswer,
                       @RequestParam(defaultValue = "false") boolean chatgptValid,
                       @RequestParam(required = false) String notes) {

        SqlQuery q = new SqlQuery();
        q.setQuestion(question);
        q.setSchemaName(schemaName);
        q.setDifficulty(difficulty);
        q.setSqlAnswer(sqlAnswer);
        q.setChatgptValid(chatgptValid);
        q.setNotes(notes);

        service.update(id, q);
        return "redirect:/queries";
    }


    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/queries";
    }
}