def solution(n):
    i=1
    j=n
    answer = 0
    while True:
        if i*j==n:
            answer+=1
            if j==1:
                break
        i+=1
        j=n//i
    return answer