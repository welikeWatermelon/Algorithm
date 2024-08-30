def solution(before, after):
    answer = 1
    for i in range(len(before)):
        if before.count(before[i])!=after.count(before[i]):
            answer = 0
    return answer
#