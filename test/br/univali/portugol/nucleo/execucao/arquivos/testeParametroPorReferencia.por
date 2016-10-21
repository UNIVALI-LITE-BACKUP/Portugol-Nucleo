programa                                             
{                                                            
    inclua biblioteca Util --> u

    funcao inicio()                                         
    {                                                       
        inteiro a = 2
        inteiro b = 4
        inteiro m[2][2]
        inteiro c = teste(a, m) + teste(b, m) * a * b
        c = u.numero_linhas(m)
    }                                                       
    
    funcao inteiro teste(inteiro & x, inteiro matriz[][])                               
    {                                                      
        x = x * 2
        matriz[0][0] = matriz[0][0]
        retorne 1
    }                                                       
}
