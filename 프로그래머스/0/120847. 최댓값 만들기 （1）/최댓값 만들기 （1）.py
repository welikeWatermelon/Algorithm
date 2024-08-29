def solution(numbers):
    n_numbers=sorted(numbers,reverse=True)
    return n_numbers[0]*n_numbers[1]