public class Usuario extends Pessoa {
    private String senha;
    private String email;
    private String telefone;

    public Usuario(String cpf, String nome, String senha, String email, String telefone) {
        super(cpf, nome);
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String mostrarPerfil() {
        return super.mostrarPerfil() + "\nEmail: " + email + "\nTelefone: " + telefone;
    }
}
