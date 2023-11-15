@RestController
@RequestMapping("/aprimoramento")
public class AprimoramentoController {

    @Autowired
    private AprimoramentoService aprimoramentoService;

    // Métodos CRUD

    @GetMapping("/{id}")
    public ResponseEntity<Aprimoramento> getAprimoramentoById(@PathVariable("id") int id) {
        Aprimoramento aprimoramento = aprimoramentoService.getAprimoramentoById(id);
        return ResponseEntity.ok(aprimoramento);
    }

    @PostMapping
    public ResponseEntity<Aprimoramento> createAprimoramento(@RequestBody Aprimoramento aprimoramento) {
        Aprimoramento createdAprimoramento = aprimoramentoService.createAprimoramento(aprimoramento);
        return new ResponseEntity<>(createdAprimoramento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aprimoramento> updateAprimoramento(@PathVariable("id") int id, @RequestBody Aprimoramento aprimoramento) {
        Aprimoramento updatedAprimoramento = aprimoramentoService.updateAprimoramento(id, aprimoramento);
        return ResponseEntity.ok(updatedAprimoramento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAprimoramento(@PathVariable("id") int id) {
        aprimoramentoService.deleteAprimoramento(id);
        return ResponseEntity.noContent().build();
    }

    // Novos métodos

    @GetMapping("/{id}/gerardicas")
    public ResponseEntity<String> gerarDicasDeExecucao(@PathVariable("id") int id) {
        // Adicione a lógica para gerar as dicas de execução
        String dicas = aprimoramentoService.gerarDicasDeExecucao(id);
        return ResponseEntity.ok(dicas);
    }

    @GetMapping("/{id}/gerardicasseguranca")
    public ResponseEntity<String> gerarDicasDeSeguranca(@PathVariable("id") int id) {
        // Adicione a lógica para gerar as dicas de segurança
        String dicasSeguranca = aprimoramentoService.gerarDicasDeSeguranca(id);
        return ResponseEntity.ok(dicasSeguranca);
    }

    @PostMapping("/{id}/feedback")
    public ResponseEntity<Void> salvarFeedback(@PathVariable("id") int id, @RequestBody String feedback) {
        // Adicione a lógica para salvar o feedback
        aprimoramentoService.salvarFeedback(id, feedback);
        return ResponseEntity.noContent().build();
    }
}
