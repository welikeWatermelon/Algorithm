def solution(numbers):
    test = sum(numbers)/len(numbers)
    if test % 0.5 == 0:
        answer = test
    else :
        answer = float(int(test))
    return answer