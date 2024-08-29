def solution(i, j, k):
    cnt=0
    for n in range(i,j+1):
        cnt+=list(str(n)).count(str(k))
    return cnt