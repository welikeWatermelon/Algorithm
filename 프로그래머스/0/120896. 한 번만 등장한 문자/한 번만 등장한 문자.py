def solution(s):
    new_s=list(s)
    set_s=sorted(list(set(s)))
    answer=[]
    for i in set_s:
        if new_s.count(i)==1:
            answer.append(i)
    return ''.join(answer)