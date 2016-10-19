programa                                             
{                                                            
    funcao inicio()                                         
    {                                                       
        inteiro a = 2
        inteiro b = 4
        inteiro c = teste(a) + teste(b) * a * b
    }                                                       
    
    funcao inteiro teste(inteiro & x)                               
    {                                                      
        x = x * 2
        retorne 1
    }                                                       
}
