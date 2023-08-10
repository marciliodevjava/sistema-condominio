package br.com.funcionario.infra.exception.enuns;

public enum MensagemEnum {
    ERRO_DELETAR_FUNCIONARIO_COMPLETO("Não existe esse funcionario na base de dados.");
    private final String mensagem;

    MensagemEnum(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
