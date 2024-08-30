def solution(n):
    answer = []
    i=2
    while i<=n:
        if n%i==0:
            n=n/i
            answer.append(i)
        else:
            i=i+1
    return sorted(list(set(answer)))