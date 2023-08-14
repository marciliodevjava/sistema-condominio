package br.com.funcionario.infra.exception.enuns;

public enum MensagemEnum {
    ERRO_AO_ATUALIZAR_DEPENDENTE("Não possivel atualizar o dependentes informado."),
    LIST_DEPENDENTE_NOT_FOUND("Não existe dependentes vinculados ao funcionario."),
    ERRO_DELETAR_FUNCIONARIO_COMPLETO("Não existe esse funcionario."),
    ERRO_FUNCIONARIO_NAO_EXISTE("Funcionario não existe.");
    private final String mensagem;

    MensagemEnum(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
