
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CloudManager {

    private Map<Cliente, Set<Servidor>> bancoDeDados = new HashMap<>();

    public CloudManager() {
    }

    public void registrarCliente(Cliente cliente) {
        bancoDeDados.putIfAbsent(cliente, new HashSet<>());
    }

    public void provisionarServidor(Cliente cliente, Servidor servidor) {
        bancoDeDados.putIfAbsent(cliente, new HashSet<>());

        bancoDeDados.get(cliente).add(servidor);
    }

    public double calcularFaturaAtiva(Cliente c) {

        return bancoDeDados.getOrDefault(c, new HashSet<>())
                .stream()
                .filter(s -> s.isStatusLigado())
                .mapToDouble(s -> s.getPrecoPorHora())
                .sum();
    }
}
