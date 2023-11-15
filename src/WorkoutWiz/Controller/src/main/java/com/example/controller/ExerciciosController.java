@RestController
@RequestMapping("/exercicios")
public class ExerciciosController {

    @Autowired
    private ExerciciosService exerciciosService;

    // Métodos CRUD

    @GetMapping("/{id}")
    public ResponseEntity<Exercicios> getExerciciosById(@PathVariable("id") int id) {
        Exercicios exercicios = exerciciosService.getExerciciosById(id);
        return ResponseEntity.ok(exercicios);
    }

    @PostMapping
    public ResponseEntity<Exercicios> createExercicios(@RequestBody Exercicios exercicios) {
        Exercicios createdExercicios = exerciciosService.createExercicios(exercicios);
        return new ResponseEntity<>(createdExercicios, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exercicios> updateExercicios(@PathVariable("id") int id, @RequestBody Exercicios exercicios) {
        Exercicios updatedExercicios = exerciciosService.updateExercicios(id, exercicios);
        return ResponseEntity.ok(updatedExercicios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercicios(@PathVariable("id") int id) {
        exerciciosService.deleteExercicios(id);
        return ResponseEntity.noContent().build();
    }

    // Novos métodos

    @GetMapping("/{id}/gerarrelatorio")
    public ResponseEntity<String> gerarRelatorio(@PathVariable("id") int id) {
        String relatorio = exerciciosService.gerarRelatorio(id);
        return ResponseEntity.ok(relatorio);
    }

    @GetMapping("/busca")
    public ResponseEntity<Exercicios> buscarExercicioPeloNome(@RequestParam String nomeDoExercicio) {
        Exercicios exercicio = exerciciosService.buscarExercicioPeloNome(nomeDoExercicio);
        return ResponseEntity.ok(exercicio);
    }

    @PostMapping("/{id}/realizado")
    public ResponseEntity<Void> salvarExercicioRealizado(@PathVariable("id") int id, @RequestBody Boolean realizado) {
        exerciciosService.salvarExercicioRealizado(id, realizado);
        return ResponseEntity.noContent().build();
    }
}
