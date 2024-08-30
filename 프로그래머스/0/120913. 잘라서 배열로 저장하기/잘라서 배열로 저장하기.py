def solution(my_str, n):
    answer = []
    idn=0
    for i in range(len(my_str)//n):
        answer.append(my_str[idn:idn+n])
        idn+=n
    if len(my_str)%n!=0:
        answer.append(my_str[-(len(my_str)%n):])
    return answer