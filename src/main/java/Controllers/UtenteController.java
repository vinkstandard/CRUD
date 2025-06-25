package Controllers;

import Models.Utente;
import Repos.UtenteRepository;
import Services.UtenteService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utenti")
public class UtenteController {

    private final UtenteService utenteService;

    public UtenteController(UtenteService utenteService){
        this.utenteService = utenteService;
    }

    @GetMapping
    public List<Utente> getAllUtenti(){
        return utenteService.getAllUtenti();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utente> getUtenteDaId(@PathVariable Long id) {
        Optional<Utente> utenteOpzionale = utenteService.getUtenteDaId(id);
        if (utenteOpzionale.isPresent()) {
            return ResponseEntity.ok(utenteOpzionale.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Utente creaUtente(@RequestBody Utente utente){
        return utenteService.creaUtente(utente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Utente> aggiornaUtente(@PathVariable Long id, @RequestBody Utente utente){
        Utente utenteAggiornato = utenteService.aggiornaUtente(id, utente);
        if(utenteAggiornato == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(utenteAggiornato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Utente> cancellaUtente(@PathVariable Long id){
        utenteService.cancellaUtente(id);
        return ResponseEntity.noContent().build();
    }

}
