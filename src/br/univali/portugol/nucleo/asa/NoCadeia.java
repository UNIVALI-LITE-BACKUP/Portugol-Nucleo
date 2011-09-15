package br.univali.portugol.nucleo.asa;

/**
 * 
 * @author Luiz Fernando Noschang
 * 
 */

public final class NoCadeia extends NoExpressao
{
	private String valor;
	private TrechoCodigoFonte trechoCodigoFonte;
	
	public NoCadeia(String valor)
	{
		this.valor = valor;
		//tratarCadeia();
	}
	
	public String getValor()
	{
		return valor;
	}

    public void setTrechoCodigoFonte(TrechoCodigoFonte trechoCodigoFonte)
    {
        this.trechoCodigoFonte = trechoCodigoFonte;
    }
	
	@Override
	protected TrechoCodigoFonte montarTrechoCodigoFonte()
	{
		return trechoCodigoFonte;
	}
	
    public static void main(String[] args)
    {
        String cadeia = "Eu\n sou \"legal\\\" \nTeste\\\\n";
                
        System.out.println(cadeia);
        System.out.println("");
        System.out.println("");
        //System.out.println(NoCadeia.tratarCadeia(cadeia));
    }
    
	public static String tratarCadeia(String valor)
	{        
        //valor = valor.replace("\\\\", "${SEQ_ESCAPE_BARRA}");
		valor = valor.replace("\\n", "\n");
        valor = valor.replace("\\\"", "\"");
        valor = valor.replace("\\t", "\t");
        
        return valor;
	}
}