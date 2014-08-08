
// ============================== Códigos de instruções ==============================\\

#define HAND_SHAKE 1
#define DEFINIR_MODO_PINO 2
#define DEFINIR_ESTADO_PINO 3 
#define DEFINIR_INTENSIDADE_PINO 4

// ================================== Códigos de erro =================================\\

#define ERRO_INSTRUCAO_INEXISTENTE 1
#define ERRO_NUMERO_PARAMETROS_INCORRETO 2
#define ERRO_TIPO_PARAMETRO_INCORRETO 3

// ================================== Códigos de tipo =================================\\

#define TIPO_CARACTER 1
#define TIPO_INTEIRO 2
#define TIPO_LOGICO 3
#define TIPO_REAL 4

// ============================== Mapeamento de constantes =============================\\

#define MODO_ENTRADA 0
#define MODO_SAIDA 1
#define ESTADO_LIGADO 2
#define ESTADO_DESLIGADO 3

// ======================================= Início =====================================\\

const int VELOCIDADE_CONEXAO = 9600; // Velocidade da conxeão em bauds
const int TIMEOUT_SERIAL = 10000;

const byte INICIALIZADOR_INSTRUCAO = 17;
const byte FINALIZADOR_INSTRUCAO = 20;

const byte INICIALIZADOR_PARAMETRO = 18;
const byte FINALIZADOR_PARAMETRO = 19;

String bufferInstrucao = "";
boolean erro = false;

void setup() 
{
    Serial.begin(VELOCIDADE_CONEXAO);
    Serial.setTimeout(2000);
}

void loop()
{
    if (instrucaoRecebida())
    {    
        int instrucao = decodificarInstrucao(bufferInstrucao);
        String parametros = decodificarParametros(bufferInstrucao);        

        executarInstrucao(instrucao, parametros);
    }
}

void executarInstrucao(int instrucao, String parametros)
{
    erro = false;
    
    switch (instrucao)
    {
        case HAND_SHAKE : 
            handShake();
        break;
        
        case DEFINIR_MODO_PINO : 
            definirModoPino(parametros); 
        break;

        case DEFINIR_ESTADO_PINO :
            definirEstadoPino(parametros);
        break;
        
        default:          
            dispararErroInstrucaoInexistente(instrucao);
        break;
    }
    
    if (!erro)
    {
        enviarResposta(instrucao);
    }
}

void handShake()
{
    // Nada a fazer, serve apenas para sincronizar com o Java
}

void definirModoPino(String parametros)
{
    int parametrosInformados = contarParametros(parametros);
    
    if (parametrosInformados == 2)
    {
        String pino = extrairParametro(parametros);
        String modo = extrairParametro(parametros);
        
        if (valorInteiro(pino))
        {
            if (valorInteiro(modo))
            {
                if (modo.toInt() == MODO_ENTRADA)
                {
                    pinMode(pino.toInt(), INPUT);
                }
                else if (modo.toInt() == MODO_SAIDA)
                {
                    pinMode(pino.toInt(), OUTPUT);
                }
            }
            else dispararErroTipoParametroIncorreto(DEFINIR_MODO_PINO, "modo", TIPO_INTEIRO);
        }
        else dispararErroTipoParametroIncorreto(DEFINIR_MODO_PINO, "pino", TIPO_INTEIRO);
    }
    else dispararErroNumeroParametrosIncorreto(DEFINIR_MODO_PINO, 2, parametrosInformados);
}

void definirEstadoPino(String parametros)
{
    int parametrosInformados = contarParametros(parametros);
    
    if (parametrosInformados == 2)
    {
        String pino = extrairParametro(parametros);
        String estado = extrairParametro(parametros);
        
        if (valorInteiro(pino))
        {
            if (valorInteiro(estado))
            {
                if (estado.toInt() == ESTADO_LIGADO)
                {
                    digitalWrite(pino.toInt(), HIGH);
                }
                else if (estado.toInt() == ESTADO_DESLIGADO)
                {
                    digitalWrite(pino.toInt(), LOW);
                }
            }
            else dispararErroTipoParametroIncorreto(DEFINIR_ESTADO_PINO, "estado", TIPO_INTEIRO);
        }
        else dispararErroTipoParametroIncorreto(DEFINIR_ESTADO_PINO, "pino", TIPO_INTEIRO);
    }
    else dispararErroNumeroParametrosIncorreto(DEFINIR_ESTADO_PINO, 2, parametrosInformados);
}

