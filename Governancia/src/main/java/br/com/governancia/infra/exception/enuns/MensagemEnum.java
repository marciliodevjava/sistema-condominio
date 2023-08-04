package br.com.governancia.infra.exception.enuns;

public enum MensagemEnum {
    ERROR_ENTITY_NOT_FOUND("Não existe na base de dados o campo informado."),
    ERRO_NO_SUCH_ELEMENT("Dado informado não encontrado."),
    ERRO_METHOD_ARGUMENT_NOT_VALID("Occoreu um erro na validação dos paramtros."),
    ERRO_HTTP_MESSAGE_NOT_REABLE("Erro 3: Acesso não autorizado."),
    ERRO_BAD_CREDENTIALS("Credenciais inválidas."),
    ERRO_ACCESS_DENIED("Acesso negado."),
    ERRO_AUTHENTICATION("Credenciais inválidas."),
    ERRO_EXCEPTION("Erro: "),
    ERRO_REQUISICAO_NEGADA("Solicitação negada.");

    private final String mensagem;

    MensagemEnum(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}