def solution(sides):
    
    max_=max(sides)
    sum_two=sum(sides)-max_
    if max_<sum_two:
        return 1
    else:
        return 2