void enviarResposta(int instrucao)
{
    Serial.print("OK ");
    Serial.print(instrucao);
    Serial.flush();
}

void dispararErroInstrucaoInexistente(int instrucao)
{
    erro = true;
    
    Serial.print("ERRO [");
    Serial.print(ERRO_INSTRUCAO_INEXISTENTE);
    Serial.print(";");
    Serial.print(instrucao);
    Serial.print("]");
    Serial.flush();
}

void dispararErroTipoParametroIncorreto(int instrucao, String nomeParametro, int tipoEsperado)
{
    erro = true;
    
    Serial.print("ERRO [");
    Serial.print(ERRO_TIPO_PARAMETRO_INCORRETO);
    Serial.print(";");
    Serial.print(instrucao);
    Serial.print(";");
    Serial.print(nomeParametro);
    Serial.print(";");
    Serial.print(tipoEsperado);
    Serial.print("]");
    Serial.flush();
}

void dispararErroNumeroParametrosIncorreto(int instrucao, int numeroEsperado, int numeroInformado)
{
    erro = true;
    
    Serial.print("ERRO [");
    Serial.print(ERRO_NUMERO_PARAMETROS_INCORRETO);
    Serial.print(";");
    Serial.print(instrucao);
    Serial.print(";");
    Serial.print(numeroEsperado);
    Serial.print(";");
    Serial.print(numeroInformado);
    Serial.print("]");
    Serial.flush();
}

boolean instrucaoRecebida()
{    
    while (Serial.available())
    {
        byte b = Serial.read();
        char c = (char) b;
        
        if (b == INICIALIZADOR_INSTRUCAO)
        {
            bufferInstrucao = "";
        }
        else if (b == FINALIZADOR_INSTRUCAO)
        {
            return true;
        }
        else
        {
            bufferInstrucao = bufferInstrucao + c;
        }
    }    

    return false;
}

int decodificarInstrucao(String dadosInstrucao)
{
    int inicioParametros = dadosInstrucao.indexOf((char) INICIALIZADOR_PARAMETRO);
    
    if (inicioParametros >= 0)
    {  
        dadosInstrucao = dadosInstrucao.substring(0, inicioParametros);
    }
    
    return dadosInstrucao.toInt();
}

String decodificarParametros(String dadosInstrucao)
{
    String parametros = "";

    int inicioParametros = dadosInstrucao.indexOf((char) INICIALIZADOR_PARAMETRO);
    
    if (inicioParametros >= 0)
    {
        parametros = dadosInstrucao.substring(inicioParametros + 1);        
    }

    return parametros;
}

int contarParametros(String parametros)
{
    int quantidade = 0;
    
    if (parametros.length() > 0)
    {
        int flagParametro = parametros.indexOf((char) FINALIZADOR_PARAMETRO);
        
        while (flagParametro >= 0)
        {
           quantidade = quantidade + 1;
          
           flagParametro = parametros.indexOf((char) FINALIZADOR_PARAMETRO, flagParametro + 1);
        }
    }

    return quantidade;
}

String extrairParametro(String &parametros)
{
    String parametro = "";
    
    if (parametros.length() > 0)
    {
        int flagParametro = parametros.indexOf((char) FINALIZADOR_PARAMETRO);
        
        if (flagParametro > 0)
        {
            parametro = parametros.substring(0, flagParametro);
            parametros = parametros.substring(flagParametro + 2);
        }
    }
    
    return parametro;
}

boolean valorInteiro(String parametro)
{
    if (parametro.length() > 0)
    {
        int inicio = 0;
        
        if (parametro.charAt(0) == '+' || parametro.charAt(0) == '-')
        {
             inicio = 1; 
        }

        for (int i = inicio; i < parametro.length(); i++)
        {
             if (!isDigit(parametro.charAt(i)))
             {
                  return false;
             }
        }

        return true;
    }
    
    return false;
}
