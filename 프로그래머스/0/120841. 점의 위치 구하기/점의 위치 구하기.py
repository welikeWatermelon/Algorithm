def solution(dot):
    product = dot[0] * dot[1]
    if product > 0:
        return 1 if dot[0] > 0 else 3  # 1사분면 또는 3사분면
    else:
        return 4 if dot[0] > 0 else 2  # 4사분면 또는 2사분면
