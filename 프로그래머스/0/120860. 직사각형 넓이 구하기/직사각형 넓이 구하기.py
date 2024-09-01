def solution(dots):
    n_dots=sorted(dots)
    return (n_dots[1][1]-n_dots[0][1])*(n_dots[2][0]-n_dots[0][0])