def solution(my_string):
    s_list=my_string.split()
    sum_=int(s_list.pop(0))
#띄어쓰기를 기준으로 모두 리스트에 나누어 넣음 (숫자a개, 수식a-1개 )
#맨처음 숫자는 전역변수에넣음 -> 두자리 이상은 어떻게 해결할것인가 -> 띄어쓰기로!    
#쓴 숫자는 리스트에서 지움 -> a-1개, a-1개

    for i in range(0,len(s_list),2):
        if s_list[i] == "+":
            sum_+=int(s_list[i+1])
        else:
            sum_-=int(s_list[i+1])
    return sum_
#for 문을 돌릴때는 총 a-1번 반복, 2 간격으로
#if로 문자가 들어가면 수식으로 변환
#첫번째[0] 수식이 +면 두번째[1] 수식을 더해줌 else는 반대의 경우
