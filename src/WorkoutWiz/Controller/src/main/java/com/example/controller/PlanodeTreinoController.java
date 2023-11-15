RestController
@RequestMapping("/planodetreino")
public class PlanodeTreinoController {

    @Autowired
    private PlanodeTreinoService planodeTreinoService;

    // Métodos CRUD

    @GetMapping("/{id}")
    public ResponseEntity<PlanodeTreino> getPlanodeTreinoById(@PathVariable("id") int id) {
        PlanodeTreino planodeTreino = planodeTreinoService.getPlanodeTreinoById(id);
        return ResponseEntity.ok(planodeTreino);
    }

    @PostMapping
    public ResponseEntity<PlanodeTreino> createPlanodeTreino(@RequestBody PlanodeTreino planodeTreino) {
        PlanodeTreino createdPlanodeTreino = planodeTreinoService.createPlanodeTreino(planodeTreino);
        return new ResponseEntity<>(createdPlanodeTreino, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanodeTreino> updatePlanodeTreino(@PathVariable("id") int id, @RequestBody PlanodeTreino planodeTreino) {
        PlanodeTreino updatedPlanodeTreino = planodeTreinoService.updatePlanodeTreino(id, planodeTreino);
        return ResponseEntity.ok(updatedPlanodeTreino);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlanodeTreino(@PathVariable("id") int id) {
        planodeTreinoService.deletePlanodeTreino(id);
        return ResponseEntity.noContent().build();
    }

    // Novo método para salvar dados no sistema
    @PostMapping("/{id}/salvardados")
    public ResponseEntity<Void> salvarDadosNoSistema(@PathVariable("id") int id, @RequestBody DadosTreino dadosTreino) {
        // Adicione a lógica para salvar os dados no sistema
        planodeTreinoService.salvarDadosNoSistema(id, dadosTreino);
        return ResponseEntity.noContent().build();
    }
}
