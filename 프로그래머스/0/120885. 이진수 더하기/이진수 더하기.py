def solution(bin1, bin2):
    # 이진수 문자열을 정수로 변환
    num1 = int(bin1, 2)
    num2 = int(bin2, 2)
    
    # 두 정수를 더함
    result = num1 + num2
    
    # 결과를 이진수 문자열로 변환하고 '0b' 접두사를 제거
    binary_result = bin(result)[2:]
    
    return binary_result