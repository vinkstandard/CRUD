package completo.Repos;

import completo.Models.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UtenteRepository extends JpaRepository<Utente, Long> {
}
