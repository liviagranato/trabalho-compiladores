def testaPrimo(n):
    i =  1
    numDivisores =  0
    
    while(i <= n):
        if (n % i ==  0):
            numDivisores = numDivisores +  1
            
        i = i +  1
        
    
    if (numDivisores ==  2):
        return "Seu número é primo"
        
    else:
        return "Seu número não é primo"
        
    
    return fat
    

def main():
    n = int(input("Digite o valor de n: "))
    print(testaPrimo(n))
    

if __name__ == '__main__':
    main()
