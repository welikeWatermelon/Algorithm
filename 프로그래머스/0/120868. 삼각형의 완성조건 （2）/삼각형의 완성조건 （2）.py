def solution(sides):
    cnt=0
    for i in range(max(sides)-min(sides)+1,max(sides)+min(sides)):
        cnt+=1
    return cnt