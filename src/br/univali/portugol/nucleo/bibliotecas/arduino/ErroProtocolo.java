package br.univali.portugol.nucleo.bibliotecas.arduino;

/**
 *
 * @author Luiz Fernando
 */
public final class ErroProtocolo extends ErroArduino
{
    private static final int ERRO_INSTRUCAO_INEXISTENTE = 1;
    private static final int ERRO_NUMERO_PARAMETROS_INCORRETO = 2;
    private static final int ERRO_TIPO_PARAMETRO_INCORRETO = 3;

    private static final int TIPO_CARACTER = 1;
    private static final int TIPO_INTEIRO = 2;
    private static final int TIPO_LOGICO = 3;
    private static final int TIPO_REAL = 4;

    private ErroProtocolo(String mensagem)
    {
        super("Erro no protocolo PortugolArduino: " + mensagem);
    }

    public static boolean ocorreuErro(StringBuilder bufferResposta)
    {
        String resposta = bufferResposta.toString();

        return resposta.startsWith("ERRO [") && resposta.endsWith("]");
    }

    public static ErroProtocolo decodificarErro(StringBuilder bufferResposta)
    {
        String erro = bufferResposta.toString();

        int inicio = erro.indexOf("[") + 1;
        int fim = erro.indexOf("]");

        String[] parametros = erro.substring(inicio, fim).split(";");
        int codigoErro = Integer.parseInt(parametros[0]);

        switch (codigoErro)
        {
            case ERRO_INSTRUCAO_INEXISTENTE:
                return erroInstrucaoInexistente(parametros);
            case ERRO_NUMERO_PARAMETROS_INCORRETO:
                return erroNumeroParametrosIncorreto(parametros);
            case ERRO_TIPO_PARAMETRO_INCORRETO:
                return erroTipoParametroIncorreto(parametros);
        }

        return new ErroProtocolo("Código de erro desconhecido");
    }

    private static ErroProtocolo erroInstrucaoInexistente(String[] parametros)
    {
        int instrucao = Integer.parseInt(parametros[1]);

        return new ErroProtocolo(String.format("A instrução %d não existe", instrucao));
    }

    private static ErroProtocolo erroNumeroParametrosIncorreto(String[] parametros)
    {
        int instrucao = Integer.parseInt(parametros[1]);
        int esperado = Integer.parseInt(parametros[2]);
        int informado = Integer.parseInt(parametros[3]);

        StringBuilder mensagem = new StringBuilder("A função '");

        mensagem.append(Instrucao.getNome(instrucao));
        mensagem.append("'");
        
        if (esperado == 0)
        {
            mensagem.append(" não espera nenhum parâmetro, mas ");
        }
        else if (esperado == 1)
        {
            mensagem.append(" espera apenas 1 parâmetro, mas ");
        }
        else
        {
            mensagem.append(" espera ");
            mensagem.append(esperado);
            mensagem.append(" parâmetros, mas ");            
        }

        if (informado == 0)
        {
            mensagem.append("não foi passado nenhum parâmetro");
        }
        else if (informado == 1)
        {
            mensagem.append("foi passado apenas 1 parametro");
        }
        else
        {
            mensagem.append("foram passados ");
            mensagem.append(informado);
            mensagem.append(" parâmetros");
        }

        return new ErroProtocolo(mensagem.toString());
    }

    private static ErroProtocolo erroTipoParametroIncorreto(String[] parametros)
    {
        int instrucao = Integer.parseInt(parametros[1]);
        String nome = parametros[2];
        int tipoEsperado = Integer.parseInt(parametros[3]);

        StringBuilder mensagem = new StringBuilder("O parâmetro '");

        mensagem.append(nome);
        mensagem.append("' da função '");
        mensagem.append(Instrucao.getNome(instrucao));
        mensagem.append("' espera um valor do tipo '");
        mensagem.append(obterTipo(tipoEsperado));
        mensagem.append("'");

        return new ErroProtocolo(mensagem.toString());
    }

    private static String obterTipo(int codigoTipo)
    {
        switch (codigoTipo)
        {
            case TIPO_INTEIRO:
                return "inteiro";
            case TIPO_LOGICO:
                return "lógico";
            case TIPO_CARACTER:
                return "caracter";
            case TIPO_REAL:
                return "real";
        }

        return "";
    }
}
