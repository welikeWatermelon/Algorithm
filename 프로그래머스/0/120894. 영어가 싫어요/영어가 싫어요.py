def solution(numbers):
    dic={'one':'1','two':'2','three':'3','four':'4','five':'5','six':'6','seven':'7','eight':'8','nine':'9','zero':'0'}
    answer=''
    i=0
    while numbers:
        for length in range(1, 6): 
            if numbers[:length] in dic:
                answer += dic[numbers[:length]]
                numbers = numbers[length:]
                break
    return int(answer)

#처음부터 순서대로 임시의 문자열을 계속해서 추가해서 만듬
#특정 문자가 만들어지면 그 문자는 임시문자열에서 pop 시키고 딕셔너리에서 숫자랑 매칭