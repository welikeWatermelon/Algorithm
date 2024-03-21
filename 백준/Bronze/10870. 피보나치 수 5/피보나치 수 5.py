#def fibo(fibo_f,fibo_b):
    #fibo_f=fibo_b
    #fibo_b=fibo_f+fibo_b
    #def fibo(fibo_f,fibo_b)

n=int(input())
fibo_f=0
fibo_b=1
for i in range(n):
    fibo_c=fibo_b
    fibo_b=fibo_f+fibo_b
    fibo_f=fibo_c

print(fibo_f)