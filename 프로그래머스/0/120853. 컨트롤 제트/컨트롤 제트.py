def solution(s):
    n_s1=s.split()
    n_s2=s.split()
    for i in range(n_s1.count("Z")):
        a=n_s2.index("Z")
        del n_s2[a-1]
        del n_s2[a-1]
    
            
    return sum(map(int,n_s2))

#1. 공백으로 나눠서 리스트에 넣어줌
#2. Z앞에 있는 숫자와 Z를 동시에 지워줌
#3. 원소를 숫자로(map)으로 바꾼 뒤 sum
