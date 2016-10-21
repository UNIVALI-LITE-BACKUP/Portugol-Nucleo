programa                                             
{                                                            
    inclua biblioteca Util --> u

    inteiro i = -1

    funcao inicio()                                         
    {                                                       
        inteiro a = 2
        inteiro b = 4
        inteiro m[2][2]
        inteiro v[3] 
        inteiro c = teste(a, m, v) + teste(b, m, v) * a * b
        c = teste(i, m, v)
        c = u.numero_linhas(m)
        c = u.numero_elementos(v)
    }                                                       
    
    funcao inteiro teste(inteiro & x, inteiro matriz[][], inteiro vetor[])                               
    {                                                      
        x = x * 2
        matriz[0][0] = matriz[0][0]
        vetor[0] = vetor[0]
        inteiro teste = -1
        outro_teste(matriz, vetor, teste)
        retorne 1
    }

    funcao outro_teste(inteiro m[][], inteiro v[], inteiro &ref)
    {
        m[0][0] = v[0]
        v[0] = m[0][0]
    }
}
