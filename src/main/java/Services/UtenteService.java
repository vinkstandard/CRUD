package Services;

import Models.Utente;
import Repos.UtenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {
    private final UtenteRepository utenteRepository;

    public UtenteService(UtenteRepository utenteRepository){
        this.utenteRepository = utenteRepository;
    }
    public List<Utente> getAllUtenti(){
        return utenteRepository.findAll();
    }
    public Optional<Utente> getUtenteDaId(Long id){
        return utenteRepository.findById(id);
    }
    public Utente aggiornaUtente(Long id, Utente utenteAggiornato){
        Optional<Utente> utenteOpzionale = utenteRepository.findById(id);
        if(utenteOpzionale.isPresent()){
            // convertiamo l'opzionale in utente vero e proprio
            Utente utenteEsistente = utenteOpzionale.get();
            utenteEsistente.setNome(utenteAggiornato.getNome());
            utenteEsistente.setEmail(utenteAggiornato.getEmail());

            return utenteRepository.save(utenteEsistente);
        }else{
            return null;
        }
    }
    public Utente creaUtente(Utente utente){
        return utenteRepository.save(utente);
    }
    public void cancellaUtente(Long id){
        utenteRepository.deleteById(id);
    }
}
