import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bibliotecario extends Usuario {
    private int idBibliotecario;
    private static ArrayList<Bibliotecario> bibliotecarios = new ArrayList<>();
    private static Queue<String> filaAtendimento = new LinkedList<>();
    private static int contadorId = 1;

    public Bibliotecario(String cpf, String nome, String senha, String email, String telefone) throws DadosInvalidosException {
        super(cpf, nome, senha, email, telefone);

        // Valida CPF e email
        if (!validarCpf(cpf)) {
            throw new DadosInvalidosException("CPF inválido!");
        }
        if (!validarEmail(email)) {
            throw new DadosInvalidosException("Email inválido!");
        }

        this.idBibliotecario = contadorId++;
    }

    // Valida se o CPF possui 11 dígitos
    private boolean validarCpf(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }

    // Valida o formato do email
    private boolean validarEmail(String email) {
        return email != null && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    // Adiciona um bibliotecário à lista, se não estiver já cadastrado
    public void criarBibliotecario() throws BibliotecarioJaCadastradoException {
        if (buscaBibliotecario(super.getCpf()) == null) {
            bibliotecarios.add(this);
            System.out.println("Bibliotecário cadastrado!");
        } else {
            throw new BibliotecarioJaCadastradoException("Bibliotecário já cadastrado!");
        }
    }

    // Busca um bibliotecário pelo CPF
    public static Bibliotecario buscaBibliotecario(String cpf) {
        for (Bibliotecario b : bibliotecarios) {
            if (b.getCpf().equals(cpf)) {
                return b;
            }
        }
        return null;
    }

    // Remove um bibliotecário pelo CPF
    public static void excluirBibliotecario(String cpf) throws BibliotecarioNaoEncontradoException {
        Bibliotecario b = buscaBibliotecario(cpf);
        if (b != null) {
            bibliotecarios.remove(b);
            System.out.println("Bibliotecário removido!");
        } else {
            throw new BibliotecarioNaoEncontradoException("Bibliotecário não encontrado!");
        }
    }

    // Lista todos os bibliotecários
    public static ArrayList<Bibliotecario> listaBibliotecarios() {
        return new ArrayList<>(bibliotecarios);
    }

    // Converte a lista de bibliotecários para um array
    public static Bibliotecario[] toArray() {
        return bibliotecarios.toArray(new Bibliotecario[0]);
    }

    // Adiciona uma tarefa à fila de atendimento
    public static void adicionarTarefaFila(String tarefa) {
        filaAtendimento.add(tarefa);
    }

    // Pega a próxima tarefa da fila de atendimento
    public static String proximaTarefa() {
        return filaAtendimento.poll();
    }

    // Mostra o perfil do bibliotecário
    @Override
    public String mostrarPerfil() {
        return "\nId do Bibliotecário: " + idBibliotecario + "\n" + super.mostrarPerfil();
    }
}
