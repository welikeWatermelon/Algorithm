def solution(n):
    answer = 0
    if n % 2 == 1:
        n = n-1 #짝수만들기
    
    for i in range(1,int(n/2)+1): #1부터 중간까지
        answer += 2*i 
        
    return answer