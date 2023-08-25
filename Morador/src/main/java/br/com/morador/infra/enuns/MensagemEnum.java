package br.com.morador.infra.enuns;

public enum MensagemEnum {
    ERRO_SALVAR_APARTAMENTO("Não foi possivel salva os dados do Apartamento."),
    ERRO_BUSCAR_PROPRIETARIO("Não foi possivel buscar o proprietário."),
    ERRO_SALVAR_PROPRIETARIO_SIMPLES("Não foi possivel salvo o proprietário."),
    ERRO_DELETAR_PROPRIETARIO("Erro ao deletar proprietario"),
    ERRO_SALVAR_DEPENDENTE("Não foi possivel salvar os dados do Dependente.");
    private final String mensagem;
    MensagemEnum(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
