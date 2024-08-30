def solution(numbers, k):
    for i in range(k-1):
        numbers=numbers[2:]+numbers[0:2]
    return numbers[0]