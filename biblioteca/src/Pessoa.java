public abstract class Pessoa implements Perfil {
    private String cpf;
    private String nome;

    public Pessoa(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String mostrarPerfil() {
        return "Nome: " + nome + "\nCPF: " + cpf;
    }
}
