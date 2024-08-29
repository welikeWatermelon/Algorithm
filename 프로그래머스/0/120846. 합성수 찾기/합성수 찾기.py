def solution(n):
    cnt=0
    if n == 1 or n==2 or n==3:
        return 0
    for j in range(4,n+1): # n까지 전체 숫자 돌기
        for i in range (2, int(j**0.5) + 1):	# j가 소수인지 판별하는 반복문
            if j % i == 0: #소수가 아니지
                cnt+=1
                break
            
    return cnt #1도 뺴줘야함