package br.com.morador.infra.enuns;

public enum MensagemEnum {
    ERRO_SALVAR_PROPRIETARIO_SIMPLES("Não foi possivel salvo o proprietário.");
    private final String mensagem;
    MensagemEnum(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
