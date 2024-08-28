def solution(numbers):
    new_numbers1=numbers[:]
    a=max(new_numbers1)
    new_numbers1.remove(a)
    b=max(new_numbers1)
    sol1=a*b
    
    new_numbers2=numbers[:]
    a=min(new_numbers2)
    new_numbers2.remove(a)
    b=min(new_numbers2)
    sol2=a*b
    
    if sol1>sol2:
        return sol1
    else:
        return sol2