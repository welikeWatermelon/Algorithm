def solution(n): #최소 공배수 찾기 6과 n의
    piece = 0
    while True:
        piece+=1
        if float(6*piece/n).is_integer():
            break
    return piece