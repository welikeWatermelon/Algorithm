def solution(n):
    i=1
    cnt=1
    numb=1
    while True:
        numb=numb*cnt
        if numb==n:
            break
        elif numb>n:
            cnt-=1
            break
        cnt+=1
    return cnt